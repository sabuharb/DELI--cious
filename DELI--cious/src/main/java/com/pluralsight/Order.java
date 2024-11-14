package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    private ArrayList<Sandwich> sandwiches = new ArrayList<>();
    private ArrayList<Drink> drinks = new ArrayList<>();
    private ArrayList<Chips> chips = new ArrayList<>();

    // Muestra articulos para ordenar y para checkout
    public void showOrderMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean ordering = true;
        while (){
            System.out.println("""
                    Order Menu:;
                    1) Add Sandwich;
                    2) Add Drink;
                    3) Add Chips;
                    4) Checkout;
                    
                    Choose and option: ;
                    """);

            int choice = scanner.nextInt();
            switch (choice){
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
                    displayOrderDetails();
                    generateReceipt();
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Agrega el sandwich a la orden
    private void addSandwich() {
        Sandwich sandwich = new Sandwich("8\"", "White," new ArrayList<>(), false); //pone la orden
        sandwiches.add(sandwich);
    }
    private void addDrink() {
        Drink drink = new Drink("Medium");
        drinks.add(drink);
    }
    private void addChips(){
        Chips chip = new Chips("Regular");
        chips.add(chip);
    }

    // Muestra detalles de la orden y Calcula el costo total
    private void displayOrderDetails(){
        double total = 0;
        System.out.println("Order Summary:");

        for (Sandwich s : sandwiches) {
            s.displayDetails();
            total += s.getPrice();
        }

        for (Drink d : drinks) {
            d.displayDetails();
            total += d.getPrice();
        }

        for (Chips c : chips) {
            c.displayDetails();
            total += c.getPrice();
        }

        System.out.println("Total Cost: $" + total);
    }

    // Genera un recibo y lo guarda
    private void generateReceipt() {
        Receipt receipt = new Receipt();
        receipt.saveOrder(sandwiches, drinks, chips);
    }
}
