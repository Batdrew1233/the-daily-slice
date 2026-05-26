package com.pluralsight.Order;

public class Drink implements IOrder{
    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
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
