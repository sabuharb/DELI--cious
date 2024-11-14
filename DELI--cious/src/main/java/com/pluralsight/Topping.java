package com.pluralsight;

public class Topping {
    private String name;
    private boolean isPremium;

    public Topping(String name, boolean isPremium) {
        this.name = name;
        this.isPremium = isPremium;
    }

    // Calculates the cost based on sandwich size and if the topping is premium
    public double getCost(String sandwichSize) {
        if (!isPremium) return 0; // Regular toppings are free

        switch (sandwichSize) {
            case "4\"":
                return name.equals("extra meat") ? 0.50 : (name.equals("extra cheese") ? 0.30 : 1.00);
            case "8\"":
                return name.equals("extra meat") ? 1.00 : (name.equals("extra cheese") ? 0.60 : 2.00);
            case "12\"":
                return name.equals("extra meat") ? 1.50 : (name.equals("extra cheese") ? 0.90 : 3.00);
            default:
                return 0;
        }
    }

    // Getter for the name
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + (isPremium ? " (Premium)" : "");
    }
}
