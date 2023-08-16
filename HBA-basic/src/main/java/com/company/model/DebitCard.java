package com.company.model;

import java.util.HashMap;
import java.util.Map;

public class DebitCard extends BankCard {

    @Override
    public boolean toPay(int payMoneySize) {
        boolean isEnoughBalance = this.getBalance() >= payMoneySize;
        if (isEnoughBalance) {
            this.balance = this.getBalance() - payMoneySize;
        }

        return isEnoughBalance;
    }

    @Override
    public int getAvailableCreditFacilities() {
        return 0; //because debit card
    }

    @Override
    public Map<String, Integer> getAllAvailableFunds() {
        return super.getAllAvailableFunds();
    }
}
