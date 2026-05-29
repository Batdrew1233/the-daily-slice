package com.pluralsight.toppings;

public abstract class PremiumTopping extends Topping {
    private boolean extra;

    public PremiumTopping(String name, boolean extra) {
        super(name);
        this.extra = extra;
    }

    /*
     * Returns whether the topping is an extra portion.
     */
    public boolean isExtra() {
        return extra;
    }

    /*
     * Calculates the price of the premium topping based on sandwich size.
     */
    public abstract double getPrice(String size);



}
