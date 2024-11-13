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
        System.out.printf("4\" Sandwich - $%.2f\n", Pricing.SANDWICH_PRICE_4);
        System.out.printf("8\" Sandwich - $%.2f\n", Pricing.SANDWICH_PRICE_8);
        System.out.printf("12\" Sandwich - $%.2f\n", Pricing.SANDWICH_PRICE_12);

        System.out.println("\nTopping Prices:");
        System.out.printf("Meat (4\") - $%.2f, Extra Meat - $%.2f\n", Pricing.EXTRA_MEAT_PRICE_4);
        System.out.printf("Meat (8\") - $%.2f, Extra Meat - $%.2f\n", Pricing.EXTRA_MEAT_PRICE_8);
        System.out.printf("Meat (12\") - $%.2f, Extra Meat - $%.2f\n", Pricing.EXTRA_MEAT_PRICE_12);

        System.out.printf("Cheese (4\" - $%.2f, Extra Cheese - $%.2f\n", Pricing.CHEESE_PRICE_4, Pricing.EXTRA_CHEESE_PRICE_4);
        System.out.printf("Cheese (8\" - $%.2f, Extra Cheese - $%.2f\n", Pricing.CHEESE_PRICE_8, Pricing.EXTRA_CHEESE_PRICE_8);
        System.out.printf("Cheese (12\" - $%.2f, Extra Cheese - $%.2f\n", Pricing.CHEESE_PRICE_12, Pricing.EXTRA_CHEESE_PRICE_12);

    }
    
        
    System.out.println("\nRegular Toppins and Sauces:");
    System.out.println("Included with Sandwich (lettuce, peppers, onions, tomatoes, etc.)");
    }
    
    private void displayOtherProductPrices() {
        System.out.println("\nOther Product Prices:");
        System.out.printf("Small Drink - $%.2f\n", Pricing.DRINK_SMALL);
        System.out.printf("Medium Drink - $%.2f\n", Pricing.DRINK_MEDIUM);
        System.out.printf("Large Drink - $%.2f\n", Pricing.DRINK_LARGE);
        System.out.printf("Chips - $%.2f\n", Pricing.CHIPS_PRICE);
    }

private void handleNewOrder() {
    OrderScreen orderScreen = new OrderScreen();
    orderScreen.startOrder();
    
}

