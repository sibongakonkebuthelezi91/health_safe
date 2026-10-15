package client.Json;

import client.CreatePatientRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Payload {

    public static String createPayload(CreatePatientRequest patient){
        ObjectMapper payload = new ObjectMapper();
        try{
            return payload.writeValueAsString(patient);
        } catch (JsonProcessingException e) {
            return "Can not create payload";
        }
    }


}
