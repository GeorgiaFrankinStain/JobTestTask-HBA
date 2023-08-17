package com.company.model;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class CreditCard extends BankCard {
    private int limit = 0;
    private int balanceForDebtNegative = 0; //the value is always less than 0

    public CreditCard(int limit) {
        this.limit = limit;
    }

    public void upBalance(int addedMoney) {
        assert (addedMoney >= 0);
        if (addedMoney == 0) {
            return;
        }

        if (isThereMoneyDebt()) {
            upBalancePayDebt(addedMoney);
        } else {
            this.balance = this.getBalance() + addedMoney;
        }
    }

    public boolean toPay(int payMoney) {
        if (payMoney == 0) {
            return true;
        }

        assert (payMoney >= 0);

        return toPayPrivate(payMoney);
    }

    @Override
    public int getAvailableCreditFacilities() {
        assert (balanceForDebtNegative <= 0);
        return limit + balanceForDebtNegative;
    }

    @Override
    public Map<String, Integer> getAllAvailableFunds() {
        Map<String, Integer> funds = super.getAllAvailableFunds().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        funds.put("availableCreditFacilities", this.getAvailableCreditFacilities());
        return Collections.unmodifiableMap(funds);
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }




    private boolean toPayPrivate(int paySum) {
        if (isEnoughMoneyToPay(paySum)) {
            int remainPaySumForPayFromCreditLimit = payFromBalance(paySum);
            payFromCreditFacilities(remainPaySumForPayFromCreditLimit);
            return true;
        } else {
            return false;
        }
    }

    private boolean isEnoughMoneyToPay(int paySum) {
        return (this.getAvailableCreditFacilities() + this.getBalance()) >= paySum;
    }

    private int payFromBalance(int paySum) {
        if (this.getBalance() > 0) {
            boolean isEnoughOnlyBalanceToPay = this.getBalance() >= paySum;
            if (isEnoughOnlyBalanceToPay) {
                this.balance -= paySum;
                return 0;
            } else {
                int remainPaySumForPayFromCreditLimit = paySum - this.getBalance();
                this.balance = 0;
                return remainPaySumForPayFromCreditLimit;
            }
        } else {
            return paySum;
        }

    }

    private void payFromCreditFacilities(int remainPaySumForPayFromCreditLimit) {
        assert(this.getAvailableCreditFacilities() >= remainPaySumForPayFromCreditLimit);
        assert (remainPaySumForPayFromCreditLimit >= 0);
        this.balanceForDebtNegative -= remainPaySumForPayFromCreditLimit;
    }






    private boolean isThereMoneyDebt() {
        assert (balanceForDebtNegative <= 0);
        return balanceForDebtNegative < 0;
    }


    /**
     *
     *       MoneyForDebt           yes
     *    |-----|
     *    |       RemainsForBalance yes
     *    |     |-----|
     * |--------+--------|
     *    ^     0     ^
     *    debt        ownMoney
     *
     *
     * SITUATIONS
     * MoneyForDebt RemainsForBalance
     *          +    +
     *          +    -
     *          -    -    (try add 0 money)
     *
     * @return
     */

    private void upBalancePayDebt(int addedMoney) {
        boolean isEnoughMoneyToPayInFull = addedMoney >= Math.abs(balanceForDebtNegative);
        if (isEnoughMoneyToPayInFull) {
            int remainsMoneyForBalance = toFullPaymentDebt(addedMoney);
            this.upBalance(remainsMoneyForBalance);
        } else {
            partialPaymentDebt(addedMoney);
        }


    }

    private int toFullPaymentDebt(int addedMoney) {
        int remainsMoneyForBalance = addedMoney - Math.abs(balanceForDebtNegative);
        this.balanceForDebtNegative = 0;
        return remainsMoneyForBalance;
    }

    private void partialPaymentDebt(int addedMoney) {
        this.balanceForDebtNegative += addedMoney;
        assert(this.balanceForDebtNegative <= 0);
    }
}
