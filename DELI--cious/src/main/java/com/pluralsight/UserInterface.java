package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("Welcome to DELI--cious!");
        boolean running = true;

        while (running) {
            System.out.println("\nMain Menu:");
            System.out.print("""
                     1) New Order;
                     2) View Sandwich Prices
                     3) View Drink and Chips Prices
                     0) Exit;
                    """);
            System.out.println("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleNewOrder();
                    break;
                case 2:
                    displaySandwichPrices();
                    break;
                case 3:
                    displayOtherProductPrices();
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

    private void displaySandwichPrices() {
        System.out.println("\nSandwich Prices:");
        System.out.println("");
    }

    private void handleNewOrder() {
        OrderScreen orderScreen = new OrderScreen();
        orderScreen.startOrder();
    }
}

