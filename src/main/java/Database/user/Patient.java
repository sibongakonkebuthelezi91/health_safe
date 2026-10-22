package Database.user;

import jakarta.persistence.*;

import java.util.UUID;

@Entity(name = "Patient")
@Table(name = "Patient")
public class Patient {
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
    private String dob;

    public Patient(String firstName, String lastName, Double threTemp, String dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.threTemp = threTemp;
        this.dob = dob;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Patient() {}

}
