package com.pluralsight.Order;

import com.pluralsight.toppings.*;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Order order;

    public UserInterface (){
        scanner = new Scanner(System.in);
    }

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
                    Chip chip = processChipsOrder();
                    if (chip != null){
                        order.addItem(chip);
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
    public void checkout(){
        if (!order.hasSandwich() && !order.hasDrinkOrChips()){
            System.out.println("\n");
            System.out.println("You must order at least chips or a drink if no sandwich is purchased.");
            return;
        }

        System.out.println("\n");
        System.out.println("===== Checkout =====");
        System.out.println(order.displayOrder());
        System.out.println("Total: $%.2f%n" + order.getTotal());

    }
    private Sandwich processSandwichOrder(){
        String size = processGetSize();
        String bread = processGetBread();
        boolean toasted = processGetToasted();

        Sandwich sandwich = new Sandwich(size, bread, toasted);

        processAddTopping(sandwich);

        return sandwich;

    }

    private String processGetSize(){
        while(true){
            System.out.println("\n");
            System.out.println("Choose Sandwich Size");
            System.out.println(" 1) 4 inch");
            System.out.println(" 2) 8 inch");
            System.out.println(" 3) 12 inch");
            System.out.println("Your choice: ");
            String  choice = scanner.nextLine();

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

    private String processGetBread(){
        while(true){
            System.out.println("\n");
            System.out.println("Choose Bread");
            System.out.println(" 1) White");
            System.out.println(" 2) Wheat");
            System.out.println(" 3) Rye");
            System.out.println(" 4) Wrap");
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

        private void processAddTopping (Sandwich sandwich){
        processAddMeat(sandwich);
        processAddCheese(sandwich);
        processAddRegularToppings(sandwich);
        processAddSauces(sandwich);
        processAddSides(sandwich);
        }

        private void processAddMeat (Sandwich sandwich){
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

    private void processAddCheese (Sandwich sandwich){
        while (true) {
            System.out.println("\n");
            System.out.println("Choose cheese:");
            System.out.println(" 1) American");
            System.out.println(" 2) Provolone");
            System.out.println(" 3) Cheddar");
            System.out.println(" 4) Swiss");
            System.out.println(" 0) No Cheese");

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
            System.out.println(" 0) Done");

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
                case "0":
                    addingToppings = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
     private void processAddSauces(Sandwich sandwich){
        boolean addingSauces = true;

        while (addingSauces) {
            System.out.println("\n");
            System.out.println(" 1) Mayo");
            System.out.println(" 2) Ranch");
            System.out.println(" 3) Chipotle");
            System.out.println(" 4) Mustard");
            System.out.println(" 0) Done");

            String choice = scanner.nextLine();

            switch (choice){
                case "1":
                    sandwich.addToppings(new Sauce("Mayo"));
                    break;
                case "2":
                    sandwich.addToppings(new Sauce("Ranch"));
                    break;
                case "3":
                    sandwich.addToppings(new Sauce("Chipotle"));
                    break;
                case "4":
                    sandwich.addToppings(new Sauce("Mustard"));
                    break;
                case "0":
                    addingSauces = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
     }

    private void processAddSides(Sandwich sandwich){
        boolean addingSides = true;

        while (addingSides){
            System.out.println("\n");
            System.out.println("Choose sides:");
            System.out.println(" 1) Lettuce");
            System.out.println(" 2) Tomato");
            System.out.println(" 3) Onion");
            System.out.println(" 4) Pickles");
            System.out.println(" 5) Peppers");
            System.out.println(" 0) Done");

            String choice = scanner.nextLine();

            switch (choice){
                case "1":
                    sandwich.addToppings(new Sides("Lettuce"));
                    break;
                case "2":
                    sandwich.addToppings(new Sides("Tomato"));
                    break;
                case "3":
                    sandwich.addToppings(new Sides("Onion"));
                    break;
                case "4":
                    sandwich.addToppings(new Sides("Pickles"));
                    break;
                case "5":
                    sandwich.addToppings(new Sides("Peppers"));
                    break;
                case "0":
                    addingSides = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

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

    private Chip processChipsOrder(){
        while (true){
            System.out.println("\n");
            System.out.println("Choose Chips:");
            System.out.println(" 1) BBQ");
            System.out.println(" 2) Sour Cream");
            System.out.println(" 3) Salt & Vinegar");
            System.out.println(" 4) Cheddar");
            System.out.println(" 0) No Chips");
            System.out.println("Your Choice: ");

            String choice = scanner.nextLine();

            switch (choice){
                case "1":
                    return new Chip("BBQ");
                case "2":
                    return new Chip("Sour Cream");
                case "3":
                    return new Chip("Salt & Vinegar");
                case "4":
                    return new Chip("Cheddar");
                case "0":
                    return null;
                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }


}
