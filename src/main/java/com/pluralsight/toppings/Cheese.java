package com.pluralsight.toppings;

public class Cheese extends PremiumTopping {

    public Cheese(String name, boolean extra) {
        super(name, extra);
    }

    @Override
    public double getPrice(String size) {
        if (size.equals("4")){
            return isExtra() ? .90 : .75;
        } else if (size.equals("8")) {
            return isExtra() ? 1.80 : 1.50;
        } else if (size.equals("12")) {
            return isExtra() ? 2.70 : 2.25;
        }else {
            return 0;
        }
    }
}
