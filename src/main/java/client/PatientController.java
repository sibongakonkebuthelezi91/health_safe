package client;

import client.Json.Service;
import io.javalin.Javalin;

public class PatientController {
    private Javalin app;

    public PatientController(Javalin app) {
        this.app = app;
    }


    public void sendPayLoad() {
        app.post("/registerpatient", Service::registerPatient);
        app.delete("/removeuser/{user}", Service::removePatient);
//        app.get("/getuser", )
    }
}
