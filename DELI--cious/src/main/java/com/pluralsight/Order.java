package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    private ArrayList<Sandwich> sandwiches = new ArrayList<>();
    private ArrayList<Drink> drinks = new ArrayList<>();
    private ArrayList<Chips> chips = new ArrayList<>();

    public void startOrder() {
        Scanner scanner = new Scanner(System.in);
        boolean ordering = true;

        while (ordering) {
            System.out.println("┍━━━━━━━━━━━━━━━━━»•» \uD83C\uDF3A«•«━┑");
            System.out.println("   -ˏˋ⋆ ᴡ ᴇ ʟ ᴄ ᴏ ᴍ ᴇ ⋆ˊˎ-");
            System.out.println("      to DELI--cious!\uD83D\uDC69\uD83C\uDFFB\u200D\uD83C\uDF73");
            System.out.println("┕━»•» \uD83C\uDF3A«•«━━━━━━━━━━━━━━━━━;┙");

            System.out.println("1) Add Sandwich\n2) Add Drink\n3) Add Chips\n4) Checkout\nChoose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addSandwich(scanner);
                case 2 -> addDrink(scanner);
                case 3 -> chips.add(new Chips("Regular"));
                case 4 -> {
                    displayOrderDetails();
                    saveReceipt();
                    ordering = false;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void addSandwich(Scanner scanner) {
        System.out.println("Choose size: 1) 4\" 2) 8\" 3) 12\"");
        int size = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Choose bread: 1) White 2) Wheat 3) Rye 4) Wrap");
        String bread = switch (scanner.nextInt()) {
            case 1 -> "White";
            case 2 -> "Wheat";
            case 3 -> "Rye";
            case 4 -> "Wrap";
            default -> "White";
        };
        scanner.nextLine();

        System.out.println("Extra Meat? (y/n)");
        boolean extraMeat = scanner.nextLine().equalsIgnoreCase("y");

        System.out.println("Extra Cheese? (y/n)");
        boolean extraCheese = scanner.nextLine().equalsIgnoreCase("y");

        sandwiches.add(new Sandwich(size, bread, extraMeat, extraCheese));
    }

    private void addDrink(Scanner scanner) {
        System.out.println("Choose drink size: 1) Small 2) Medium 3) Large");
        int size = scanner.nextInt();
        drinks.add(new Drink(size));
    }

    private void displayOrderDetails() {
        double total = 0;
        System.out.println("Order Summary:");
        for (Sandwich sandwich : sandwiches) {
            System.out.println(sandwich);
            total += sandwich.calculatePrice();
        }
        for (Drink drink : drinks) {
            System.out.println(drink);
            total += drink.getPrice();
        }
        for (Chips chip : chips) {
            System.out.println("Chips - $" + Pricing.getChipsPrice());
            total += Pricing.getChipsPrice();
        }
        System.out.println("Total Cost: $" + total);
    }

    private void saveReceipt() {
        Receipt receipt = new Receipt();
        receipt.saveOrder(sandwiches, drinks, chips);
    }
}