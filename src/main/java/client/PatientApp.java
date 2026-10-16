package client;

import io.javalin.Javalin;
import Database.patient.clientApi;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.UUID;

public class PatientApp {

    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        LocalDate now = LocalDate.of(2020, Month.APRIL, 8);
        CreatePatientRequest patient =  new CreatePatientRequest("konke",
                "duma",
                now,
                4.5);


        clientApi client = new clientApi(patient);
        System.out.println(client.payload());
        try{
        client.sendPayLoad("http://localhost:8080/registerpatient");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Interrupted: " + e.getMessage());
        }

    }
}
