package messageQ;

import com.fasterxml.jackson.databind.ObjectMapper;

public class messageApp {
    public  static void main(String[] args) {
    ObjectMapper mapper = new ObjectMapper();
    ConnectionBroker broker = new ConnectionBroker("admin", "admin");
    TelemetryProducer producer = new TelemetryProducer(broker, mapper);
    broker.connect();
//    broker.createSession();
        System.out.println(producer.sendTelemetry("Hello world"));
    }
}
