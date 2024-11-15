package com.pluralsight;

public class Chips {
    private String flavor;

    public Chips(String flavor) {
        this.flavor = flavor;
    }

    public double getPrice() {
        return Pricing.getChipsPrice();
    }

    public String getFlavor() {
        return flavor;
    }
}
