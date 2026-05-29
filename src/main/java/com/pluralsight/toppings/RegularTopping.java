package com.pluralsight.toppings;

public class RegularTopping extends Topping {

    /*
     * Creates a regular topping with the specified name.
     */
    public RegularTopping(String name) {
        super(name);
    }

    /*
     * Returns the price of a regular topping.
     */
    @Override
    public double getPrice(String size) {
        return 0;
    }

}
