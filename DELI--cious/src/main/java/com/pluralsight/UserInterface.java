package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
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
                case
            }
        }
    }

}
