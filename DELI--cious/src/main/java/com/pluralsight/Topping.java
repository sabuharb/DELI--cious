package com.pluralsight;

public class Topping {
    private String name;
    private boolean isPremium;
    private double extraCost;

    Public Topping(String name, boolean isPremium, double extraCost) {
        this.name = name;
        this.isPremium = isPremium;
        this.extraCost = extraCost;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public double getExtraCost() {
        return extraCost;

    }
}
