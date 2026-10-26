package Database.user;

import jakarta.persistence.*;

@Entity
@Table(name = "alert_doctor")
public class alertDoctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @ManyToOne(fetch = FetchType.LAZY)

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


}
