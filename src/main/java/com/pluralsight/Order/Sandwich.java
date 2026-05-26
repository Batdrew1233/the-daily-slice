package com.pluralsight.Order;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements IOrder {
    private String size;
    private String breadType;
    private boolean toasted;
    private List<Topping> toppings = new ArrayList<>();

    public Sandwich(String size, String breadType, boolean toasted) {
        this.size = size;
        this.breadType = breadType;
        this.toasted = toasted;
    }
    public void addToppings(Topping topping){
        topping.add(topping);
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
