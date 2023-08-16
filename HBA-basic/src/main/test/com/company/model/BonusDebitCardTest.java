package com.company.model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BonusDebitCardTest {

    @Test
    void getAllAvailableFunds_0() {
        BonusDebitCard card = new BonusDebitCard(0.1);
        card.upBalance(100);
        assertEquals(0, card.getBonusSum());
    }

    @Test
    void getAllAvailableFunds_0Bonus() {
        BonusDebitCard card = new BonusDebitCard(0.0);
        card.upBalance(100);
        card.toPay(100);
        assertEquals(0, card.getBonusSum());
    }

    @Test
    void getAllAvailableFunds_1Bonus() {
        BonusDebitCard card = new BonusDebitCard(0.01);
        card.upBalance(100);
        card.toPay(100);
        assertEquals(1, card.getBonusSum());
    }

    @Test
    void getAllAvailableFunds_5Bonus() {
        BonusDebitCard card = new BonusDebitCard(0.01);
        card.upBalance(500);
        card.toPay(500);
        assertEquals(5, card.getBonusSum());
    }

    @Test
    void getBonusSum() {
        BonusDebitCard card = new BonusDebitCard(0.05);
        card.upBalance(100);
        card.toPay(100);
        assertEquals(5, card.getBonusSum());
    }

    @Test
    void getAllAvailableFunds() {
        BonusDebitCard card = new BonusDebitCard(0.005);
        card.upBalance(2000);
        card.toPay(1000);
        System.out.println(card.getAllAvailableFunds());
        Map<String, Integer> actualFunds = card.getAllAvailableFunds();
        Map<String, Integer> expectedFunds = new HashMap<>();
        expectedFunds.put("balance", 1000);
        expectedFunds.put("bonusDebit", 5);


        assertEquals(expectedFunds, actualFunds);
    }
}