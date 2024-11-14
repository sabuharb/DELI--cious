package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Sandwich {
    private String size;
    private String bread;
    private ArrayList<Topping> toppings;
    private ArrayList<Topping> sauces;
    private ArrayList<Topping> sides;
    private boolean toasted;

    // Constructor que comienza las propiedades del sandwich
    public Sandwich(String size, String bread, boolean toasted) {
        this.size = size;
        this.bread = bread;
        this.toppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.sides = new ArrayList<>();
        this.toasted = toasted;
    }

    // Pedir personalizar el sandwhich
    public void cutomizeSandwich() {
        Scanner scanner = new Scanner(System.in);

        // Agregar Carnes o quesos Premium
        System.out.println("Choose premium toppings (Meats, cheeses): ");
        toppings.add(new Topping("steak,", true));
        toppings.add(new Topping("ham", true));
        toppings.add(new Topping("salami", true));
        toppings.add(new Topping("roast beef", true));
        toppings.add(new Topping("chicken", true));
        toppings.add(new Topping("bacon", true));
        toppings.add(new Topping("american cheese", true));
        toppings.add(new Topping("provolone cheese", true));
        toppings.add(new Topping("cheddar cheese", true));
        toppings.add(new Topping("swiss cheese", true));


        // Agregar queso extra
        System.out.println("Add extra cheese? (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            toppings.add(new Topping("extra cheese", true));
        }

        // Agregar toppings regulares
        System.out.println("Choose regular toppings ( lettuce, tomatoes, etc..): ");
        toppings.add(new Topping("lettuce", false));
        toppings.add(new Topping("tomato", false));
        toppings.add(new Topping("onions", false));
        toppings.add(new Topping("jalapenos", false));
        toppings.add(new Topping("cucumbers", false));
        toppings.add(new Topping("pickles", false));
        toppings.add(new Topping("guacamole", false));
        toppings.add(new Topping("mushrooms", false));


        // Escoger Salsa
        System.out.println("Choose sauces (mayo, mustard, ketchup, ranch, thousands islands, vinaigrette):");
        sauces.add(new Topping("mayo", false));
        sauces.add(new Topping("mustard", false));
        sauces.add(new Topping("ketchup", false));
        sauces.add(new Topping("ranch", false));
        sauces.add(new Topping("thousand islands", false));
        sauces.add(new Topping("vinaigrette", false));

        // escoger las sides
        System.out.println("Choose sides (au jus, sauce): ");
        sides.add(new Topping("au jus", false));
        sides.add(new Topping("sauce", false));

        }


    // Dertermina el precio del muy sandwich basado en el tamanio
    public double getPrice() {
        double price = 0;
        switch (size) {
            case "4\"":
                return 5.50;
            case "8\"":
                return 7.00;
            case "12\"":
                return 8.50;
        }

        // Agregar el costo por los toppings premium y toppings extra
        for (Topping topping : toppings) {
            price += topping.getCost(size);
        }


        return price;
    }

    public void displayDetails(){
        System.out.println(size + " sandwich on " + bread + " with toppings: " + toppings + " | Sauces: " + sauces + " | Sides: " + sides);
    }
    @Override
    public String toString() {
        return size + " Sandwich on " + bread + " with Toppings: " + toppings + ", Sides: " + sides;
    }
}
