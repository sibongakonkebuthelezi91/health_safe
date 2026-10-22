package client;

import client.Json.PatientService;
import io.javalin.Javalin;

public class PatientController {
    private Javalin app;

    public PatientController(Javalin app) {
        this.app = app;
    }


    public void sendPayLoad() {
        app.post("/registerpatient", PatientService::registerPatient);
        app.delete("/removeuser/{user}", PatientService::removePatient);
    }
}
