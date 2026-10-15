package client;

import io.javalin.Javalin;

public class PatientController {
    private CreatePatientRequest patientRequest;
    private Javalin server;

    public PatientController(CreatePatientRequest patientRequest, Javalin server) {
        this.patientRequest = patientRequest;
        this.server = server;
    }


    private String createPayload(){
        
    }

    public void sendPayLoad(Javalin app) {
        app.post("api/v1/patients", ctx -> ctx.bodyAsClass(patientRequest.getClass()));
    }
}
