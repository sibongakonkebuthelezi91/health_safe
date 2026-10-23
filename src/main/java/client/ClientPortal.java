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
        if(getUser.){
            System.out.println("No user was found");
            return false;
        }
        return userInfo.getFirstName().equals(name.toLowerCase());
    }
}
