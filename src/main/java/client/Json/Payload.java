package client.Json;

import Database.patient.PatientRepository;
import Database.patient.PatientTable;
import client.CreatePatientRequest;
import client.PatientResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
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

        PatientRepository.savePatient(user);

    }
    public static void getpost(@NotNull Context context) {
        context.status(200).result("get Endpoint working");
//        come add code
    }
}
