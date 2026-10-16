package client;

import client.Json.Payload;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.javalin.Javalin;

import java.util.HashMap;

public class PatientController {
    private CreatePatientRequest patientRequest;
    private Javalin server;

    public PatientController(CreatePatientRequest patientRequest, Javalin server) {
        this.patientRequest = patientRequest;
        this.server = server;
    }


    public void sendPayLoad(Javalin app) {
        app.post("/registerPatient", Payload::registerPatient);

    }
}
