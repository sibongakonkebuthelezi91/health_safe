package Database.patient;

import jakarta.persistence.*;

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

    public PatientTable(String firstName, String lastName, Double threTemp) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.threTemp = threTemp;
    }

    public PatientTable() {}

}
