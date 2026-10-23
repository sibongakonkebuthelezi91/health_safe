package client;

import Server.api.clientApi;

import java.util.Scanner;

public class ClientPortal {
    private Scanner scanner = new Scanner(System.in);
    private PatientResponse userInfo;

    public ClientPortal(PatientResponse userInfo) {
        this.userInfo = userInfo;
    }

    public boolean Authenticate(String name){
        PatientResponse getUser = new clientApi().getUser(name);
        if(getUser == null){
            System.out.println("No user was found");
            return false;
        }
        return userInfo.getFirstName().equalsIgnoreCase(name);
    }

    public CreatePatientRequest createPatient(Scanner input){
        String firstName, lastName, dob, threTemp;
        firstName = name();
        System.out.println(firstName);
        return null;
    }

    private String name(){
        String name;
        while (true) {
            System.out.print("Please enter your name: ");
            name = scanner.nextLine();
            if (name.length() < 3 ) {
                System.out.println("Invalid name length\n");
                continue;
            } else if (!name.matches("[a-zA-Z]+")) {
                System.out.println("Invalid name format\n");
                continue;
            }
            break;
        }
        return name;
    }
}
