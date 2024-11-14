package com.pluralsight;

import java.util.ArrayList;

public class Sandwich {
    private String size;
    private String bread;
    private ArrayList<String> toppings;
    private boolean toasted;

    // Constructor que comienza las propiedades del sandwich
    public Sandwich(String size, String bread, ArrayList<String> toppings, boolean toasted) {
        this.size = size;
        this.bread = bread;
        this.toppings = toppings;
        this.toasted = toasted;
    }

    // Dertermina el precio del muy sandwich basado en el tamanio
    public double getPrice() {
        double price = 0
        switch (size) {
            case "4\"": return 5.50;
            case "8\"": return 7.00;
            case "12\"": return 8.50;
        }
        return price;
    }

    public void displayDetails(){
        System.out.println(size + " sandwich on " + bread + " with toppings: " toppings);
    }
}
