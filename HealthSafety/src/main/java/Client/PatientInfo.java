package Client;

import java.util.ArrayList;
import java.util.List;

public class PatientInfo {

    private String patientId;
    private String patientName;
    private double threshTemp;
    private List<String> symptoms;

    public  PatientInfo(String patientId, String patientName, double threshTemp) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.threshTemp = threshTemp;
        this.symptoms = new ArrayList<>();
    }

    public String getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public double getThreshTemp() {
        return threshTemp;
    }

    public List<String> getSymptoms() {
        return symptoms;
    }
}
