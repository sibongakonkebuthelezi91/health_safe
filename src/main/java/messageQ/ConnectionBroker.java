package messageQ;
import jakarta.jms.Connection;
import jakarta.jms.ConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
public class ConnectionBroker {

    private Connection connect ;
    private ConnectionFactory manager;
    private String url = "tcp://localhost:61616";
    private String password;
    private String username;


    public ConnectionBroker(String username, String password){
        this.username = username;
        this.password = password;
        this.manager = new ActiveMQConnectionFactory(url);
    }

}
