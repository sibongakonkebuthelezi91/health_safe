package client;

import io.javalin.Javalin;

public class ControllerApp {
    public static void main(String[] args) {
        Javalin server = Javalin.create().start(8080);
        PatientController controller = new PatientController(server);
        controller.sendPayLoad();
    }
}
