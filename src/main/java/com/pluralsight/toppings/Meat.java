package com.pluralsight.toppings;

public class Meat extends PremiumTopping {

    public Meat(String name, boolean extra) {
        super(name, extra);
    }

    @Override
    public double getPrice(String size) {
        return super.getPrice(size);
    }
}
