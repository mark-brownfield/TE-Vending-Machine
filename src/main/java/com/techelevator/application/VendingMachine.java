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

    // File
    // List

    public void run() {

        // Try catch

        while(true) {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();
            System.out.println(choice);
            if(choice.equals("display")) {
                UserOutput.displayItemList();
            }
            else if(choice.equals("purchase")) {
                UserOutput.displayPurchaseScreen();
                String purchaseChoice = UserInput.getPurchaseScreenOption();
                System.out.println(purchaseChoice);
            }
            else if(choice.equals("exit")) {
                // good bye
                break;
            }
        }

    }
}
