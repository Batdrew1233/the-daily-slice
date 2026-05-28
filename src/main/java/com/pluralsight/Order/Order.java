package com.pluralsight.Order;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> items = new ArrayList<>();

    public void addItem(OrderItem item){
        items.add(item);

    }
    public double getTotal(){
        //Search through order items, get price for each item and calculate.
        double total = 0;

        for(OrderItem item : items){
            total += item.getPrice();
        }
        return total;

    }
    public String displayOrder(){
        //search through order and get description and print
        String details = "";

        for (OrderItem item : items){
            details += item.getdescription() + "\n";
        }
        return details;

    }

    public boolean hasSandwich(){
        for (OrderItem item : items){
            if (item instanceof Sandwich){
                return true;
            }
        }
        return false;
    }

    public boolean hasDrinkOrChips(){
        for (OrderItem item : items){
            if (item instanceof Drink || item instanceof Chip){
                return true;
            }
        }
        return false;
    }
    public boolean isEmpty(){
        return items.isEmpty();
    }
}
