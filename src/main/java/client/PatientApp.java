package client;

import Database.user.clientApi;

import java.time.LocalDate;
import java.time.Month;

public class PatientApp {

    public static void main(String[] args) {
        LocalDate now = LocalDate.of(2020, Month.APRIL, 8);
        CreatePatientRequest patient =  new CreatePatientRequest("konke",
                "duma",
                now,
                4.5);


        clientApi client = new clientApi(patient);
        System.out.println(client.payload());
        //        client.sendPayLoad("http://localhost:8080/registerpatient");
        client.deleteUser("konke");


    }
}
