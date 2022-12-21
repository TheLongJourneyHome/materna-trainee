package org.example.javexercise.chap2;

import java.util.Scanner;

// if-else
public class Blackjack {
    public static void main(String[] args) {
        // end program with 1 input
        Scanner sc = new Scanner(System.in);
        int dealer;
        int player;
        final int BLACKJACK = 21;

        System.out.println("Enter (positive) value for dealer and bigger than 1: ");
        dealer = Math.abs(sc.nextInt());
        System.out.println("Enter (positive) value for player and bigger than 1: ");
        player = Math.abs(sc.nextInt());

        if (dealer < 2 || player < 2) {
            System.out.println("Value can't be lower than 2");
        } else if (dealer > BLACKJACK) {
            System.out.printf("Player wins with number %d%n", player);
        } else if (player > BLACKJACK) {
            System.out.printf("Dealer wins with number %d%n", dealer);
        } else {
            System.out.printf("%s wins with number %d", (Math.max(dealer, player) == dealer ? "Dealer" : "Player"), Math.max(dealer, player));
        }
    }
}
