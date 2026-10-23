package Server.api;

import client.CreatePatientRequest;
import client.PatientResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class clientApi {
    private HttpClient client = HttpClient.newHttpClient();
    private CreatePatientRequest patientRequest;

    public clientApi(CreatePatientRequest patientRequest) {
        this.patientRequest = patientRequest;
    }

    public clientApi() {}

    public String payload() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this.patientRequest);
        } catch (JsonProcessingException e) {
            return "{\"message\":\"error occurred while processing request\"}";
        }
    }

    public HttpClient getClient() {
        return client;
    }

    public void createUser(String targetUrl) throws IOException, InterruptedException {
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
        } else {
            System.out.println("Failed to send request to " + targetUrl);
        }
    }

    public void deleteUser(String name) {
        String encodeName = URLEncoder.encode(name, StandardCharsets.UTF_8);
        String url = "http://localhost:8080/removeuser/" + encodeName;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .DELETE()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200 || response.statusCode() == 201)
                System.out.println("Successfully deleted account");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public PatientResponse getUser(String name) {
        PatientResponse user = null;
        Gson gson = new Gson();
        String encodeName = URLEncoder.encode(name, StandardCharsets.UTF_8);
        String url = "http://localhost:8080/getuser/" + encodeName;
        try {
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                user = gson.fromJson(response.body(), PatientResponse.class);
            }
        } catch (InterruptedException | IOException e) {
            System.out.println("Failed to get user check network");
            return null;
        }
        return user;
    }

}
