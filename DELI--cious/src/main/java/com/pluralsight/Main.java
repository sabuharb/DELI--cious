package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        app.showMenu();
    }

    // Muestra el Menu Principal
    private void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("""
                    ┍━━━━━━━━━━━━━━━━━»•» 🌺«•«━┑;"
                      -ˏˋ⋆ ᴡ ᴇ ʟ ᴄ ᴏ ᴍ ᴇ ⋆ˊˎ-
                                to
                             DELI--cious!👩🏻‍🍳
                    ┕━»•» 🌺«•«━━━━━━━━━━━━━━━━━;┙"
                    
                    1) New Order;
                    0) Exit;
                    
                    
                    Select an option:""");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    startOrder();
                    break;
                case 0:
                    System.out.println("Exiting. Come back soon!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }

    // Comienza orden nueva
    private void startOrder() {
        Order order = new Order();
        order.showOrderMenu();
    }
}
