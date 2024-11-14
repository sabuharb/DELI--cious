package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Responsable por Hacer y Muestra el mero menu
        Main app = new Main();
        app.showMenu();
    }

    private void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("""
                    Welcome to Deli-cious!;
                    1) New Order;
                    0) Exit;
                    
                    
                    Select an option: """);

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    startNewOrder();
                    break;
                case 0:
                    System.out.println("Exiting the Application. See you back soon!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private void startNewOrder()}
Scanner scanner = new Scanner(System.in);
Order order = new Order();

boolean ordering = true;
while (ordering){
        System.out.println("""
                    Order Menu:;
                    1) Add Sandwich;
                    2) Add Drink;
                    3) Add Chips;
                    4) Checkout;
                    0) Cancel Order;


                    Select an option: """);

        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                order.addSandwich(createSandwich());
                break;
            case 2:
                order.addDrink(createDrink());
                break;
                case 3:
                    order.addChips(createChips());
                    break;
                    case 4:
                        order.showOrderDetails();
                        order.generateReceipt();
                        ordering = false;
                        break;
                        case 0:
                            System.out.println("Order cancelled.");
                            ordering = false;
                            break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
        }
        }
                }


