package Database.patient;

import client.CreatePatientRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class clientApi {
    private HttpClient client;
    private String url;
    private CreatePatientRequest patientRequest;

    public clientApi(CreatePatientRequest patientRequest) {
        this.patientRequest = patientRequest;
    }

    public String payload(){
        ObjectMapper mapper = new ObjectMapper();
        try{
        return mapper.writeValueAsString(this.patientRequest);
        } catch (JsonProcessingException e) {
            return "{\"message\":\"error occurred while processing request\"}";
        }
    }

    public HttpClient getClient() {
        return client;
    }

    public void sendPayLoad(String targetUrl) {
        this.client = HttpClient.newHttpClient();
        String payload = this.payload();

//        Building request to send out
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(targetUrl))
                .header("content-type", "application/json")
                .header("Accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(payload))
                .build();


    }

}
