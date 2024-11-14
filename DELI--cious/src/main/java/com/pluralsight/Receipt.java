package com.pluralsight;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Receipt {
    public void saveOrder(ArrayList<Sandwich> sandwiches, ArrayList<Drink> drinks, ArrayList<Chips> chips) {
        String filename = "receipts/" + new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()) + ".txt";
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Order Receipt\n");
            writer.write("Date: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\n");
            writer.write("------------------------\n");

            double total = 0;

            // Write sandwiches to receipt
            for (Sandwich sandwich : sandwiches) {
                writer.write(sandwich + " - $" + sandwich.calculatePrice() + "\n");
                total += sandwich.calculatePrice();
            }

            // Write drinks to receipt
            for (Drink drink : drinks) {
                writer.write(drink + " - $" + drink.getPrice() + "\n");
                total += drink.getPrice();
            }

            // Write chips to receipt
            for (Chips chip : chips) {
                writer.write("Chips - $" + Pricing.getChipsPrice() + "\n");
                total += Pricing.getChipsPrice();
            }

            writer.write("------------------------\n");
            writer.write("Total Cost: $" + total + "\n");
            writer.write("------------------------\n");

        } catch (IOException e) {
            System.out.println("Failed to save receipt.");
        }
    }
}