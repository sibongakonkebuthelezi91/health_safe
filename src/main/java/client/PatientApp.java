package client;

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
        PatientController controller = new PatientController(patient);
//        controller.sendPayLoad();

    }
}
