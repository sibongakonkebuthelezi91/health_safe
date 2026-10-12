package client;

import java.time.LocalDate;
import java.util.UUID;

public class PatientResponse {
    private UUID id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private UUID assignedDoctorId;
    private double currentBaseLineBpm;


}
