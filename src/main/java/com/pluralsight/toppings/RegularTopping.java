package com.pluralsight.toppings;

public class RegularTopping extends Topping {


    public RegularTopping(String name) {
        super(name);
    }

    @Override
    public double getPrice(String size) {
        return 0;
    }

}
