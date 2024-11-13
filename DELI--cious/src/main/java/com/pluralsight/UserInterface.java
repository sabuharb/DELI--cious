package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);

    public void displayHomeScreen() {
        System.out.println("Welcome to DELI-cious!");
        boolean running = true;

        while (running) {
            System.out.print("""
                     1) New Order;
                     0) Exit;
                    """);
            System.out.println("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleNewOrder();
                    break;
                case 0:
                    running = false;
                    System.out.println("Thank you for using DELI--cious!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}


