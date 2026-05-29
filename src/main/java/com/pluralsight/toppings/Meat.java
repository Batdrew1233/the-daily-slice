package com.pluralsight.toppings;

public class Meat extends PremiumTopping {

    /*
     * Creates a meat topping with the specified name and extra option.
     */
    public Meat(String name, boolean extra) {
        super(name, extra);
    }

    /*
     * Calculates the price of the meat with sandwich size and if extra was selected.
     */
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
