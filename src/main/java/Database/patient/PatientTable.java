package Database.patient;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "patient")
public class PatientTable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "thresh_temperature")
    private Double threTemp;

    @Column(name = "dob")
    private LocalDateTime dob;
    public PatientTable(String firstName, String lastName, Double threTemp) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.threTemp = threTemp;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getThreTemp() {
        return threTemp;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setThreTemp(Double threTemp) {
        this.threTemp = threTemp;
    }

    public PatientTable() {}

}
