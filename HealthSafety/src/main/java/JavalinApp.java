import io.javalin.Javalin;
import io.javalin.http.Handler;
import io.javalin.http.Context;

public class JavalinApp {

    static void main(String[] args) {
        Javalin app = Javalin.create().start(7777);
        app.get("/hello",(Context ctx) -> ctx.result("hello world"));
    }
}
