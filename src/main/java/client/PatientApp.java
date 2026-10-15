package client;

import io.javalin.Javalin;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.UUID;

public class PatientApp {

    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        LocalDate now = LocalDate.of(2020, Month.APRIL, 8);
        CreatePatientRequest patient =  new CreatePatientRequest("konke",
                "duma",
                now,
                uuid);
        Javalin server = Javalin.create().start(8080);
        PatientController controller = new PatientController(patient, server);
        controller.sendPayLoad(server);

    }
}
