package com.pluralsight;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Receipt {
    private static final String BUSINESS_NAME = "DELI--cious";

    public void saveOrder(ArrayList<Sandwich> sandwiches, ArrayList<Drink> drinks, ArrayList<Chips> chips) {
        String directoryPath = "receipts";
        String filename = directoryPath + "/" + new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()) + "-Order.txt";

        // Create the receipts directory if it does not exist
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("🍽️ Welcome to " + BUSINESS_NAME + " 🍽️\n");
            writer.write("🧾 Order Receipt\n");
            writer.write("📅 Date: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\n");
            writer.write("--------------------------------------------------\n");

            double total = 0;

            // Write Sandwich details
            for (Sandwich sandwich : sandwiches) {
                writer.write("🥪 " + sandwich.toString() + " - $" + sandwich.calculatePrice() + "\n");
                total += sandwich.calculatePrice();
            }

            // Write Drink details
            for (Drink drink : drinks) {
                writer.write("🥤 Drink: " + drink.getFlavor() + " (" + drink.getSizeString() + ") - $" + drink.getPrice() + "\n");
                total += drink.getPrice();
            }

            // Write Chips details
            for (Chips chip : chips) {
                writer.write("🍟 Chips Flavor: " + chip.getFlavor() + " - $" + chip.getPrice() + "\n");
                total += chip.getPrice();
            }

            writer.write("--------------------------------------------------\n");
            writer.write(String.format("💳 Total: $%.2f\n", total));
            writer.write("--------------------------------------------------\n\n");

            // Thank you message
            writer.write("🙏 Thank you for choosing " + BUSINESS_NAME + "! 🙏\n");
            writer.write("🌟 Hope to see you back soon! 🌟\n");
            writer.write("😊 Have a Nice Day! 😊\n");

            System.out.println("📄 Receipt saved successfully! Check the 'receipts' folder.");

        } catch (IOException e) {
            System.out.println("❌ Failed to save receipt.");
        }
    }
}
