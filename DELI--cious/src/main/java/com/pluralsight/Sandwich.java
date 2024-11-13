package com.pluralsight;

import java.util.List;

public class Sandwich extends Product {
    private String size;
    private String breadType;
    private List<Topping> toppings;
    private Boolean isToasted;

    public Sandwich(String size, double price) {
        super(name, price);
    }
}
