package com.techelevator.application;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class VendingMachineTest {

    @Test
    public void selectOptionTest_returnCurrentAmount_withoutBuying_with_incorrectSlotPassed(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.readFile();
        BigDecimal expected = new BigDecimal(5);

        BigDecimal startingMoney = new BigDecimal(5);
        String option = "d6";
        BigDecimal actual = vendingMachine.selectOption(startingMoney, "d6");

        assertEquals(expected, actual);
    }
    @Test
    public void getFeedMoneyTest_update_currentMoneyProvided_with_moneyFed_5(){
        VendingMachine vendingMachine = new VendingMachine();
        BigDecimal expected = new BigDecimal(5);

        BigDecimal startingMoney = new BigDecimal(0);
        String moneyFed = "5";
        BigDecimal actual = vendingMachine.getFeedMoney(startingMoney, moneyFed);

        assertEquals(expected, actual);
    }
    @Test
    public void getFeedMoneyTest_wrongBill_currentMoneyProvided_with_moneyFed_2(){
        VendingMachine vendingMachine = new VendingMachine();
        BigDecimal expected = new BigDecimal(0);

        BigDecimal startingMoney = new BigDecimal(0);
        String moneyFed = "2";
        BigDecimal actual = vendingMachine.getFeedMoney(startingMoney, moneyFed);

        assertEquals(expected, actual);
    }
    @Test
    public void makeChangeTest_passIn_2dollars80Cents_return_correct_change(){
        VendingMachine vendingMachine = new VendingMachine();
        String expected = "Your change is: 2 dollar(s), 3 quarter(s), 0 dime(s), and 1 nickle(s)";

        BigDecimal startingMoney = new BigDecimal(2.80);
        String actual = vendingMachine.makeChange(startingMoney);

        assertEquals(expected, actual);
    }
    @Test
    public void makeChangeTest_passIn_zeroDollars_return_correct_change(){
        VendingMachine vendingMachine = new VendingMachine();
        String expected = "Change: $0.00";

        BigDecimal startingMoney = new BigDecimal(0);
        String actual = vendingMachine.makeChange(startingMoney);

        assertEquals(expected, actual);
    }

}