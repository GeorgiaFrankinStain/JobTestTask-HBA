package com.company.model;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class BonusDebitCard extends DebitCard {
    private double percentBonus = 0;
    private double bonusSum = 0;

    public BonusDebitCard(double percentBonus) {
        assert (0 <= percentBonus);
        assert (percentBonus <= 1);
        this.percentBonus = percentBonus;
    }

    @Override
    public boolean toPay(int payMoneySize) {
        boolean toPayResult = super.toPay(payMoneySize);
        if (toPayResult) {
            double payMoneySizeDouble = payMoneySize;
            this.bonusSum += payMoneySizeDouble * percentBonus;
        }
        return toPayResult;
    }

    @Override
    public Map<String, Integer> getAllAvailableFunds() {
        Map<String, Integer> funds = super.getAllAvailableFunds().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        funds.put("bonusDebit", this.getBonusSum());
        return Collections.unmodifiableMap(funds);
    }

    public double getPercentBonus() {
        return percentBonus;
    }


    public int getBonusSum() {
        return (int) bonusSum;
    }
}
