package com.pluralsight;

import java.util.ArrayList;

public class Sandwich {
    private int size; // 1 = 4", 2 = 8", 3 = 12"
    private String bread;
    private ArrayList<String> meats;
    private ArrayList<String> cheeses;
    private ArrayList<String> veggies;
    private boolean toasted;
    private String sauce = ""; // Optional sauce for signature sandwiches

    public Sandwich(int size, String bread, ArrayList<String> meats, ArrayList<String> cheeses, ArrayList<String> veggies, boolean toasted) {
        this.size = size;
        this.bread = bread;
        this.meats = meats;
        this.cheeses = cheeses;
        this.veggies = veggies;
        this.toasted = toasted;
    }

    public void addSauce(String sauce) {
        this.sauce = sauce;
    }

    public double calculatePrice() {
        double price = switch (size) {
            case 1 -> Pricing.getSandwichPrice4Inch();
            case 2 -> Pricing.getSandwichPrice8Inch();
            case 3 -> Pricing.getSandwichPrice12Inch();
            default -> 0;
        };

        // Add premium prices for each topping
        price += meats.size() * Pricing.getExtraMeatPrice(size);
        price += cheeses.size() * Pricing.getCheesePrice(size);

        return price;
    }

    public int getSize() {
        return size;
    }

    public String getBread() {
        return bread;
    }

    public ArrayList<String> getMeats() {
        return meats;
    }

    public ArrayList<String> getCheeses() {
        return cheeses;
    }

    public ArrayList<String> getVeggies() {
        return veggies;
    }

    public boolean isToasted() {
        return toasted;
    }

    public String getSauce() {
        return sauce;
    }

    @Override
    public String toString() {
        return String.format("%d-inch %s Sandwich\nMeats: %s\nCheeses: %s\nVeggies: %s\nToasted: %s\nSauce: %s",
                size, bread, String.join(", ", meats), String.join(", ", cheeses),
                String.join(", ", veggies), toasted ? "Yes" : "No", sauce);
    }
}
