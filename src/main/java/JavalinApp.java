import io.javalin.Javalin;

public class JavalinApp {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7777);
        app.get("/",CakesController::getAllCakes);
        app.get("/cakes/{special}", CakesController::getSpecialCakes);
        app.post("/addcake/{added}", CakesController::addCakes);
    }
}
