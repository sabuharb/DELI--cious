package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    private static int orderCount = 0; // Tracks the number of orders, used for unique order numbers
    private static ArrayList<Order> orderHistory = new ArrayList<>(); // Stores all completed orders

    private final int orderNumber; // Unique order identifier
    private final ArrayList<Sandwich> sandwiches = new ArrayList<>();
    private final ArrayList<Drink> drinks = new ArrayList<>();
    private final ArrayList<Chips> chips = new ArrayList<>();
    private double totalCost = 0;

    public Order() {
        this.orderNumber = ++orderCount; // Assign a unique order number to each new order
    }

    public void startOrder() {
        Scanner scanner = new Scanner(System.in);
        boolean ordering = true;

        System.out.println("┍━━━━━━━━━━━━━━━━━━━━»•» 🌸 «•«━┑");
        System.out.println("  🌷Welcome to DELI--cious! 🌷");
        System.out.println("   Build your perfect meal 🍽️🥤 ");
        System.out.println("┕━»•» 🌸 «•«━━━━━━━━━━━━━━━━━━━━┙");
        System.out.println("      ૮₍´˶• . • ⑅ ₎ა   ");

        while (ordering) {
            int choice = getValidatedChoice(scanner, """
                    🌟 Menu:
                    1) 🥪 Add Custom Sandwich
                    2) ⭐ Add Signature Sandwich
                    3) 🥤 Add Drink
                    4) 🍟 Add Chips
                    5) 💳 Checkout/ Pay
                    6) 📜 View Order History
                    ---------------------------------
                 
                    Please enter your choice: """, 1, 6);

            switch (choice) {
                case 1 -> addCustomSandwich(scanner);
                case 2 -> addSignatureSandwich(scanner);
                case 3 -> addDrink(scanner);
                case 4 -> addChips(scanner);
                case 5 -> {
                    displayOrderDetails();
                    saveReceipt();
                    orderHistory.add(this); // Save the completed order to history
                    ordering = false;

                    // Ask if the user wants to return to the main menu
                    System.out.println("🔄 Do you want to go back to the main menu? (y/n)");
                    String response = scanner.nextLine().trim().toLowerCase();
                    if (!response.equals("y")) {
                        ordering = false; // Exit the loop if the user doesn't want to continue
                    }
                }
                case 6 -> displayOrderHistory();
            }
        }
    }

    private int getValidatedChoice(Scanner scanner, String prompt, int min, int max) {
        int choice = -1;
        while (choice < min || choice > max) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } else {
                System.out.println("❌ Invalid input. Please enter a number between " + min + " and " + max + ".");
                scanner.next(); // Clear invalid input
            }
        }
        return choice;
    }

    private void addCustomSandwich(Scanner scanner) {
        System.out.println("┍━━━━━━━━━━━━━━━━━━━━━━»•» 🌸 «•«━┑");
        System.out.println("🌟 Build Your Custom Sandwich 🌟");
        System.out.println("┕━»•» 🌸 «•«━━━━━━━━━━━━━━━━━━━━━━┙");

        // Sandwich Size
        int size = getValidatedChoice(scanner, """
                Choose your bread size:
                 1) 4\" 
                 2) 8\" 
                 3) 12\"
                 Please enter your choice: """, 1, 3);
        System.out.println("=================================");


        // Bread Type
        String bread = switch (getValidatedChoice(scanner, """
            ┍━━━━━━━━━━━━━━━━━━━━━━»•» 🌸 «•«━┑
                  Choose your bread type:
            ┕━»•» 🌸 «•«━━━━━━━━━━━━━━━━━━━━━━┙
            
             1) White
             2) Wheat
             3) Rye
             4) Wrap
            
             Please enter your choice:""", 1, 4)) {
            case 1 -> "White";
            case 2 -> "Wheat";
            case 3 -> "Rye";
            case 4 -> "Wrap";
            default -> "White";
        };
        System.out.println("=================================");
        // Meats
        System.out.println("┍━━━━━━━━━━━━━━━━━━━━━━»•» 🌸 «•«━┑");
        System.out.println("     🥩Choose your meats 🍗");
        System.out.println(" ->type 'done' to finish<- ");
        System.out.println("┕━»•» 🌸 «•«━━━━━━━━━━━━━━━━━━━━━━┙");

       
        ArrayList<String> meats = selectToppings(scanner, new String[]{"Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon"});
        System.out.println("=================================");
        // Cheeses
        System.out.println("┍━━━━━━━━━━━━━━━━━━━━━━»•» 🌸 «•«━┑");
        System.out.println("     Choose your Cheeses 🧀");
        System.out.println(" ->type 'done' to finish<- ");
        System.out.println("┕━»•» 🌸 «•«━━━━━━━━━━━━━━━━━━━━━━┙");
        ArrayList<String> cheeses = selectToppings(scanner, new String[]{"American", "Provolone", "Cheddar", "Swiss"});
        System.out.println("=================================");
        // Veggies
        System.out.println("┍━━━━━━━━━━━━━━━━━━━━━━»•» 🌸 «•«━┑");
        System.out.println("     Choose your Veggies 🥬");
        System.out.println(" ->type 'done' to finish<- ");
        System.out.println("┕━»•» 🌸 «•«━━━━━━━━━━━━━━━━━━━━━━┙");
        ArrayList<String> veggies = selectToppings(scanner, new String[]{"Lettuce", "Tomato", "Onions", "Peppers", "Cucumbers", "Pickles", "Jalapenos"});
        System.out.println("=================================");
        // Toast Option
        System.out.println("┍━━━━━━━━━━━━━━━━━━━━━━━━━»•» 🌸 «•«━┑");
        System.out.println("  🔥 Do you want it toasted? (y/n)");
        System.out.println("┕━»•» 🌸 «•«━━━━━━━━━━━━━━━━━━━━━━━━━┙");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("y");

        sandwiches.add(new Sandwich(size, bread, meats, cheeses, veggies, toasted));
    }

    private ArrayList<String> selectToppings(Scanner scanner, String[] options) {
        ArrayList<String> selected = new ArrayList<>();

        while (true) {
            // Display available options at the top each time
            System.out.println("\n🌟 Available options:");
            for (String option : options) {
                System.out.println("   • " + getEmojiForTopping(option) + " " + option); // Display each option with an emoji
            }
            System.out.println("\n✨ Type the name of the topping to add it (type 'done' to finish):");

            System.out.print("👉 Your choice: ");
            String choice = scanner.nextLine().trim();

            if (choice.equalsIgnoreCase("done")) {
                break;
            }

            boolean validChoice = false;
            for (String option : options) {
                if (option.equalsIgnoreCase(choice)) {
                    selected.add(option);
                    System.out.println("✅ Added: " + getEmojiForTopping(option) + " " + option);
                    validChoice = true;
                    break;
                }
            }

            if (!validChoice) {
                System.out.println("❌ Invalid choice. Please select from the available options or type 'done' to finish.");
            } else {
                // Display the current selection for the user
                System.out.println("\n📝 Current Selection: " + selected.stream()
                        .map(topping -> getEmojiForTopping(topping) + " " + topping)
                        .reduce((t1, t2) -> t1 + ", " + t2).orElse("None"));
            }
        }
        return selected;
    }

    // Helper method to return an emoji based on topping type
    private String getEmojiForTopping(String topping) {
        return switch (topping.toLowerCase()) {
            case "steak" -> "🥩";
            case "ham" -> "🍖";
            case "salami" -> "🍖";
            case "roast beef" -> "🥩";
            case "chicken" -> "🍗";
            case "bacon" -> "🥓";
            case "american" -> "🧀";
            case "provolone" -> "🧀";
            case "cheddar" -> "🧀";
            case "swiss" -> "🧀";
            case "lettuce" -> "🥬";
            case "tomato" -> "🍅";
            case "onions" -> "🧅";
            case "peppers" -> "🌶️";
            case "cucumbers" -> "🥒";
            case "pickles" -> "🥒";
            case "jalapenos" -> "🌶️";
            default -> "🍽️"; // Generic food emoji for unspecified options
        };
    }

    private void addDrink(Scanner scanner) {
        System.out.println("🌟 Are you thirsty? 🌟");
        System.out.println("Choose your drink:");
        System.out.println("1) Water\n2) Gatorade\n3) Soda");

        int drinkType = getValidatedChoice(scanner, "Choose an option: ", 1, 3);
        String flavor = "Water";

        if (drinkType == 2) {
            System.out.println("Choose Gatorade flavor: 1) Blue 2) Red 3) Yellow");
            flavor = switch (getValidatedChoice(scanner, "Choose flavor: ", 1, 3)) {
                case 1 -> "Blue Gatorade";
                case 2 -> "Red Gatorade";
                case 3 -> "Yellow Gatorade";
                default -> "Gatorade";
            };
        } else if (drinkType == 3) {
            System.out.println("Choose soda flavor: 1) Cola 2) Lemonade 3) Orange Soda");
            flavor = switch (getValidatedChoice(scanner, "Choose flavor: ", 1, 3)) {
                case 1 -> "Cola";
                case 2 -> "Lemonade";
                case 3 -> "Orange Soda";
                default -> "Soda";
            };
        }

        int size = getValidatedChoice(scanner, "Choose drink size: 1) Small 2) Medium 3) Large", 1, 3);
        drinks.add(new Drink(size, flavor));
    }

    private void addChips(Scanner scanner) {
        System.out.println("🌟 Would you like some chips? 🌟");
        System.out.println("1) Barbecue\n2) Sour Cream & Onion\n3) Plain");

        String flavor = switch (getValidatedChoice(scanner, "Choose flavor: ", 1, 3)) {
            case 1 -> "Barbecue";
            case 2 -> "Sour Cream & Onion";
            case 3 -> "Plain";
            default -> "Chips";
        };

        chips.add(new Chips(flavor));
    }

    private void addSignatureSandwich(Scanner scanner) {
        System.out.println("🌟 Choose a Signature Sandwich 🌟");
        System.out.println("1) BLT - 8\" White Bread, Bacon, Cheddar, Lettuce, Tomato, Ranch, Toasted");
        System.out.println("2) Philly Cheese Steak - 8\" White Bread, Steak, American Cheese, Peppers, Mayo, Toasted");

        int choice = getValidatedChoice(scanner, "Choose a signature sandwich (1 or 2): ", 1, 2);

        Sandwich sandwich = null;

        switch (choice) {
            case 1 -> {
                ArrayList<String> meats = new ArrayList<>();
                meats.add("Bacon");
                ArrayList<String> cheeses = new ArrayList<>();
                cheeses.add("Cheddar");
                ArrayList<String> veggies = new ArrayList<>();
                veggies.add("Lettuce");
                veggies.add("Tomato");
                sandwich = new Sandwich(2, "White", meats, cheeses, veggies, true);
                sandwich.addSauce("Ranch");
            }
            case 2 -> {
                ArrayList<String> meats = new ArrayList<>();
                meats.add("Steak");
                ArrayList<String> cheeses = new ArrayList<>();
                cheeses.add("American Cheese");
                ArrayList<String> veggies = new ArrayList<>();
                veggies.add("Peppers");
                sandwich = new Sandwich(2, "White", meats, cheeses, veggies, true);
                sandwich.addSauce("Mayo");
            }
        }

        if (sandwich != null) {
            sandwiches.add(sandwich);
            System.out.println("✅ Added " + (choice == 1 ? "BLT" : "Philly Cheese Steak") + " to your order.");
        }
    }

    private void displayOrderDetails() {
        totalCost = 0;
        System.out.println("\n🌸 ~ Your Delicious Order ~ 🌸");
        System.out.println("🍽️ Order Number: #" + orderNumber);
        System.out.println("---------------------------------");

        for (Sandwich sandwich : sandwiches) {
            System.out.println("🥪 Sandwich Details:");
            System.out.println("   - Size: " + sandwich.getSize() + "\"");
            System.out.println("   - Bread: " + sandwich.getBread());
            System.out.println("   - Meats:");
            for (String meat : sandwich.getMeats()) {
                System.out.println("     • " + meat);
            }
            System.out.println("   - Cheeses:");
            for (String cheese : sandwich.getCheeses()) {
                System.out.println("     • " + cheese);
            }
            System.out.println("   - Veggies:");
            for (String veggie : sandwich.getVeggies()) {
                System.out.println("     • " + veggie);
            }
            System.out.println("   - Toasted: " + (sandwich.isToasted() ? "Yes" : "No"));
            totalCost += sandwich.calculatePrice();
        }

        for (Drink drink : drinks) {
            System.out.println("🥤 Drink: " + drink.getFlavor() + " - Size: " + drink.getSizeString());
            totalCost += drink.getPrice();
        }

        for (Chips chip : chips) {
            System.out.println("🍟 Chips Flavor: " + chip.getFlavor());
            totalCost += Pricing.getChipsPrice();
        }

        System.out.println("---------------------------------");
        System.out.printf("💳 Total: $%.2f%n", totalCost);
        System.out.println("🍽️ Thank you for ordering with DELI--cious! 🌟");
        System.out.println("---------------------------------\n");
    }

    private void displayOrderHistory() {
        if (orderHistory.isEmpty()) {
            System.out.println("📜 No previous orders found.");
        } else {
            System.out.println("\n📜 ~ Order History ~ 📜");
            for (Order order : orderHistory) {
                System.out.println("---------------------------------");
                System.out.println("🍽️ Order Number: #" + order.orderNumber);
                order.displayOrderDetails(); // Display each order's details
            }
        }
    }

    private void saveReceipt() {
        Receipt receipt = new Receipt();
        receipt.saveOrder(sandwiches, drinks, chips);
        System.out.println("📄 Receipt saved successfully! Check the 'receipts' folder.");
    }
}
