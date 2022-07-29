package com.techelevator;

import com.techelevator.items.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemStock {
    /*public static List getItemStock() {
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

        return itemList;
    }*/
}
