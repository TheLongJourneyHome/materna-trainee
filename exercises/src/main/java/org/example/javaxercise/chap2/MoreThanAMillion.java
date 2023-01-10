package org.example.javaxercise.chap2;

import java.util.Scanner;

// conditional operator ? :
public class MoreThanAMillion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter x value: ");
        double x = sc.nextDouble();
        System.out.print("Enter y value: ");
        double y = sc.nextDouble();
        System.out.print("Enter z value: ");
        double z = sc.nextDouble();

        System.out.printf("Is x + y + z = 1_000_000 or more?: %s%n", x+y+z >= 1_000_000);
        System.out.println(x+y+z);
    }
}
