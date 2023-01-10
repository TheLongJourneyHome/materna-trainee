package org.example.javaxercise.chap2;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

// for-loop
public class BonnysPearls {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int repeats;
        int gapBetween = 10;
        int x = 20;
        int y = 20;
//        int randomColor = (int) (Math.random() * 3 + 1);
        String color;

        System.out.println("Enter amount of pearls for the necklace: ");
        repeats = sc.nextInt();


        System.out.println("<svg height=\"100\" width=\"1000\">");
        for (int i = 0; i < repeats; i++) {

            int randomColor = ThreadLocalRandom.current().nextInt(1,4); // origin (inclusive) ... bound (exclusive)
            color = randomColor == 1 ? "blue" : (randomColor == 2 ? "green" : "orange");

            System.out.printf(" <circle cx=\"%d\" cy=\"%d\" r=\"5\" fill=\"%s\" />%n", x + i * gapBetween, y, color);

//            x += gapBetween;

        }
        System.out.println("</svg>\n");
    }
}
