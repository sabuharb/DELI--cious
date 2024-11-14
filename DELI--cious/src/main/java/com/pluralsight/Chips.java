package com.pluralsight;

import java.lang.reflect.Type;

public class Chips {
    // Propiedades de los chips
    private String type;
    private double price = 1.5;

    //constructor

    public Chips(String type, double price) {
        this.type = type;
        this.price = price;
    }
    public double getPrice() {
        return price;
    }

    public void displayDetails() {
        System.out.println("Type of chips: " + Type);
    }
}
