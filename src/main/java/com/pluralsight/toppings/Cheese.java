package com.pluralsight.toppings;

public class Cheese extends PremiumTopping {

    public Cheese(String name, boolean extra) {
        super(name, extra);
    }

    @Override
    public double getPrice(String size) {
        return super.getPrice(size);
    }
}
