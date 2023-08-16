package com.company.model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DebitCardTest {

    //<generalTests>
    @Test
    void toPay_in0() {
        BankCard card = new DebitCard();
        card.upBalance(10);
        card.toPay(10);
        assertEquals(card.getBalance(), 0);
    }

    @Test
    void toPay_in1() {
        BankCard card = new DebitCard();
        card.upBalance(10);
        card.toPay(9);
        assertEquals(card.getBalance(), 1);
    }

    @Test
    void toPay_in5() {
        BankCard card = new DebitCard();
        card.upBalance(10);
        card.toPay(5);
        assertEquals(card.getBalance(), 5);
    }

    @Test
    void toPay_getAvailableCreditFacilitiesAddBalance() {
        BankCard card = new DebitCard();
        card.upBalance(10);
        card.toPay(5);
        assertEquals(card.getAvailableCreditFacilities(), 0);
    }

    @Test
    void toPay_getAvailableCreditFacilities() {
        BankCard card = new DebitCard();
        assertEquals(card.getAvailableCreditFacilities(), 0);
    }

    @Test
    void upBalance_add0() {
        BankCard card = new DebitCard();
        card.upBalance(0);
        assertEquals(card.getBalance(), 0);
    }

    @Test
    void upBalance_add10() {
        BankCard card = new DebitCard();
        card.upBalance(10);
        assertEquals(card.getBalance(), 10);
    }
    //<generalTests>



    @Test
    void getAllAvailableFunds() {
        BankCard card = new DebitCard();
        card.upBalance(2000);
        card.toPay(1000);
        System.out.println(card.getAllAvailableFunds());
        Map<String, Integer> actualFunds = card.getAllAvailableFunds();
        Map<String, Integer> expectedFunds = new HashMap<>();
        expectedFunds.put("balance", 1000);


        assertEquals(expectedFunds, actualFunds);
    }
}