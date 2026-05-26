package com.pluralsight.Order;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<IOrder> items = new ArrayList<>();

    public void addItem(IOrder item){
        items.add(item);

    }
    public double getTotal(){
        //Search through order items, get price for each item and calculate.

    }
    public String displayOrder(){
        //search through order and get description and print

    }
}
