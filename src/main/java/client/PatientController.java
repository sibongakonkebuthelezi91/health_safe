package client;

import io.javalin.Javalin;

public class                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     PatientController {
    private CreatePatientRequest patientRequest;

    public PatientController(CreatePatientRequest patientRequest) {
        this.patientRequest = patientRequest;
    }

    public void sendPayLoad(Javalin app) {
        app.post("api/v1/patients", ctx -> ctx.bodyAsClass(patientRequest.getClass()));

    }
}
