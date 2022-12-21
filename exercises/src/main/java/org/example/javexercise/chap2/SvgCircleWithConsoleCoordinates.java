package org.example.javexercise.chap2;

import java.util.Scanner;

public class SvgCircleWithConsoleCoordinates {
    public static void main(String[] args) {
        System.out.print("Enter x value: ");
        int x = new Scanner(System.in).nextInt();
        System.out.print("Enter y value: ");
        int y = new Scanner(System.in).nextInt();

        double rnd = Math.random(); // Math.random() = (0.0 ... 1.0)
        double r = (rnd * 10) + 10; // 10 <= r < 20


        System.out.printf("<svg height=\"400\" width=\"1000\">%n" +
                "   <circle cx=\"%d\" cy=\"%d\" r=\"%s\" />%n" +
                "</svg>%n", x, y, r);
        System.out.println();
    }
}
