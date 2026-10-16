package client.Json;

import Database.patient.PatientException;
import Database.patient.PatientRepository;
import Database.patient.PatientTable;
import client.CreatePatientRequest;
import client.PatientResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.sun.tools.jconsole.JConsoleContext;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

public class PatientService {

    public static void registerPatient(@NotNull Context context) {
        PatientTable user = context.bodyAsClass(PatientTable.class);
        try{
        PatientRepository.savePatient(user);
        context.status(201).json(user);
        }catch (PatientException e){
            context.status(400);
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
