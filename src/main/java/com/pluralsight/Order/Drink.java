package com.pluralsight.Order;

public class Drink implements OrderItem {
    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    @Override
    public double getPrice() {
        if (size.equalsIgnoreCase("small")){
            return 2.00;
        }
        else if(size.equalsIgnoreCase("medium")){
            return 2.50;
        }else if (size.equalsIgnoreCase("large")) {
            return 3.00;
        }else {
            return 0;
        }
    }

    @Override
    public String getdescription() {
        return size + " " + flavor + "Drink";
    }
}
