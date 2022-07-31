package com.techelevator.ui;

import com.techelevator.application.VendingMachine;
import com.techelevator.items.*;
import com.techelevator.logger.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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


        System.out.println();
        System.out.println("***************************************************");
        System.out.println("            Vending Machine Inventory");
        System.out.println("***************************************************");
        System.out.println();
        for (int i = 0; i < itemList.size(); i++) {
            System.out.printf("%-6s%-24s%-10s%-4s\n", itemList.get(i).getSlot(),
                    itemList.get(i).getItemName(), itemList.get(i).getPrice(),
                    itemList.get(i).getItemCount());

        }
    }

    public static void displayPurchaseScreen() {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("              Purchasing Process Menu");
        System.out.println("***************************************************");
        System.out.println();
    }

    public static void dispenseItem(Item item, BigDecimal initialAmount, BigDecimal currentMoneyProvided){
        Logger logger = new Logger("AuditFile.txt");
        System.out.println(item.getItemName() + " " + item.getPrice() +
                "  count: " + item.getItemCount());
        System.out.println(item.getSound());
        logger.write(LocalDateTime.now() + "  " + item.getItemName() + "  "
                + item.getSlot() + " $" + initialAmount + " $" + currentMoneyProvided);
    }

    public static void notEnoughMoney(){
        System.out.println("Not enough money provided.");
    }

}
