package com.pluralsight.toppings;

public class Cheese extends PremiumTopping {

    /*
     * Creates a Cheese topping with the specified name and extra option.
     */
    public Cheese(String name, boolean extra) {
        super(name, extra);
    }

    /*
     * Calculates the price of the cheese with sandwich size and if extra was selected.
     */
    @Override
    public double getPrice(String size) {
        return switch (size) {
            case "4" -> isExtra() ? .90 : .75;
            case "8" -> isExtra() ? 1.80 : 1.50;
            case "12" -> isExtra() ? 2.70 : 2.25;
            default -> 0;
        };
    }
}
