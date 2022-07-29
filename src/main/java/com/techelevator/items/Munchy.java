package com.techelevator.items;

import java.math.BigDecimal;

public class Munchy extends Item{
    public Munchy(String slot, String itemName, BigDecimal price, int itemCount) {
        super(slot, itemName, price, itemCount);
    }

    @Override
    public String getSound(){
        return "Munchy, Munchy, so Good!";
    }
}
