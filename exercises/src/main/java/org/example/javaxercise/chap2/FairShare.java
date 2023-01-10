package org.example.javaxercise.chap2;

import java.util.Scanner;

// modulo
public class FairShare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long loot;
        long captain; // 12345L
        long crew;
        int members;

        System.out.println("Number of bottles in total?");
        loot = sc.nextLong();

        captain = loot / 2; // if uneven he will get automatically lower amount
        crew = loot - captain;
        System.out.printf("Bottles for the captain: %d%n", captain);
        System.out.printf("Bottles for all crew members: %d%n", crew);

        System.out.println("Number of crew members?");
        members = sc.nextInt();

        System.out.printf("Fair share without remainder? %s%n", crew % members == 0);
    }
}
