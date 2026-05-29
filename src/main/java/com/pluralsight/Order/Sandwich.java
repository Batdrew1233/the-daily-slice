package com.pluralsight.Order;

import com.pluralsight.toppings.Topping;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements IOrderItem {
    private String size;
    private String breadType;
    private boolean toasted;
    private List<Topping> toppings = new ArrayList<>();
    private List <String> sideSauces = new ArrayList<>();

    public Sandwich(String size, String breadType, boolean toasted) {
        this.size = size;
        this.breadType = breadType;
        this.toasted = toasted;
    }

    /*
     * Adds a topping to the sandwich.
     */
    public void addToppings(Topping topping){
        toppings.add(topping);
    }

    /*
     * Adds a sauce on the side of the sandwich.
     */
    public void addSideSauce(String sauce){
        sideSauces.add(sauce);
    }

    /*
     * Calculates the total price of the sandwich.
     */
    @Override
    public double getPrice() {
        double total = 0;

        if (size.equals("4")){
            total = 5.50;
        } else if (size.equals("8")) {
            total = 7.00;
        } else if (size.equals("12")) {
            total = 8.50;
        }
        for(Topping topping : toppings){
            total += topping.getPrice(size);
        }
        return total;
    }

    /*
     * Builds a description of the sandwich and its toppings.
     */
    @Override
    public String getDescription() {
        String description = size + "\" " + breadType + " sandwich";
        if (toasted){
            description += " (Toasted)";
        }

        description += "\nToppings:";

        for(Topping topping : toppings){
            description += "\n - " + topping.getName();
        }

        if(!sideSauces.isEmpty()){
            description += "\nSide Sauces:";

            for (String sauce : sideSauces){
                description += "\n - " + sauce;
            }
        }
        return description;
    }

}
