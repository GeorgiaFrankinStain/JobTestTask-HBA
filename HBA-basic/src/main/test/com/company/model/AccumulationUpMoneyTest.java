package com.company.model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AccumulationUpMoneyTest {

    @Test
    void upBalance_accumulateMoney() {
        AccumulationUpMoney card = new AccumulationUpMoney(0.005);
        card.upBalance(1000);
        assertEquals(5, card.getAccumulateMoney());
    }

    @Test
    void getAllAvailableFunds() {
        AccumulationUpMoney card = new AccumulationUpMoney(0.005);
        card.upBalance(1000);
        Map<String, Integer> actualFunds = card.getAllAvailableFunds();
        Map<String, Integer> expectedFunds = new HashMap<>();
        expectedFunds.put("balance", 1000);
        expectedFunds.put("accumulateMoney", 5);


        assertEquals(expectedFunds, actualFunds);
    }
}