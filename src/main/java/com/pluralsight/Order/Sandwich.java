package com.pluralsight.Order;

import com.pluralsight.toppings.Topping;

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
        double total = 0;

        if (size.equals("4")){
            total = 5.50;
        } else if (size.equals("8")) {
            total = 7.00;
        }
        if (size.equals("12")) {
            total = 8.50;
        }
        for(Topping topping : toppings){
            total += topping.g
        }
    }

    @Override
    public String getdescription() {
        return "";
    }
}
