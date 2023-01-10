package org.example.javaxercise.chap2;

import java.util.Scanner;

// modulo
public class CoinMachine {
    public static void main(String[] args) {
        /*Example
        Please enter amount of money:
        12,91
        6 x 2 Liretta
        0 x 1 Liretta
        1 x 50 Lirettacent
        2 x 20 Lirettacent
        0 x 10 Lirettacent
        0 x 5 Lirettacent
        0 x 2 Lirettacent
        1 x 1 Lirettacent*/
        Scanner sc = new Scanner(System.in);
        double totalMoney;
        int moneyInCents;
        int liretta2;
        int liretta1;
        int lirettacent50;
        int lirettacent20;
        int lirettacent10;
        int lirettacent5;
        int lirettacent2;
        int lirettacent1;

        System.out.println("Please enter amount of money: ");
        totalMoney = sc.nextDouble(); // input floating point values in CLI with '.' on a German keyboard, not ','
        moneyInCents = (int) (totalMoney * 100);

        liretta2 = moneyInCents / 200;
        moneyInCents %= 200;

        liretta1 = moneyInCents / 100;
        moneyInCents %= 100;

        lirettacent50 = moneyInCents / 50;
        moneyInCents %= 50;

        lirettacent20 = moneyInCents / 20;
        moneyInCents %= 20;

        lirettacent10 = moneyInCents / 10;
        moneyInCents %= 10;

        lirettacent5 = moneyInCents / 5;
        moneyInCents %= 5;

        lirettacent2 = moneyInCents / 2;
        moneyInCents %= 2;

        lirettacent1 = moneyInCents;
//        moneyInCents %= 1;

        System.out.printf("%d x 2 Liretta%n" +
                "%d x 1 Liretta%n" +
                "%d x 50 Lirettacent%n" +
                "%d x 20 Lirettacent%n" +
                "%d x 10 Lirettacent%n" +
                "%d x 5 Lirettacent%n" +
                "%d x 2 Lirettacent%n" +
                "%d x 1 Lirettacent%n",
                liretta2,
                liretta1,
                lirettacent50,
                lirettacent20,
                lirettacent10,
                lirettacent5,
                lirettacent2,
                lirettacent1);
    }
}
