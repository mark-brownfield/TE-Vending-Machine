package com.techelevator.application;

import com.techelevator.items.*;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {

    File dataFile = new File("vending.csv");

    List<Item> itemList = new ArrayList<>();

    public void run() {

        readFile();

        while(true) {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();
            System.out.println(choice);
            if (choice.equals("display")) {
                UserOutput.displayItemList(itemList);
            } else if (choice.equals("purchase")) {
                 purchaseMenu();
                }
            else if (choice.equals("exit")) {
                    // good bye
                    break;
                }
            }


    }
    public void purchaseMenu(){
        BigDecimal currentMoneyProvided = new BigDecimal(0.00);
        while (true) {
            UserOutput.displayPurchaseScreen();
            String purchaseChoice = UserInput.getPurchaseScreenOption(currentMoneyProvided);
            System.out.println(purchaseChoice);
            if (purchaseChoice.equals("Money")) {
                currentMoneyProvided = UserInput.getFeedMoney(currentMoneyProvided);
            } else if (purchaseChoice.equals("Select")) {
                UserOutput.displayItemList(itemList);
                selectOption();
            }
        }
    }


    public void selectOption(){
        String option = UserInput.getSelectItem(itemList);
        System.out.println(option);
        for (Item item : itemList) {
            if (item.getSlot().equals(option)) {
                String selectedOption = item.getSlot();
                System.out.println(item.getItemName() + " " + item.getPrice() +
                        "  count: " + item.getItemCount());

                break;
            } else {
                System.out.println("No");
            }
        }
    }

  /*  public void dispenseMessage(){
        if (getClass(item))
    }*/

    public void despenseItem(){

    }

    public void readFile(){
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
    }
}
