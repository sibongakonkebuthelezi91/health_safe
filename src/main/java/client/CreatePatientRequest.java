package client;

import java.time.LocalDate;
import java.util.UUID;

public class CreatePatientRequest {
    private String firstName;
    private String lastName;
    private LocalDate dob;

    public CreatePatientRequest(){}

    public CreatePatientRequest(String firstName, String lastName, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDob() {
        return dob.toString();
    }


}
