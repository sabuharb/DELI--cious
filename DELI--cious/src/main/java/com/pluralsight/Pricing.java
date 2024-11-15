package com.pluralsight;

public class Pricing {
        public static double getSandwichPrice4Inch() {
                return 5.50;
        }

        public static double getSandwichPrice8Inch() {
                return 7.00;
        }

        public static double getSandwichPrice12Inch() {
                return 8.50;
        }

        public static double getExtraMeatPrice(int size) {
                return switch (size) {
                        case 1 -> 0.50;
                        case 2 -> 1.00;
                        case 3 -> 1.50;
                        default -> 0;
                };
        }

        public static double getCheesePrice(int size) {
                return switch (size) {
                        case 1 -> 0.75;
                        case 2 -> 1.50;
                        case 3 -> 2.25;
                        default -> 0;
                };
        }

        public static double getSmallDrinkPrice() {
                return 2.00;
        }

        public static double getMediumDrinkPrice() {
                return 2.50;
        }

        public static double getLargeDrinkPrice() {
                return 3.00;
        }

        public static double getChipsPrice() {
                return 1.50;
        }
}
