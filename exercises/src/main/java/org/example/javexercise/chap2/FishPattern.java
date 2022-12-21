package org.example.javexercise.chap2;

import java.util.Scanner;

// nested for-loop
// concat and how to use
/*
    String s1="java string";

        s1.concat("is immutable");
        System.out.println(s1); -> "java string"

        s1=s1.concat(" is immutable so assign it explicitly");
        System.out.println(s1); -> "java string is immutable so assign it explicitly"
*/
public class FishPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int repetitions;
        String result = "";

        System.out.println("Enter amount of repetitions: ");
        repetitions = sc.nextInt();

        for (int i = 0; i < repetitions; i++) {

            for (int j = 0; j < repetitions; j++) {
                result = result.concat("><> ");
            }

            for (int k = 0; k < repetitions; k++) {
                result = result.concat("<>< ");
            }

            result = result.concat("\n");
        }

        System.out.println(result);
    }
}
