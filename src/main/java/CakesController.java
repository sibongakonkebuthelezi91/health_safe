import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public final class CakesController {

    private CakesController() {}

    static List<String> availableCakes = new ArrayList<>(List.of("carrot cake", "black forest", "Fudge cake"));

    public static void getAllCakes(Context ctx) {
        ctx.json(availableCakes);
    }

    public static void getSpecialCakes(@NotNull Context context) {
        String target = context.pathParam("special").toLowerCase();
        for  (String cake : availableCakes) {
            if(cake.contains(target)) {
                context.json(cake);
                return;
            }
        }
        context.status(404).result("No cake found");
    }


    public static void addCakes(@NotNull Context context) {
        String target = context.pathParam("added").trim();
        if (target.isEmpty())  context.status(400).result("No cake found");
        availableCakes.add(target);
        context.status(201).result("Added cake successfully");

    }
}
