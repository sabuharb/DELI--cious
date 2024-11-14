package com.pluralsight;

public class Chips {
    private String type;

    public Chips(String type) {
        this.type = type;
    }

    public double getPrice() {
        return Pricing.getChipsPrice();
    }

    @Override
    public String toString() {
        return "Chips";
    }
}
