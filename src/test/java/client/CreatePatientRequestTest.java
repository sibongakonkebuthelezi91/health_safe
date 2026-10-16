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
                LocalDate.now());
        assertEquals("konke", createPatientRequest.getFirstName());
    }

    @Test
    void getLastName() {
        CreatePatientRequest createPatientRequest = new CreatePatientRequest("konke",
                "duma",
                LocalDate.now());
        assertEquals("duma", createPatientRequest.getLastName());
    }

    @Test
    void getDob() {
        CreatePatientRequest createPatientRequest = new CreatePatientRequest("konke",
                "duma",
                LocalDate.now());
        assertEquals(LocalDate.now().toString(), createPatientRequest.getDob());
    }

    @Test
    void PojoClass(){
        CreatePatientRequest createPatientRequest = new CreatePatientRequest("konke", "duma", LocalDate.now());
        String built = payload(createPatientRequest);
//        checking built is not null
        assertFalse(built.isEmpty());

//        check keys are there
        assertTrue(built.contains("firstName"));
        assertTrue(built.contains("lastName"));
        assertTrue(built.contains("dob"));
    }
}