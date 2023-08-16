package com.company;

import com.company.model.BankCard;
import com.company.model.DebitCard;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello_world");


        BankCard card = new DebitCard();
        card.upBalance(10);
        card.toPay(10);
    }
}
