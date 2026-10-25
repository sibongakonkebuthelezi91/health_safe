package messageQ;
import jakarta.jms.Connection;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSException;
import jakarta.jms.Session;
import org.apache.activemq.ActiveMQConnectionFactory;
public class ConnectionBroker implements AutoCloseable{

    private Connection connect ;
    private ConnectionFactory manager;
    private String url = "tcp://localhost:61616";
    private final String  password;
    private final String username;


    public ConnectionBroker(String username, String password){
        this.username = username;
        this.password = password;
        this.manager = new ActiveMQConnectionFactory(url);
    }

    public void connect(){
        if(this.connect != null) return;
        try{
        this.connect = manager.createConnection(this.username, this.password);
        this.connect.setExceptionListener( exception -> { System.err.println("[ActiveMQ error connecting " +
                "to the network]");});
        this.connect.start();
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

    public Session createSession() throws IllegalStateException {
        if(this.connect == null) throw new IllegalStateException("No connection established run connection() first");
        try{
        return this.connect.createSession(false, Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            throw new RuntimeException("Failed to create session");
        }
    }


    @Override
    public void close() throws Exception {
        if(this.connect != null) {
            try{
                connect.close();
            } catch (JMSException e) {
                throw new RuntimeException("Can not close session ");
            }
        }
    }
}
