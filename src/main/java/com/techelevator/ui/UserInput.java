package com.techelevator.ui;


import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 *
 * Dependencies: None
 */
public class UserInput {
    private static Scanner scanner = new Scanner(System.in);
    private static BigDecimal currentMoneyProvided = new BigDecimal(0.00);

    public static String getHomeScreenOption() {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();
        System.out.println("option = " + option);
        if (option.equals("d")) {
            return "display";
        }
        else if (option.equals("p")) {
            return "purchase";
        }
        else if (option.equals("e")) {
            return "exit";
        }
        else {
            return "";
        }

    }

    public static String getPurchaseScreenOption() {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("M) Feed Money");
        System.out.println("S) Select Item");
        System.out.println("F) Finish Transaction");
        System.out.println();
        System.out.println("Current Money Provided: $" + currentMoneyProvided);

        System.out.println();
        System.out.print("Please select an option: ");

        while (true){
            String selectedOption = scanner.nextLine();
            String option = selectedOption.trim().toLowerCase();
            System.out.println("option = " + option);
            if (option.equals("m")) {
                getFeedMoney();

            } else if (option.equals("s")) {
                getSelectItem();

            } else if (option.equals("f")) {
                return "Finish Transaction";
            } else {
                return "";
            }
        }
    }
    public static void getFeedMoney(){
        System.out.println();
        System.out.print("Feed Money Here >>> ");
        String moneyFedInput = scanner.nextLine();
        int moneyFedInt = Integer.parseInt(moneyFedInput);

       if (moneyFedInt == 1 || moneyFedInt == 5 ||
               moneyFedInt == 10 || moneyFedInt == 20){
            BigDecimal moneyFed = new BigDecimal(moneyFedInt);
            currentMoneyProvided = currentMoneyProvided.add(moneyFed);
            System.out.println("Current Money Provided: $" + currentMoneyProvided);
            getPurchaseScreenOption();
        } else {
            System.out.println("Not valid bill. Amounts accepted: $1, $5, $10, $20");
            getPurchaseScreenOption();
        }
    }

    public static void getSelectItem(){
        UserOutput.displayItemList();

    }

}

