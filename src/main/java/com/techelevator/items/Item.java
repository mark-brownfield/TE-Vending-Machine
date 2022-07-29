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

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public String getSound() {
        return "";
    }

    public void subtract(){
        itemCount--;
    }

}
