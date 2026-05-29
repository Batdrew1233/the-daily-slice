package com.pluralsight.Order;

import com.pluralsight.receipt.ReceiptFileManager;
import com.pluralsight.toppings.*;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Order order;

    public UserInterface (){
        scanner = new Scanner(System.in);
    }

    /*
     Displays the home screen and allows the user
     to start a new order or exit the application.
     */
    public void display(){
        boolean quit = false;
        while (!quit){
            System.out.println("\n");
            System.out.println("====== Welcome to the shop =====");
            System.out.println(" 1) New Order");
            System.out.println(" 0) Exit");
            System.out.print("Your choice: ");
            String choice = scanner.nextLine();

            switch (choice){
                case "1":
                    order = new Order();
                    orderScreen();
                    break;
                case "0":
                    quit = true;
                    System.out.println("Thanks for shopping!");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    /*
     Displays the order menu and allows the user
     to add items, checkout, or cancel the order.
     */
    public void orderScreen(){
        boolean cancelOrder = false;
        while (!cancelOrder){
            System.out.println("\n");
            System.out.println("====== Current Order ======");

            if (order.isEmpty()){
                System.out.println("No items added yet.");
            }else {
                System.out.println(order.displayOrder());
                System.out.printf("Current Total: $%.2f%n", order.getTotal());
            }
            System.out.println("\n");
            System.out.println("Order Menu");
            System.out.println(" 1) Add Item");
            System.out.println(" 2) Add Drink");
            System.out.println(" 3) Add chips");
            System.out.println(" 4) Checkout");
            System.out.println(" 0) Cancel Order");
            System.out.print("Your choice: ");
            String choice = scanner.nextLine();

            switch (choice){
                case "1":
                    Sandwich sandwich = processSandwichOrder();
                    order.addItem(sandwich);
                    break;
                case "2":
                    Drink drink = processDrinkOrder();
                    if (drink != null){
                        order.addItem(drink);
                    }
                    break;
                case "3":
                    Chips chips = processChipsOrder();
                    if (chips != null){
                        order.addItem(chips);
                    }
                    break;
                case "4":
                    checkout();
                    cancelOrder = true;
                    break;
                case "0":
                    cancelOrder = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        }
    }

    /*
      Prints the order and displays the final order details and total cost.
      Saves the order to receipt.
     */
    public void checkout(){
        if (!order.hasSandwich() && !order.hasDrinkOrChips()){
            System.out.println("\n");
            System.out.println("You must order at least chips or a drink if no sandwich is purchased.");
            return;
        }

        System.out.println("\n");
        System.out.println("===== Checkout =====");
        System.out.println(order.displayOrder());
        System.out.printf("Total: $%.2f%n" , order.getTotal());

        //Save Order to file here
        ReceiptFileManager receiptFileManager = new ReceiptFileManager();
        receiptFileManager.saveReceipt(order);
    }

    /*
     Guides the user through creating a customized sandwich.
     Returns the completed Sandwich object.
     */
    private Sandwich processSandwichOrder(){
        String size = processGetSize();
        String bread = processGetBread();
        boolean toasted = processGetToasted();

        Sandwich sandwich = new Sandwich(size, bread, toasted);

        processAddTopping(sandwich);

        return sandwich;

    }

    /*
     Prompts the user to select a sandwich size.
     Returns the selected sandwich size.
     */
    private String processGetSize(){
        while(true){
            System.out.println("\n");
            System.out.println("Choose Sandwich Size");
            System.out.println(" 1) 4 inch");
            System.out.println(" 2) 8 inch");
            System.out.println(" 3) 12 inch");
            System.out.print("Your choice: ");
            String choice = scanner.nextLine();

            switch(choice) {
                case "1":
                    return "4";
                case "2":
                    return "8";
                case "3":
                    return "12";
                default:
                    System.out.println("Invalid choice");
            }
        }

    }

    /*
     Prompts the user to select a bread type.
     Returns the selected bread type.
     */
    private String processGetBread(){
        while(true){
            System.out.println("\n");
            System.out.println("Choose Bread");
            System.out.println(" 1) White");
            System.out.println(" 2) Wheat");
            System.out.println(" 3) Rye");
            System.out.println(" 4) Wrap");
            System.out.print("Your choice: ");
            String choice = scanner.nextLine();

            switch(choice) {
                case "1":
                    return "White";
                case "2":
                    return "Wheat";
                case "3":
                    return "Rye";
                case "4":
                    return "Wrap";
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    /*
     Asks the user if the sandwich should be toasted.
     Return true if toasted and false if not.
     */
    private boolean processGetToasted(){
        while(true) {
            System.out.println("\n");
            System.out.println("Would you like it toasted? (Yes/No)");
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")){
                return true;
            } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")){
                return false;

            }else{
                System.out.println("Invalid input. Please enter yes or no.");
            }
        }
    }

    /*
     Asks the user if they would like extra premium toppings.
     Return true if extra is selected and false if not.
     */
    private boolean processAskExtra() {
        while (true) {
            System.out.println("\n");
            System.out.println("Would you like extra? (yes/no)");

            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                return true;
            } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    /*
     Allows the user to add toppings to the sandwich.
     */
    private void processAddTopping (Sandwich sandwich){
        processAddMeat(sandwich);
        processAddCheese(sandwich);
        processAddRegularToppings(sandwich);
        processAddSauces(sandwich);
        processAddSides(sandwich);
        }

    /*
     Allows the user to select a meat topping.
     */
    private void processAddMeat(Sandwich sandwich) {
        while (true) {
            System.out.println("\n");
            System.out.println("Choose meat:");
            System.out.println(" 1) Steak");
            System.out.println(" 2) Ham");
            System.out.println(" 3) Salami");
            System.out.println(" 4) Roast Beef");
            System.out.println(" 5) Chicken");
            System.out.println(" 6) Bacon");
            System.out.println(" 0) No Meat");
            System.out.print("Your choice: ");
            String choice = scanner.nextLine();


            switch (choice) {
                case "1": {
                    boolean extra = processAskExtra();
                    sandwich.addToppings(new Meat("Steak", extra));
                    return;
                }
                case "2": {
                    boolean extra = processAskExtra();
                    sandwich.addToppings(new Meat("Ham", extra));
                    return;
                }
                case "3": {
                    boolean extra = processAskExtra();
                    sandwich.addToppings(new Meat("Salami", extra));
                    return;
                }
                case "4": {
                    boolean extra = processAskExtra();
                    sandwich.addToppings(new Meat("Roast Beef", extra));
                    return;
                }
                case "5": {
                    boolean extra = processAskExtra();
                    sandwich.addToppings(new Meat("Chicken", extra));
                    return;
                }
                case "6": {
                    boolean extra = processAskExtra();
                    sandwich.addToppings(new Meat("Bacon", extra));
                    return;
                }
                case "0":
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /*
     Allows the user to select a cheese topping.
     */
    private void processAddCheese (Sandwich sandwich){
        while (true) {
            System.out.println("\n");
            System.out.println("Choose cheese:");
            System.out.println(" 1) American");
            System.out.println(" 2) Provolone");
            System.out.println(" 3) Cheddar");
            System.out.println(" 4) Swiss");
            System.out.println(" 0) No Cheese");
            System.out.println("Your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": {
                    boolean extra = processAskExtra();
                    sandwich.addToppings(new Cheese("American", extra));
                    return;
                }
                case "2": {
                    boolean extra = processAskExtra();
                    sandwich.addToppings(new Cheese("Provolone", extra));
                    return;
                }
                case "3": {
                    boolean extra = processAskExtra();
                    sandwich.addToppings(new Cheese("Cheddar", extra));
                    return;
                }
                case "4": {
                    boolean extra = processAskExtra();
                    sandwich.addToppings(new Cheese("Swiss", extra));
                    return;
                }
                case "0":
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /*
     Allows the user to add regular toppings.
     */
    private void processAddRegularToppings(Sandwich sandwich){
        boolean addingToppings = true;

        while (addingToppings){
            System.out.println("\n");
            System.out.println("Choose a regular topping:");
            System.out.println(" 1) Lettuce");
            System.out.println(" 2) Tomato");
            System.out.println(" 3) Onion");
            System.out.println(" 4) Pickles");
            System.out.println(" 5) Peppers");
            System.out.println(" 6) Jalapenos");
            System.out.println(" 7) Cucumbers");
            System.out.println(" 8) Guacamole");
            System.out.println(" 9) Mushrooms");
            System.out.println(" 0) Done");
            System.out.print("Your choice: ");
            String choice = scanner.nextLine();

            switch (choice){
                case "1":
                    sandwich.addToppings(new RegularTopping("Lettuce"));
                    break;
                case "2":
                    sandwich.addToppings(new RegularTopping("Tomato"));
                    break;
                case "3":
                    sandwich.addToppings(new RegularTopping("Onion"));
                    break;
                case "4":
                    sandwich.addToppings(new RegularTopping("Pickles"));
                    break;
                case "5":
                    sandwich.addToppings(new RegularTopping("Peppers"));
                    break;
                case "6":
                    sandwich.addToppings(new RegularTopping("Jalapenos"));
                    break;
                case "7":
                    sandwich.addToppings(new RegularTopping("Cucumbers"));
                    break;
                case "8":
                    sandwich.addToppings(new RegularTopping("Guacamole"));
                    break;
                case "9":
                    sandwich.addToppings(new RegularTopping("Mushrooms"));
                    break;
                case "0":
                    addingToppings = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    /*
     Allows the user to add sauces to the sandwich.
     */
    private void processAddSauces(Sandwich sandwich) {
        boolean addingSauces = true;

        while (addingSauces) {
            System.out.println("\n");
            System.out.println("Choose Sauce:");
            System.out.println(" 1) Mayo");
            System.out.println(" 2) Mustard");
            System.out.println(" 3) Ketchup");
            System.out.println(" 4) Ranch");
            System.out.println(" 5) Thousand Islands");
            System.out.println(" 6) Vinaigrette");
            System.out.println(" 0) Done");
            System.out.print("Your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    sandwich.addToppings(new RegularTopping("Mayo"));
                    break;
                case "2":
                    sandwich.addToppings(new RegularTopping("Mustard"));
                    break;
                case "3":
                    sandwich.addToppings(new RegularTopping("Ketchup"));
                    break;
                case "4":
                    sandwich.addToppings(new RegularTopping("Ranch"));
                    break;
                case "5":
                    sandwich.addToppings(new RegularTopping("Thousand Island"));
                    break;
                case "6":
                    sandwich.addToppings(new RegularTopping("Vinaigrette"));
                    break;
                case "0":
                    addingSauces = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    /*
     Allows the user to add sides to the sandwich.
     */
    private void processAddSides(Sandwich sandwich){
        while (true){
            System.out.println("\n");
            System.out.println("Choose a sauce on the side:");
            System.out.println(" 1) Mayo");
            System.out.println(" 2) Mustard");
            System.out.println(" 3) Ketchup");
            System.out.println(" 4) Ranch");
            System.out.println(" 5) Thousand Islands");
            System.out.println(" 6) Vinaigrette");
            System.out.println(" 7) Au Jus");
            System.out.println(" 0) Done");
            System.out.println("Your choice: ");
            String choice = scanner.nextLine();

            switch (choice){
                case "1": {
                    sandwich.addSideSauce("Mayo");
                    break;
                }
                case "2": {
                    sandwich.addSideSauce("Mustard");
                    break;
                }
                case "3": {
                    sandwich.addSideSauce("Ketchup");
                    break;
                }
                case "4": {
                    sandwich.addSideSauce("Ranch");
                    break;
                }
                case "5": {
                    sandwich.addSideSauce("Thousand Islands");
                    break;
                }
                case "6": {
                    sandwich.addSideSauce("Vinaigrette");
                    break;
                }
                case "7": {
                    sandwich.addSideSauce("Au Jus");
                    break;
                }
                case "0": {
                    return;
                }
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    /*
     Creates a drink with the user's selections.
     Return the completed Drink object
     */
    private Drink processDrinkOrder(){
        String size;
        String flavor;

        while(true){
            System.out.println("\n");
            System.out.println("What Size?");
            System.out.println(" 1) Small");
            System.out.println(" 2) Medium");
            System.out.println(" 3) Large");
            System.out.println(" 0) No drink");
            System.out.print("Your Choice: ");

            String choice = scanner.nextLine();

            switch (choice){
                case "1":
                    size = "Small";
                    break;
                case "2":
                    size = "Medium";
                    break;
                case "3":
                    size = "Large";
                    break;
                case "0":
                    return null;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }
            break;
        }
        while (true){
            System.out.println("\n");
            System.out.println("What Flavor?");
            System.out.println(" 1) Coke ");
            System.out.println(" 2) Pepsi");
            System.out.println(" 3) Root Beer");
            System.out.println(" 4) Fruit Punch");
            System.out.println(" 5) Lemonade");
            System.out.println(" 6) Iced Tea ");
            System.out.print("Your choice: ");

            String choice2 = scanner.nextLine();

            switch (choice2){
                case "1":
                    flavor = "Coke";
                    break;
                case "2":
                    flavor = "Pepsi";
                    break;
                case "3":
                    flavor = "Root Beer";
                    break;
                case "4":
                    flavor = "Fruit Punch";
                    break;
                case "5":
                    flavor = "Lemonade";
                    break;
                case "6":
                    flavor = "Iced Tea";
                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }
            break;
        }
        return new Drink(size, flavor);

    }

    /*
     Creates a chips order with the user's selection.
     Return the selected Chips object
     */
    private Chips processChipsOrder(){
        while (true){
            System.out.println("\n");
            System.out.println("Choose Chips:");
            System.out.println(" 1) BBQ");
            System.out.println(" 2) Sour Cream");
            System.out.println(" 3) Salt & Vinegar");
            System.out.println(" 4) Cheddar");
            System.out.println(" 0) No Chips");
            System.out.print("Your Choice: ");

            String choice = scanner.nextLine();

            switch (choice){
                case "1":
                    return new Chips("BBQ");
                case "2":
                    return new Chips("Sour Cream");
                case "3":
                    return new Chips("Salt & Vinegar");
                case "4":
                    return new Chips("Cheddar");
                case "0":
                    return null;
                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }


}
