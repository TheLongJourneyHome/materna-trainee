package org.example.javexercise.chap2;

import java.util.Scanner;

// for-loop
public class SvgRotatingRect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int angle;
        int repeats;
        int totalAngle = 0;

        System.out.println("Enter angle: ");
        angle = sc.nextInt();
        System.out.println("Enter number of repeats: ");
        repeats = sc.nextInt();
        System.out.println();

        System.out.println("<svg height=\"200\" width=\"200\">");
        for (int i = 0; i < repeats; i++) {

            System.out.printf("""
                 <rect x="50" y="50" width="100" height="100" stroke="black" fill="none"
                       transform="rotate(%d 100 100)" />
                """, totalAngle);

            totalAngle += angle;
            if (totalAngle >= 360) {
                totalAngle -= 360;
            }

        }
        System.out.println("</svg>");

        // you can directly copy-paste inside " " to automatically generate \" for '"'
        /*System.out.println(" <rect x=\"50\" y=\"50\" width=\"100\" height=\"100\" stroke=\"black\" fill=\"none\"\n" +
                "       transform=\"rotate(60 100 100)\" />");*/
    }
}
