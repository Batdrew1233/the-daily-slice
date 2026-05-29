package com.pluralsight.Order;

public class Chips implements IOrderItem {
    private String chipType;

    public Chips(String chipType) {
        this.chipType = chipType;
    }

    /*
     * Calculates and returns the price of the chips.
     */
    @Override
    public double getPrice() {
        return 1.50;
    }

    /*
     * Returns a description of the chips.
     */
    @Override
    public String getDescription() {
        return chipType + " Chips";
    }
}
