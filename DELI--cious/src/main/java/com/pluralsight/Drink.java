package com.pluralsight;

public class Drink {
    private String size;

    public Drink(String size) {
        this.size = size;
    }

    public double getPrice() {
        switch (size) {
            case "Small": return 2.00;
            case "Medium": return 2.50;
            case "Large": return 3.00;
            default: return 0;
        }
    }

    public void displayDetails() {
        System.out.println("Drink size: " + size);
    }
}

