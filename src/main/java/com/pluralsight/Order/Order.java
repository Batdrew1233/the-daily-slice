package com.pluralsight.Order;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<IOrderItem> items = new ArrayList<>();

    public void addItem(IOrderItem item){
        items.add(item);

    }
    public double getTotal(){
        //Search through order items, get price for each item and calculate.
        double total = 0;

        for(IOrderItem item : items){
            total += item.getPrice();
        }
        return total;

    }
    public String displayOrder(){
        //search through order and get description and print
        String details = "";

        for (IOrderItem item : items){
            details += item.getdescription() + "\n";
        }
        return details;

    }

    public boolean hasSandwich(){
        for (IOrderItem item : items){
            if (item instanceof Sandwich){
                return true;
            }
        }
        return false;
    }

    public boolean hasDrinkOrChips(){
        for (IOrderItem item : items){
            if (item instanceof Drink || item instanceof Chips){
                return true;
            }
        }
        return false;
    }
    public boolean isEmpty(){
        return items.isEmpty();
    }
}
