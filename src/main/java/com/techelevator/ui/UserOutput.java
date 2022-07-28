package com.techelevator.ui;

import com.techelevator.application.VendingMachine;
import com.techelevator.items.Item;

import java.util.List;

public class UserOutput {
    public static void displayMessage(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static void displayHomeScreen() {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }

    public static void displayItemList(List<Item> itemList){
        for (int i = 0; i < itemList.size(); i++) {
            System.out.println(itemList.get(i));
        }
    }
}
