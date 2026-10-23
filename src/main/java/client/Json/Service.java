package client.Json;

import Database.user.UserException;
import Database.user.Repository;
import Database.user.Patient;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

public class Service {

    public static void registerPatient(@NotNull Context ctx) {
        Patient user = ctx.bodyAsClass(Patient.class);
        try{
        Repository.savePatient(user);
        ctx.status(201).json(user);
        }catch (UserException e){
            ctx.status(400);
        }
    }

    public static void removePatient(@NotNull Context context){
        String name = context.pathParam("user");
        try{
        Repository.deletePatient(name);
        context.status(200).json(name);
        }catch (UserException e){
            context.status(400);
        }
    }

    public static void getUser(@NotNull Context context){
        String name = context.pathParam("user");
        Patient user = Repository.getPatient(name);
        try{
        if(user == null){
            context.status(404).json("User not found");
        }else {
            context.status(200).json(user);
        }
        }catch (UserException e){
            context.status(400);
        }
    }
    public static void updatePatient(@NotNull Context context){}
    public static void registerDoctor(@NotNull Context ctx) {}

}
