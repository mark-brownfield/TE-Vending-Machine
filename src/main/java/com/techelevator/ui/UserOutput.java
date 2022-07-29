package com.techelevator.ui;

import com.techelevator.application.VendingMachine;
import com.techelevator.items.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
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

    public static void displayItemList(){
        File dataFile = new File("vending.csv");
        List<Item> itemList = new ArrayList<>();

        try (Scanner fileScanner = new Scanner(dataFile)){
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] lineArray = line.split(",");
                String slot = lineArray[0];
                String name = lineArray[1];
                BigDecimal price = BigDecimal.valueOf(Double.parseDouble(lineArray[2]));
                int count = 6;
                if (lineArray[3].equals("Gum")) {
                    Gum item = new Gum(slot, name, price, count);
                    itemList.add(item);
                } else if (lineArray[3].equals("Drink")){
                    Drink item = new Drink(slot, name, price, count);
                    itemList.add(item);
                }  else if (lineArray[3].equals("Candy")){
                    Candy item = new Candy(slot, name, price, count);
                    itemList.add(item);
                }  else if (lineArray[3].equals("Munchy")){
                    Munchy item = new Munchy(slot, name, price, count);
                    itemList.add(item);
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        }

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

}
