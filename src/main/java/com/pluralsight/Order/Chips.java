package com.pluralsight.Order;

public class Chips implements IOrderItem {
    private String chipType;

    public Chips(String chipType) {
        this.chipType = chipType;
    }

    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public String getdescription() {
        return chipType + "Chips";
    }
}
