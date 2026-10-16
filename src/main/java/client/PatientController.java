package client;

import client.Json.Payload;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.javalin.Javalin;

import java.util.HashMap;

public class PatientController {
    private Javalin server;

    public PatientController(Javalin server) {
        this.server = server;
    }


    public void sendPayLoad(Javalin app) {
        app.post("/registerpatient", Payload::registerPatient);

    }
}
