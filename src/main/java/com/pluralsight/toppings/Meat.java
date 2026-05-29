package com.pluralsight.toppings;

public class Meat extends PremiumTopping {

    public Meat(String name, boolean extra) {
        super(name, extra);
    }

    @Override
    public double getPrice(String size) {
        return switch (size) {
            case "4" -> isExtra() ? 1.50 : 1.00;
            case "8" -> isExtra() ? 3.00 : 2.00;
            case "12" -> isExtra() ? 4.50 : 3.00;
            default -> 0;
        };
    }
}
