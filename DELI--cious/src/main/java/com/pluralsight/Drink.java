package com.pluralsight;

public class Drink {
    private int size; // 1 = Small, 2 = Medium, 3 = Large
    private String flavor;

    public Drink(int size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public double getPrice() {
        return switch (size) {
            case 1 -> Pricing.getSmallDrinkPrice();
            case 2 -> Pricing.getMediumDrinkPrice();
            case 3 -> Pricing.getLargeDrinkPrice();
            default -> 0;
        };
    }

    public String getFlavor() {
        return flavor;
    }

    public String getSizeString() {
        return switch (size) {
            case 1 -> "Small";
            case 2 -> "Medium";
            case 3 -> "Large";
            default -> "Unknown";
        };
    }
}
