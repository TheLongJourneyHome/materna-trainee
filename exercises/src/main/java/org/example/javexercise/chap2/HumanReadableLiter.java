package org.example.javexercise.chap2;

import java.util.Scanner;

// if-else
public class HumanReadableLiter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double liquidQuantity;
        long amountLiters;

        System.out.println("Enter quantity in liters: ");
        liquidQuantity = sc.nextDouble();


        if (liquidQuantity >= 1.0) {
            amountLiters = (long) liquidQuantity; // 1 liter
            System.out.printf("approx. %s l %n", amountLiters);
        } else if (liquidQuantity >= 0.1) {
            amountLiters = (long) (liquidQuantity * 100); // 1 liter = 100 cl
            System.out.printf("approx. %s cl %n", amountLiters);
        } else if (liquidQuantity >= 0.001) {
            amountLiters = (long) (liquidQuantity * 1000); // 1 liter = 1000ml
            System.out.printf("approx. %s ml %n", amountLiters);
        } else {
            System.out.println("Value too small to display");
        }
    }
}
