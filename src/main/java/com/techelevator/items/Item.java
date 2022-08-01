package com.techelevator.items;

import java.math.BigDecimal;

public class Item {
    private String slot;
    private String itemName;
    private BigDecimal price;
    private int itemCount;

    public Item(String slot, String itemName, BigDecimal price, int itemCount) {
        this.slot = slot;
        this.itemName = itemName;
        this.price = price;
        this.itemCount = itemCount;
    }

    public String getSlot() {
        return slot;
    }

    public String getItemName() {
        return itemName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getSound() {
        return "";
    }

    public void subtract(){
        itemCount--;
    }

}