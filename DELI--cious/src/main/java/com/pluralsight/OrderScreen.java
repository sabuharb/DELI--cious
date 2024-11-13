package com.pluralsight;

import java.util.Scanner;

public class OrderScreen {
    private Order order = new Order();
    private Scanner scanner = new Scanner(System.in);

    public void startOrder() {
        boolean ordering = true;

        while (ordering) {
            System.out.println("""
                    \nOrder Menu;
                    1) Add Sandwich;
                    2) Add Drink;
                    3) Add Chips;
                    4) Checkout;
                    0) Cancel Order""");
            System.out.println("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addSandwich();
                    break;
                case 2:
                    addDrink();
                    break;
                case 3:
                    addChips();
                    break;
                case 4:
                    checkout();
                    ordering = false;
                    break;
                case 0:
                    System.out.println("Order canceled. Returning to Home Screen...");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");


            }
        }
    }

    private void addSandwich() {
        System.out.println("Adding a sandwich...");
        // Poner Sandguche con logica de personalizacion detallada
        order.addProduct(new Sandwich("Custom Sandwich", 7.00)); //El Precio de ejemplo
    }

    private void addDrink() {
        System.out.println("Adding a drink...");
        // Poner orden de bebida con logica de personalizaciones
        order.addProduct(new Drink("Drink", 2.50)); //El Precio de ejemplo
    }

    private void addChips() {
        System.out.println("Adding chips...");
        //Poner logica de personalizacion detallada para los chips
    }
    private void checkout() {
        System.out.println("Finalizing order...");
        order.calculateTotal();
        order.generateReceipt();
        System.out.println("Order complete. Returning to Home Screen...");
    }
}
