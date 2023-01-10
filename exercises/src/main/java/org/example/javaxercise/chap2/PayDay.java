package org.example.javaxercise.chap2;

import java.util.Scanner;

// if-else
public class PayDay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double discountRate = 0.1; // 10%
        double overpayRate = 0.2; // 20%
        double amountOwed;
        double minPay;
        double maxPay;
        double amountPayed;

        System.out.println("Enter amount of money Tort has to pay back: ");
        amountOwed = sc.nextDouble();

        System.out.println("Tort owes Bonny " + amountOwed + " Liretta");
        minPay = amountOwed - amountOwed * discountRate;
        maxPay = amountOwed + amountOwed * overpayRate;
        System.out.printf("(min: %s, max: %s)%n", minPay, maxPay);
        System.out.println();

        System.out.print("Torte pays Bonny: ");
        amountPayed = sc.nextDouble();

        if (amountPayed < minPay || amountPayed > maxPay) {
            System.out.println("Bonny: You son of a bitch!");
        } else {
            System.out.println("Good boy!");
        }
    }
}
