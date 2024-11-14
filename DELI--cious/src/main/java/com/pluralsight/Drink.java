package com.pluralsight;

public class Drink{
private int size; // 1 for Small, 2 for Medium, 3 for Large

public Drink(int size) {
    this.size = size;
}

public double getPrice() {
    return switch (size) {
        case 1 -> Pricing.getSmallDrinkPrice();
        case 2 -> Pricing.getMediumDrinkPrice();
        case 3 -> Pricing.getLargeDrinkPrice();
        default -> 0;
    };
}

@Override
public String toString() {
    return switch (size) {
        case 1 -> "Small Drink";
        case 2 -> "Medium Drink";
        case 3 -> "Large Drink";
        default -> "Unknown Drink Size";
    };
}

        }
