package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Sandwich {
    private int size; // 1 = 4", 2 = 8", 3 = 12"
    private String bread;
    private boolean extraMeat;
    private boolean extraCheese;

    public Sandwich(int size, String bread, boolean extraMeat, boolean extraCheese) {
        this.size = size;
        this.bread = bread;
        this.extraMeat = extraMeat;
        this.extraCheese = extraCheese;
    }

    public double calculatePrice() {
        double price = switch (size) {
            case 1 -> Pricing.getSandwichPrice4Inch();
            case 2 -> Pricing.getSandwichPrice8Inch();
            case 3 -> Pricing.getSandwichPrice12Inch();
            default -> 0;
        };

        if (extraMeat) {
            price += switch (size) {
                case 1 -> Pricing.getExtraMeatPrice4Inch();
                case 2 -> Pricing.getExtraMeatPrice8Inch();
                case 3 -> Pricing.getExtraMeatPrice12Inch();
                default -> 0;
            };
        }

        if (extraCheese) {
            price += switch (size) {
                case 1 -> Pricing.getCheesePrice4Inch();
                case 2 -> Pricing.getCheesePrice8Inch();
                case 3 -> Pricing.getCheesePrice12Inch();
                default -> 0;
            };
        }

        return price;
    }

    @Override
    public String toString() {
        return size + "\" " + bread + " Sandwich (Extra Meat: " + extraMeat + ", Extra Cheese: " + extraCheese + ")";
    }
}