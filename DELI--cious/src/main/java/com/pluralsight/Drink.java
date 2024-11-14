package com.pluralsight;

public class Drink {
    // Propiedades de la bebidas
    private String size;
    private double price;

    // Constructor
    public Drink(String size) {
        this.size = size;
        this.price = determinePrice();
    }

    // Metodo para determinar el precio segun el tamanio de la bebida
    private double determinePrice() {
        switch (size) {
            case "Small": return 2.0;
            case "Medium": return 2.5;
            case "Large": return 3.0;
            default: return 0;
        }
    }

    public double getPrice() {
        return price;
    }

    public void displayDetails() {
        System.out.println("Drink size: " + size);
    }
}


