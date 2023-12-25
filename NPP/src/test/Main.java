package test;

import Entities.Admin;
import Entities.Worker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin(1, "adminUser", "adminPassword");

        System.out.println("Enter Username:");
        String enteredUsername = scanner.nextLine();

        System.out.println("Enter Password:");
        String enteredPassword = scanner.nextLine();

        if ((enteredPassword.equals(admin.getPassword()) && (enteredUsername.equals(admin.getUsername())))) {

            List<Worker> workers = new ArrayList<>();

            while (true) {
                System.out.print("Do you want to add a new worker? (yes/no): ");
                String answer = scanner.nextLine();

                if (answer.equalsIgnoreCase("no")) {
                    break;
                }

                if (answer.equalsIgnoreCase("yes")) {
                    System.out.println("Enter data for the new worker:");

                    Worker newWorker = addWorker(scanner);

                    if (newWorker != null) {
                        workers.add(newWorker);
                    }
                } else {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                }
            }

            System.out.println("Workers:");
            for (Worker worker : workers) {
                System.out.println(worker);
            }
        } else {
            System.out.println("Incorrect password.");
        }
    }

    private static Worker addWorker(Scanner scanner) {
        System.out.print("ID: ");
        int id = scanner.nextInt();

        scanner.nextLine();

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        if (firstName.equalsIgnoreCase("stop")) {
            return null;
        }

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        return Admin.createWorker(id, firstName, lastName, password);
    }
}
