package com.pluralsight;

public class Topping {
    private String type;
    private boolean isPremium;

    public Topping(String type, boolean isPremium) {
        this.type = type;
        this.isPremium = isPremium;
    }
    // calcula el precio basado en el tamanio del sandwich y si los toppings son premium
    public double getCost(String sandwichSize) {
        if (!isPremium) return 0; // Toppings regulares incluidos gratis

        switch (sandwichSize) {
            case "4\"": return type.equals("extra meat") ? 0.50 : (type.equals("extra cheese") ? 0.30 : 1.00;
            case "8\"": return type.equals("extra meat") ? 1.00 : (type.equals("extra cheese") ? 0.60 : 2.00;
            case "12\"": return type.equals("extra meat") ? 1.50 : (type.equals("extra cheese") ? 0.90 : 3.00;
            default: return 0;
        }
    }

    @Override
    public String toString() {
        return type + (isPremium ? " (Premium)" : "");
    }
}
