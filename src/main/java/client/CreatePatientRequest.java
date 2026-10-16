package client;

import java.time.LocalDate;

public class CreatePatientRequest {
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private Double threTemp;

    public CreatePatientRequest(){}

    public CreatePatientRequest(String firstName, String lastName, LocalDate dob,  Double threTemp) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.threTemp = threTemp;
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

    public Double getThreTemp() {
        return threTemp;
    }
}
