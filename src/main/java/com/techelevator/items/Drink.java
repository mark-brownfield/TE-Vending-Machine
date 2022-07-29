package com.techelevator.items;

import java.math.BigDecimal;

public class Drink extends Item{
    public Drink(String slot, String itemName, BigDecimal price, int itemCount) {
        super(slot, itemName, price, itemCount);
    }

    @Override
    public String getSound(){
        return "Drinky, Drinky, Slurp Slurp!";
    }
}
