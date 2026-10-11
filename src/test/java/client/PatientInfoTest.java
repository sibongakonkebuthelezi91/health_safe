package client;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientInfoTest {

    PatientInfo patientInfo = new PatientInfo("0344", "konke", 38.9);
    @Test
    void getPatientId() {
        assertEquals("0344", patientInfo.getPatientId());
    }

    @org.junit.jupiter.api.Test
    void getPatientName() {
        assertEquals("konke", patientInfo.getPatientName());
    }

    @org.junit.jupiter.api.Test
    void getThreshTemp() {
        assertEquals(38.9, patientInfo.getThreshTemp(), 0.01);
    }

}