package com.pluralsight.Order;

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
                    //Go to check out
                    break;
                case "0":
                    cancelOrder = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        }
    }



}
