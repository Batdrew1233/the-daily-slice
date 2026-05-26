package com.pluralsight.Order;

import com.pluralsight.toppings.Cheese;
import com.pluralsight.toppings.Meat;

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
                case "2":
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
            //Print cart here (Newest first)
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
                    //Go to make sandwich
                    break;
                case "2":
                    //Go to make drink
                    break;
                case "3":
                    //Go to add chips
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
        System.out.println("\n");
        System.out.println("===== Checkout =====");

    }
    private Sandwich processSandwichOrder(){
        String size = processGetSize();
        String bread = processGetBread();
        boolean toasted = processGetToasted();

        Sandwich sandwich = new Sandwich(size, bread, toasted);

        //Later add processAddToppings
        sandwich.addToppings(new Meat());

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
                case "12":
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

        }

        private void processAddMeat (Sandwich sandwich){
            while (true) {
                System.out.println("Choose meat:");
                System.out.println(" 1) Steak");
                System.out.println(" 2) Ham");
                System.out.println(" 3) Salami");
                System.out.println(" 4) Roast Beef");
                System.out.println(" 5) Chicken");
                System.out.println(" 6) Bacon");

                String choice = scanner.nextLine();

                boolean extra = processAskExtra();

                switch (choice) {
                    case "1":
                        sandwich.addToppings(new Meat("Steak", extra));
                        break;
                    case "2":
                        sandwich.addToppings(new Meat("Ham", extra));
                        break;
                    case "3":
                        sandwich.addToppings(new Meat("Salami", extra));
                        break;
                    case "4":
                        sandwich.addToppings(new Meat("Roast Beef", extra));
                        break;
                    case "5":
                        sandwich.addToppings(new Meat("Chicken", extra));
                        break;
                    case "6":
                        sandwich.addToppings(new Meat("Bacon", extra));
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }

    private void processAddCheese (Sandwich sandwich){
        while (true) {
            System.out.println("Choose meat:");
            System.out.println(" 1) American");
            System.out.println(" 2) Provolone");
            System.out.println(" 3) Cheddar");
            System.out.println(" 4) Swiss");

            String choice = scanner.nextLine();

            boolean extra = processAskExtra();

            switch (choice) {
                case "1":
                    sandwich.addToppings(new Cheese("American", extra));
                    break;
                case "2":
                    sandwich.addToppings(new Cheese("Provolone", extra));
                    break;
                case "3":
                    sandwich.addToppings(new Cheese("Cheddar", extra));
                    break;
                case "4":
                    sandwich.addToppings(new Cheese("Swiss", extra));
                    break;
            }
        }
    }


    }
