package client;

import client.Json.PatientService;
import io.javalin.Javalin;

public class PatientController {
    private Javalin server;

    public PatientController(Javalin server) {
        this.server = server;
    }


    public void sendPayLoad(Javalin app) {
        app.post("/registerpatient", PatientService::registerPatient);
    }
}
