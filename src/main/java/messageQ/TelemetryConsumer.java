package messageQ;


import jakarta.jms.Message;
import jakarta.jms.MessageListener;

public class TelemetryConsumer implements MessageListener {
    private ConnectionBroker broker;
    private String queueName;




    @Override
    public void onMessage(Message message) {

    }
}
