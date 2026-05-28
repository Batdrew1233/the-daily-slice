package com.pluralsight.Order;

public class Chip implements OrderItem {
    private String chipType;

    public Chip(String chipType) {
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
