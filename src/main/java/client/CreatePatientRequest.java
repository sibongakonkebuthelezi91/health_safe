package client;

import java.time.LocalDate;
import java.util.UUID;

public class CreatePatientRequest {
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private UUID doctorId;

    public CreatePatientRequest(){}

    public CreatePatientRequest(String firstName, String lastName, LocalDate dob, UUID doctorId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.doctorId = doctorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public UUID getDoctorId() {
        return doctorId;
    }

    public String incomingPayload() {
        return "";
    }
}
