package Database.patient;

import client.CreatePatientRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class clientApi {
    private HttpClient client = HttpClient.newHttpClient();
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

    public void sendPayLoad(String targetUrl) throws IOException, InterruptedException {
        String payload = this.payload();

//        Building request to send out
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(targetUrl))
                .header("content-type", "application/json")
                .header("Accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(payload))
                .build();
        HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        if (response.statusCode() == 200 || response.statusCode() == 201) {
            System.out.println("Successfully sent request to " + targetUrl);
        }
        else {
            System.out.println("Failed to send request to " + targetUrl);
        }
    }

    public void deleteUser(String name){
        String url = "http://localhost:8080/users/{" + name + "}";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create())
    }

}
