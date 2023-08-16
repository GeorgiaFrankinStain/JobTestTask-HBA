package com.company.model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardTest {

    //<generalTests>

    @Test
    void toPay_in0() {
        BankCard card = new CreditCard(10);
        card.upBalance(10);
        card.toPay(10);
        assertEquals(card.getBalance(), 0);
    }

    @Test
    void toPay_in1() {
        BankCard card = new CreditCard(10);
        card.upBalance(10);
        card.toPay(9);
        assertEquals(card.getBalance(), 1);
    }

    @Test
    void toPay_in5() {
        BankCard card = new CreditCard(10);
        card.upBalance(10);
        card.toPay(5);
        assertEquals(card.getBalance(), 5);
    }

    @Test
    void toPay_getAvailableCreditFacilitiesAddBalance() {
        BankCard card = new CreditCard(10);
        card.upBalance(10);
        card.toPay(5);
        assertEquals(card.getBalance(), 5);
    }

    @Test
    void toPay_getAvailableCreditFacilities() {
        BankCard card = new CreditCard(0);
        assertEquals(card.getAvailableCreditFacilities(), 0);
    }

    @Test
    void upBalance_add0() {
        BankCard card = new CreditCard(10);
        card.upBalance(0);
        assertEquals(card.getBalance(), 0);
    }

    @Test
    void upBalance_add10() {
        BankCard card = new CreditCard(10);
        card.upBalance(10);
        assertEquals(card.getBalance(), 10);
    }

    //</generalTests>



    @Test
    void upBalance_createMinDebt() {
        CreditCard card = new CreditCard(10);
        card.toPay(10);
        assertEquals(0, card.getAvailableCreditFacilities());
    }

    @Test
    void upBalance_createMinDebtAfterUpBalance() {
        CreditCard card = new CreditCard(10);
        card.upBalance(10);
        card.toPay(20);
        assertEquals(0, card.getAvailableCreditFacilities());
    }

    @Test
    void upBalance_tryCreditMoreLimit() {
        CreditCard card = new CreditCard(10);
        card.upBalance(10);
        assertEquals(false, card.toPay(21));
    }

    @Test
    void upBalance_tryCreditBorderLimit() {
        CreditCard card = new CreditCard(10);
        card.upBalance(10);
        assertEquals(false, card.toPay(21));
    }

    @Test
    void upBalance_payDebt() {
        CreditCard card = new CreditCard(10);
        card.toPay(10);
        card.upBalance(10);
        assertEquals(10, card.getAvailableCreditFacilities());
    }

    @Test
    void upBalance_payDebtBalance() {
        CreditCard card = new CreditCard(10);
        card.toPay(10);
        card.upBalance(10);
        assertEquals(0, card.getBalance());
    }

    @Test
    void upBalance_payDebtBalance2up() {
        CreditCard card = new CreditCard(10);
        card.toPay(10);
        card.upBalance(20);
        assertEquals(10, card.getBalance());
    }

    @Test
    void upBalance_payDebtBalance2upCreditFacilities() {
        CreditCard card = new CreditCard(10);
        card.toPay(10);
        card.upBalance(20);
        assertEquals(10, card.getAvailableCreditFacilities());
    }

    @Test
    void getAllAvailableFunds() {
        CreditCard card = new CreditCard(10);
        card.upBalance(2000);
        card.toPay(1000);
        System.out.println(card.getAllAvailableFunds());
        Map<String, Integer> actualFunds = card.getAllAvailableFunds();
        Map<String, Integer> expectedFunds = new HashMap<>();
        expectedFunds.put("balance", 1000);
        expectedFunds.put("availableCreditFacilities", 0);


        assertEquals(expectedFunds, actualFunds);
    }
}