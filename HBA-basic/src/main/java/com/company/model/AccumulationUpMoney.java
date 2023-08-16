package com.company.model;

import java.util.Map;

public class AccumulationUpMoney extends DebitCard {
    private double accumulateMoney = 0;
    private double percent = 0;

    public AccumulationUpMoney(double percent) {
        assert (percent >= 0);
        assert (percent <= 1);
        this.percent = percent;
    }

    @Override
    public void upBalance(int addedMoney) {
        accumulateMoney += ((double) addedMoney) * percent;
        super.upBalance(addedMoney);
    }

    @Override
    public Map<String, Integer> getAllAvailableFunds() {
        Map<String, Integer> funds = super.getAllAvailableFunds();
        funds.put("accumulateMoney", (int) this.getAccumulateMoney());
        return funds;
    }

    public int getAccumulateMoney() {
        return (int) accumulateMoney;
    }
}
