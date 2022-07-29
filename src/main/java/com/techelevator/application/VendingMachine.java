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
                currentMoneyProvided = selectOption(currentMoneyProvided);
            } else if (purchaseChoice.equals("Finish Transaction")) {
                System.out.println(makeChange(currentMoneyProvided));

            }
        }
    }

    public BigDecimal selectOption(BigDecimal currentMoneyProvided){
        String option = UserInput.getSelectItem(itemList);
        System.out.println(option);
        boolean isFound = false;
        for (Item item : itemList) {
            if (item.getSlot().equals(option)) {
                isFound = true;
                if (item.getPrice().compareTo(currentMoneyProvided) <= 0 && item.getItemCount() >= 1) {
                    item.subtract();
                    currentMoneyProvided = currentMoneyProvided.subtract(item.getPrice());
                    UserOutput.dispenseItem(item);
                    break;
                } else {
                    System.out.println("Item not dispensed");
                }
            }
        }
        if (isFound == false){
            System.out.println("Item not found");
        }
        return currentMoneyProvided;
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

    public String makeChange(BigDecimal currentMoneyProvided) {
        String change = "";
        double dollarCount = 0;
        double quarterCount = 0;
        double dimeCount = 0;
        double nickleCount = 0;
        double money = currentMoneyProvided.doubleValue();
        if (money == 0 ){
            System.out.println("Change: $0.00");
        } else {
            double moneyToPennies = money * 100;
            dollarCount = moneyToPennies / 100;
            quarterCount = (moneyToPennies % 100) / 25;
            dimeCount = (moneyToPennies % 25) / 10;
            nickleCount = (moneyToPennies % 10) / 5;

        }
        return "Your change is: " + dollarCount + " dollars, " + quarterCount + " quarters, "
                + dimeCount + " dimes, and " + nickleCount + " nickles";
    }
}
