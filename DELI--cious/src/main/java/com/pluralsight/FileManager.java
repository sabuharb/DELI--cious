package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileManager {
    public void writeReceipt(List<Product> products) {
        String filename = "receipts/" + System.currentTimeMillis()+ ".txt";
        try (FileWriter writer = new FileWriter(filename)) {
            for (Product product : products) {
                writer.write(product.getPrice() + " - $" + product.getPrice() + "\n");
            }
            System.out.println("Receipt saved as " + filename);
        } catch (IOException e) {
            System.out.println("An Error occurred while saving the receipt.");
        }
    }
}
