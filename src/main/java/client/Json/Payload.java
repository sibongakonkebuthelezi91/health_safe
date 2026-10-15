package client.Json;

import client.CreatePatientRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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


    public static void post(@NotNull Context context) {
        context.status(201).result("Endpoint working");

    }
    public static void getpost(@NotNull Context context) {
        context.status(200).result("get Endpoint working");
//        come add code
    }
}
