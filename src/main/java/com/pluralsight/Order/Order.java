package com.pluralsight.Order;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<IOrderItem> items = new ArrayList<>();

    /*
    Adds an item to the current order
     */
    public void addItem(IOrderItem item){
        items.add(item);
    }

    /*
    Calculates and returns the total cost of the order.
     */
    public double getTotal(){
        double total = 0;

        for(IOrderItem item : items){
            total += item.getPrice();
        }
        return total;

    }

    /*
    Builds and returns a formatted list of all items in the order.
     */
    public String displayOrder(){
        String details = "";

        for (IOrderItem item : items){
            details += item.getDescription() + "\n";
        }
        return details;

    }

    /*
    Checks if the order contains a sandwich.
    Returns true if the sandwich exists in the order.
     */
    public boolean hasSandwich(){
        for (IOrderItem item : items){
            if (item instanceof Sandwich){
                return true;
            }
        }
        return false;
    }

    /*
     Checks if the order contains a drink or chips.
     Return true if a drink or chips exists in the order
     */
    public boolean hasDrinkOrChips(){
        for (IOrderItem item : items){
            if (item instanceof Drink || item instanceof Chips){
                return true;
            }
        }
        return false;
    }

    /*
    Checks if the order is empty and returns true if it is
     */
    public boolean isEmpty(){
        return items.isEmpty();
    }
}
