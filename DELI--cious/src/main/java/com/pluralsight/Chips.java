package com.pluralsight;

public class Chips {
    private String type;
    private double price = 1.50;
    public Chips(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void displayDetails() {
        System.out.println("com.pluralsight.Chips type: " + type);
    }
}
