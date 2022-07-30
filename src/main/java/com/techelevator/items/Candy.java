package com.techelevator.items;

import java.math.BigDecimal;

public class Candy extends Item{
    public Candy(String slot, String itemName, BigDecimal price, int itemCount) {
        super(slot, itemName, price, itemCount);
    }

    @Override
    public String getSound() {
        return "Sugar, Sugar, so Sweet!";
    }
}