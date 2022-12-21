package org.example.javexercise.chap2;

import java.util.Scanner;

// modulo
public class HasCommonDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1;
        int num2;

        int num1Digit1;
        int num1Digit2;
        int num2Digit1;
        int num2Digit2;

        boolean hasCommonDigits;

        System.out.println("Enter 2 numbers in the range 0-99 (only last 2 digits count): ");
        System.out.print("Number 1: ");
        num1 = sc.nextInt();
        System.out.print("Number 2: ");
        num2 = sc.nextInt();

        // only last 2 digits accepted -> modulo 100 so only the rest is counted
        num1 = num1 % 100;
        num2 = num2 % 100;

        num1Digit1 = num1 / 10; // first digit / -> 35 / 10 = 3
        num1Digit2 = num1 % 10; // second digit % -> 35 % 10 = 5
        num2Digit1 = num2 / 10;
        num2Digit2 = num2 % 10;

        hasCommonDigits = (num1Digit1 == num2Digit1) ||
                (num1Digit1 == num2Digit2) ||
                (num1Digit2 == num2Digit1) ||
                (num1Digit2 == num2Digit2);

        System.out.printf(
                "Number 1: %d%n" +
                "Digit 1: %d%n" +
                "Digit 2: %d%n", num1, num1Digit1, num1Digit2);
        System.out.printf(
                "Number 2: %d%n" +
                "Digit 1: %d%n" +
                "Digit 2: %d%n", num2, num2Digit1, num2Digit2);

        System.out.printf("Number 1 and number 2 have common digit(s)? %s", hasCommonDigits);
    }
}
