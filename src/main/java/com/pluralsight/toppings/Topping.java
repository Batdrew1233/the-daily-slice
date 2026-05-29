package com.pluralsight.toppings;

public abstract class Topping {
    private String name;


    public Topping(String name) {
        this.name = name;
    }

    /*
     * Returns the name of the topping.
     */
    public String getName() {
        return name;
    }

    /*
     * Calculates the price of the topping based on sandwich size.
     */
    public abstract double getPrice(String size);
}
