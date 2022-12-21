package org.example.javexercise.chap2;

import java.util.Scanner;

// conditional operator ? :
public class NumberOfBottles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfBottles;
        String amountOfBottles;

        System.out.println("Amount of bottles: ");
        noOfBottles = sc.nextInt();
        amountOfBottles = noOfBottles == 1 ? "bottle" : "bottles";

        System.out.printf("%d %s of rum", noOfBottles, amountOfBottles);
    }
}
