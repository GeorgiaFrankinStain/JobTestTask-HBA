package com.company;

import com.company.model.BankCard;
import com.company.model.CreditCard;
import com.company.model.DebitCard;

public class Main {

    public static void main(String[] args) {

/*        {
            BankCard card = new DebitCard();
            card.upBalance(10);
            card.toPay(10);
            System.out.println(card.getAllAvailableFunds());
        }*/


        {
            System.out.println("==== credit card with limit 10 000 ====");
            CreditCard card = new CreditCard(10000);
            System.out.println(card.getAllAvailableFunds());
            System.out.println();



            System.out.println("==== after up balance on 5000 ====");
            card.upBalance(5000);
            System.out.println(card.getAllAvailableFunds());
            System.out.println();




            System.out.println("==== after pay 5000 ====");
            card.toPay(5000);
            System.out.println(card.getAllAvailableFunds());
            System.out.println();



            System.out.println("==== after pay 3000 ====");
            card.toPay(3000);
            System.out.println(card.getAllAvailableFunds());
            System.out.println();



            System.out.println("==== after up balance 2000 ====");
            card.upBalance(2000);
            System.out.println(card.getAllAvailableFunds());
            System.out.println();



            System.out.println("==== after up balance 2000 ====");
            card.upBalance(2000);
            System.out.println(card.getAllAvailableFunds());
            System.out.println();
        }

    }
}
