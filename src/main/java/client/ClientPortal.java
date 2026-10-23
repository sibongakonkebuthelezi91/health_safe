package client;

import Server.api.clientApi;

import java.io.IOException;
import java.time.LocalDate;
import java.util.InputMismatchException;
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

    public boolean createPatient(Scanner input){
        String firstName = names();
        String lastName = names();
        String dob = dob();
        double threshTemp = averageTemperature();
        CreatePatientRequest createPatient = new CreatePatientRequest(firstName,lastName, dob,threshTemp);
        clientApi create =  new clientApi(createPatient);
        try{
        create.createUser();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error creating account check your network");
            return false;
        }
        return true;
    }

    private String names(){
        String name;
        while (true) {
            System.out.print("Please enter your name or surname: ");
            name = scanner.nextLine();
            if (name.length() < 3 ) {
                System.out.println("Invalid names length\n");
                continue;
            } else if (!name.matches("[a-zA-Z]+")) {
                System.out.println("Invalid names format\n");
                continue;
            }
            break;
        }
        return name;
    }

    private String dob(){
        String dateFormat = "\\d{4}-\\d{2}-\\d{2}";
        String dob;
        while (true) {
            System.out.print("Please enter your date of birth: ");
            System.out.println("e.g. yyyy-mm-dd");
            dob = scanner.nextLine();
            if (dob.length() < 10 || !dob.matches(dateFormat)) {
                System.out.println("Invalid date format\n");
                continue;}
            break;
            }
        return dob;
        }

        public double averageTemperature(){
            double temperature;
            while (true) {
                try{
                System.out.print("enter your average temperature: ");
                temperature = scanner.nextDouble();
                if (temperature< 0) {
                    System.out.println("Invalid temperature \n");
                    continue;
                }
                }catch(InputMismatchException e){
                    System.out.println("Invalid temperature\n");
                    scanner.next();
                    continue;
                }
                break;
            }
            return temperature;
        }

    }


