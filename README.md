Hello there,

Welcome to the Deli--cious Order Management Application! This is a simple Java project that lets you build an order system for a deli where customers can order sandwiches, drinks, and chips. The program helps users pick their items, customize sandwiches, calculates prices automatically, and generates a receipt with all the details.

Each part of the program is divided into classes, making it easier to understand and manage. Here’s a breakdown of how everything works.

Components
Main-
Purpose: The starting point of the application.
What It Does: This class initializes the order process by creating an Order object and starting the order workflow. It's the "entry point" where everything begins.
Order-
Purpose: Manages the order by handling items like sandwiches, drinks, and chips.
What It Does:
Lets users add sandwiches, drinks, and chips to their order.
Displays the current order details.
Saves the order information to the Receipt class for generating a final receipt.
Sandwich-
Purpose: Represents a single sandwich with customization options.
Attributes:
Size (like 4", 8", or 12").
Bread Type (such as white, wheat, rye, or wrap).
Toppings like extra meat, extra cheese, sauces, and vegetables.
What It Does: Calculates the price of a sandwich based on the size, bread type, and selected toppings. This class also lets users customize their sandwich by choosing from different options.
Drink-
Purpose: Represents a drink with different sizes and prices.
Attributes:
Size (small, medium, large).
What It Does: Sets the price based on the drink size. It uses the Pricing class to get the price for each size.
Chips-
Purpose: Represents chips as an extra item in the order.
What It Does: Provides a standard price for chips, which doesn’t change. This makes it easy to add chips to the order without customization.
Pricing-
Purpose: Stores prices for sandwiches, toppings, drinks, and chips.
What It Does: Provides static (fixed) methods to get prices for different items, sizes, and toppings. By keeping prices in one place, it’s easier to update them in the future.
Receipt-
Purpose: Handles the creation and storage of order receipts.
What It Does:
Collects order details, including each item and its price.
Saves the receipt to a file with the current date and time as the file name.
Makes it easy to look back at previous orders.
How the Application Works
Start the Order: The application starts from Main, which creates an Order object and calls the method to begin placing an order.
Build the Order: Users go through the Order class to add sandwiches, drinks, and chips. Each item has its own class, like Sandwich, Drink, and Chips, to handle details and prices.
Calculate Prices: The program calculates the total price as items are added. For example, Sandwich calculates its price based on size and toppings, using prices from the Pricing class.
Generate the Receipt: Once the user finishes their order, the Receipt class displays a summary of all items and saves it to a file as a record of the purchase.
Project Summary
Each class has a specific job:

Main starts the app.
Order manages items in the order.
Sandwich, Drink, and Chips represent each item, with their own details and pricing rules.
Pricing keeps track of all prices so they’re easy to update.
Receipt creates and saves the final order receipt.
