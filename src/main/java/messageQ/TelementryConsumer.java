package messageQ;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

public class TelementryConsumer implements MessageListener {
    private ConnectionBroker broker;
    private String queueName;
    private double feverThreshold;
    private ObjectMapper json;


    public TelementryConsumer(ConnectionBroker broker, String queueName, double feverThreshold, ObjectMapper json){
        this.broker = broker;
        this.queueName = queueName;
        this.feverThreshold = feverThreshold;
        this.json = json;
    }

    @Override
    public void onMessage(Message message) {

    }
}
