package Database.user;

import jakarta.persistence.*;

@Entity
@Table(name = "allocated_doctor")
public class AllocatedDoctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_allocated_patient"))
    private Patient patient;


    @ManyToOne
    @JoinColumn(name = "doctor_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_allocated_doctor"))
    private Doctor doctor;

    public AllocatedDoctor(){}

    public AllocatedDoctor(Doctor doctor, Patient patient){
        this.doctor = doctor;
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
