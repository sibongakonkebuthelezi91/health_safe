package Database.user;

import jakarta.persistence.*;

import java.util.UUID;

@Entity(name = "assignedDoctor")
@Table
public class AssignedDoctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patientId;


    private UUID doctorId;


    public Long getId() {
        return id;
    }

    public void setId(Long id1) {
        this.id = id1;
    }


}
