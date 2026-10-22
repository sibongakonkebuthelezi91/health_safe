package client.Json;

import Database.user.PatientException;
import Database.user.PatientRepository;
import Database.user.PatientTable;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

public class PatientService {

    public static void registerPatient(@NotNull Context ctx) {
        PatientTable user = ctx.bodyAsClass(PatientTable.class);
        try{
        PatientRepository.savePatient(user);
        ctx.status(201).json(user);
        }catch (PatientException e){
            ctx.status(400);
        }
    }


    public static void removePatient(@NotNull Context context){
        String name = context.pathParam("user");
        try{
        PatientRepository.deletePatient(name);
        context.status(200).json(name);
        }catch (PatientException e){
            context.status(400);
        }
    }




}
