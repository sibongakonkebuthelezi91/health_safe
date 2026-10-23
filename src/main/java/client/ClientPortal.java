package client;

import java.util.Scanner;

public class ClientPortal {
    private Scanner scanner = new Scanner(System.in);
    private PatientResponse userInfo;

    public ClientPortal(PatientResponse userInfo) {
        this.userInfo = userInfo;
    }

    public boolean Authenticate(String name){

        if(name.isEmpty()){
            System.out.println("Please enter your name");
            return false;
        }
        return userInfo.getFirstName().equals(name.toLowerCase());
    }
}
