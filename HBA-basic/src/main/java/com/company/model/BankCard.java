package com.company.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class BankCard {

    protected int balance = 0;

    public void upBalance(int addedMoney) {
        assert (addedMoney >= 0);
        balance += addedMoney;
    }

    public int getBalance() {
        return balance;
    }

    public abstract boolean toPay(int payMoneySize);


    public abstract int getAvailableCreditFacilities();

    public Map<String, Integer> getAllAvailableFunds() {
        Map<String, Integer> funds = new HashMap<>();
        funds.put("balance", balance);
        return Collections.unmodifiableMap(funds);
    }
}
