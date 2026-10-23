package client;

import Server.api.clientApi;

import java.time.LocalDate;
import java.time.Month;

public class PatientApp {

    public static void main(String[] args) {
        LocalDate now = LocalDate.of(2020, Month.APRIL, 8);
        CreatePatientRequest patient =  new CreatePatientRequest("cosmo",
                "duma",
                now,
                4.5);


        clientApi client = new clientApi(patient);
        System.out.println(client.payload());
//        System.out.println(client.pa);
//        client.deleteUser("konke");
        PatientResponse user = client.getUser("konke");
        System.out.println(user.getFirstName());

    }
}
