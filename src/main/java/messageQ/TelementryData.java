package messageQ;

import java.time.LocalDate;

public class TelementryData {

    private String patientId;
    private String[] symptoms;
    private String doctorId;
    private LocalDate timestamp;

    public TelementryData(String doctorId, String patientId, LocalDate timestamp, String[] symptoms){
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.timestamp = timestamp;
        this.symptoms = symptoms;
    }

    public TelementryData(){}

    public String getPatientId() {
        return patientId;
    }

    public String[] getSymptoms() {
        return symptoms;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }


}
