package client;

import Server.api.clientApi;
import java.util.Scanner;

public class UserApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String portal = choices(scanner);
        System.out.println(portal);
    }

    private static String choices(Scanner input) {
        String choice;
        while (true) {
            System.out.println("Choose your choice : ");
            System.out.println("[1] Doctor");
            System.out.println("[2] Patient");
            choice = input.nextLine();
            if (choice.equals("1") || choice.equals("2")) {
                break;
            }
            input.nextLine();
        }
        return choice;
    }
}
