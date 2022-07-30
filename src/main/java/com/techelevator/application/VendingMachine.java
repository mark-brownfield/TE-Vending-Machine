package com.techelevator.application;

import com.techelevator.items.*;
import com.techelevator.logger.Logger;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {

    File dataFile = new File("vending.csv");

    List<Item> itemList = new ArrayList<>();

    Logger logger;

    public void run() {
        logger = new Logger("AuditFile.txt");

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
                    System.exit(1);
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
                currentMoneyProvided = currentMoneyProvided.subtract(currentMoneyProvided);
                run();
            }
        }
    }

    public BigDecimal selectOption(BigDecimal currentMoneyProvided){
        String option = UserInput.getSelectItem(itemList);
        System.out.println(option);
        boolean isFound = false;
        BigDecimal initialAmount = currentMoneyProvided;
        for (Item item : itemList) {
            if (item.getSlot().equals(option)) {
                isFound = true;
                if (item.getPrice().compareTo(currentMoneyProvided) <= 0 && item.getItemCount() >= 1) {
                    item.subtract();
                    currentMoneyProvided = currentMoneyProvided.subtract(item.getPrice());
                    UserOutput.dispenseItem(item);
                    break;
                } else if (item.getItemCount() < 1) {
                    System.out.println("NO LONGER AVAILABLE");
                    break;
                } else if (item.getPrice().compareTo(currentMoneyProvided) > 0){
                    UserOutput.notEnoughMoney();
                    break;
                }
            }
            logger.write(LocalDateTime.now() + "  " + item.getItemName() + "  "
                    + item.getSlot() + " $" + initialAmount + " $" + currentMoneyProvided);
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
        logger = new Logger("AuditFile.txt");
        logger.write(LocalDateTime.now() + "  CHANGE GIVEN:  $" + currentMoneyProvided + "  $0.00");

        int dollarCount = 0;
        int quarterCount = 0;
        int dimeCount = 0;
        int nickleCount = 0;
        double money = currentMoneyProvided.doubleValue();
        if (money == 0 ){
            System.out.println("Change: $0.00");
        } else {
            double moneyToPennies = money * 100;
            dollarCount = (int) (moneyToPennies / 100);
            moneyToPennies -= (dollarCount * 100);
            quarterCount = (int) (moneyToPennies  / 25);
            moneyToPennies -= quarterCount * 25;
            dimeCount = (int) (moneyToPennies / 10);
            moneyToPennies -= dimeCount * 10;
            nickleCount = (int) (moneyToPennies / 5);
        }
        return "Your change is: " + dollarCount + " dollars, " + quarterCount + " quarters, "
                + dimeCount + " dimes, and " + nickleCount + " nickles";
    }
}