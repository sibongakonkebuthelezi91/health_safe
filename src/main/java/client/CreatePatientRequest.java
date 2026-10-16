package client;

import java.time.LocalDate;
import java.util.UUID;

public class CreatePatientRequest {
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private Double threTemp;

    public CreatePatientRequest(){}

    public CreatePatientRequest(String firstName, String lastName, LocalDate dob,  Double thretemp) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.threTemp = thretemp;
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

    public Double getThretemp() {
        return threTemp;
    }
}
