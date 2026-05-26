package com.pluralsight.Order;

public class Chip implements IOrder{
    private String chipType;

    public Chip(String chipType) {
        this.chipType = chipType;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getdescription() {
        return "";
    }
}
