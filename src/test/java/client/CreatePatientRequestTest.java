package client;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CreatePatientRequestTest {

    private String payload(CreatePatientRequest createPatientRequest) {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            return objectMapper.writeValueAsString(createPatientRequest);}
        catch(Exception e){
            return "could not serialize CreatePatientRequest";
        }
    }
    @Test
    void getFirstName() {
        CreatePatientRequest createPatientRequest = new CreatePatientRequest("konke",
                "duma",
                "1993-03-29", 4.3);
        assertEquals("konke", createPatientRequest.getFirstName());
    }

    @Test
    void getLastName() {
        CreatePatientRequest createPatientRequest = new CreatePatientRequest("konke",
                "duma",
                "1993-03-29", 4.3);
        assertEquals("duma", createPatientRequest.getLastName());
    }

    @Test
    void getDob() {
        CreatePatientRequest createPatientRequest = new CreatePatientRequest("konke",
                "duma",
                "1993-03-29", 3.4);
        assertEquals("1993-03-29", createPatientRequest.getDob());
    }

    @Test
    void PojoClass(){
        CreatePatientRequest createPatientRequest = new CreatePatientRequest("konke",
                "duma",
                "1993-03-29",
                4.5);
        String built = payload(createPatientRequest);
//        checking built is not null
        assertFalse(built.isEmpty());

//        check keys are there
        assertTrue(built.contains("firstName"));
        assertTrue(built.contains("lastName"));
        assertTrue(built.contains("dob"));
    }
}