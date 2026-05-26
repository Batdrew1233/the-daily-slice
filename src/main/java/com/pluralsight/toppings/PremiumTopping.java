package com.pluralsight.toppings;

public abstract class PremiumTopping extends Topping {
    private boolean extra;

    public PremiumTopping(String name, boolean extra) {
        super(name);
        this.extra = extra;
    }

    public boolean isExtra() {
        return extra;
    }

    public double getPrice(String size){

    }

    @Override
    public String getName() {
        return super.getName();
    }


}
