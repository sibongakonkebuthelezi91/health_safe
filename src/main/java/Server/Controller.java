package Server;

import client.Json.Service;
import io.javalin.Javalin;

public class Controller {
    private Javalin app;

    public Controller(Javalin app) {
        this.app = app;
    }


    public void readRequest() {
//        Routes for patient users
        app.post("/registerpatient", Service::registerPatient);
        app.delete("/removeuser/{user}", Service::removePatient);
        app.patch("/edituser", Service::updatePatient);
        app.get("/getuser/{user}", Service::getUser);

//        Routes for doctors

    }
}
