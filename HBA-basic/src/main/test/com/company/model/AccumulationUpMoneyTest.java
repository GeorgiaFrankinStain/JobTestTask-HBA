package com.company.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccumulationUpMoneyTest {

    @Test
    void upBalance_accumulateMoney() {
        AccumulationUpMoney card = new AccumulationUpMoney(0.005);
        card.upBalance(1000);
        assertEquals(5, card.getAccumulateMoney());
    }
}