package client;

import java.time.LocalDate;
import java.util.UUID;

public class PatientResponse {
    private UUID id;
    private String firstName;
    private String lastName;
    private String dob;
    private Double threTemp;

    public PatientResponse(){}

    public PatientResponse(UUID id, String firstName, String lastName, String dob,  Double threTemp) {
        this.id = id;
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
        return dob;
    }

    public Double getThreTemp() {
        return threTemp;
    }

    public UUID getId() {
        return id;
    }
}
