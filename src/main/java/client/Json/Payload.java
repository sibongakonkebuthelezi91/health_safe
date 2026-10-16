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

public class Payload {

    public static String createPayload(CreatePatientRequest patient){
        ObjectMapper payload = new ObjectMapper();
        try{
            return payload.writeValueAsString(patient);
        } catch (JsonProcessingException e) {
            return "Can not create payload";
        }
    }


    public static void registerPatient(@NotNull Context context) {
        PatientTable user = context.bodyAsClass(PatientTable.class);
        try{
        PatientRepository.savePatient(user);
        context.status(201).result("Patient registered successfully");
        }catch (PatientException e){
            context.status(400);
        }
    }

    public static void getPost(@NotNull Context context) {
        context.status(200).result("get Endpoint working");
    }
}
