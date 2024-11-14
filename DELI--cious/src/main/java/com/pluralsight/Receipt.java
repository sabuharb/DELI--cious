package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Receipt {
    public void saveOrder(ArrayList<Sandwich> sandwiches, ArrayList<Drink> drinks, ArrayList<Chips> chips) {
        String filename = "receipts/" + new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()) + ".txt";
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Order Receipt\n");
            writer.write("Date: " + new SimpleDateFormat("yyyy--MM-dd HH:mm:ss").format(new Date()) + "\n");
            writer.write("==========================\n");

            double total = 0;

            for (Sandwich s : sandwiches) {
                writer.write(s.toString() + "\n");
                writer.write(" - Price: $" + s.getPrice() + "\n");
                total += s.getPrice();
            }

            for (Drink d : drinks) {
                writer.write(d.toString() + "\n");
                writer.write(" - Price: $" + d.getPrice() + "\n");
                total += d.getPrice();
            }

            for (Chips c : chips) {
                writer.write(c.toString() + "\n");
                writer.write(" - Price: $" + c.getPrice() + "\n");
                total += c.getPrice();
            }
            writer.write("-------------------------\n");
            writer.write("Total Cost: $" + total + "\n");
            writer.write("==========================");
        } catch (IOException e) {
        System.out.println("Failed to generate receipt ");



        }
    }
}
