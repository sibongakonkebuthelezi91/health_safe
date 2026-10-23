package Server;

import io.javalin.Javalin;

public class App {
    public static void main(String[] args) {
        Javalin server = Javalin.create().start(8080);
        Controller controller = new Controller(server);
        controller.readRequest();
    }
}
