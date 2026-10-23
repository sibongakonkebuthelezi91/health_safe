package client;

import Server.api.clientApi;
import java.util.Scanner;

public class UserApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String portal = choices(scanner);

        if (portal.trim().equals("1")) {
            new ClientPortal(new PatientResponse());
        }
    }

    private static String choices(Scanner input) {
        String choice;
        while (true) {
            System.out.println("Choose your choice : ");
            System.out.println("[1] Patient");
            System.out.println("[2] Doctor");
            System.out.print("choice: ");
            choice = input.nextLine();
            if (choice.equals("1") || choice.equals("2")) {
                break;
            }
            System.out.println("Invalid choice\n");
        }
        return choice;
    }
}
