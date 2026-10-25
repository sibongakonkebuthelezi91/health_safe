package messageQ;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.jms.*;

public class TelemetryProducer {
    private  final ConnectionBroker broker;
    private final ObjectMapper json;
    private final String queueName = "vitals.telemetry";
    public TelemetryProducer(ConnectionBroker broker, ObjectMapper json){
        this.broker = broker;
        this.json = json;
    }


    public String sendTelemetry(String rawJson){
        try(Session session = broker.createSession()){
            Destination path = session.createQueue(queueName);
            try(MessageProducer producer = session.createProducer(path)){
                TextMessage message = session.createTextMessage(rawJson);
                producer.send(message);
            }
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
        return "";
    }
}
