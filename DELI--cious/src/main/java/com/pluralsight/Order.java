package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void calculateTotal() {
        double total = 0;
        for (Product product : productList) {
            total += product.getPrice();
        }
        System.out.println("Total cost: $" + total);
    }

    public void generateReceipt() {
        System.out.println("Generating receipt...");
        FileManager fileManager = new FileManager();
        fileManager.writeReceipt(productList);
    }
}
