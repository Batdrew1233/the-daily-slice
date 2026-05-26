package com.pluralsight.toppings;

public class Meat extends PremiumTopping {

    public Meat(String name, boolean extra) {
        super(name, extra);
    }

    @Override
    public double getPrice(String size) {
        if(size.equals("4")){
            return isExtra() ? 1.50 : 1.00;
        } else if (size.equals("8")) {
            return isExtra() ? 3.00 : 2.00;
        } else if (size.equals("12")) {
            return isExtra() ? 4.50 : 3.00;
        }else{
            return 0;
        }
    }
}
