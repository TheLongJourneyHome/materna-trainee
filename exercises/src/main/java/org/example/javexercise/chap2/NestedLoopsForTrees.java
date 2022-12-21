package org.example.javexercise.chap2;

import java.util.Scanner;

// nested for-loops
public class NestedLoopsForTrees {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input;


        System.out.println("Enter a number: ");
        input = sc.nextInt();
        System.out.println();

        // Flag
        for (int i = 1; i <= input; i++) {
            String result = "";
            for (int j = 1; j < i; j++) {
//                System.out.print(i + " ");
                result += i + " ";
            }
            result += i;
            System.out.println(result);
        }

        System.out.println();
        System.out.println();

        // Optional: Tree
        for (int a = 1; a <= input; a++) {
            String result = "";
            for (int b = 1; b <= input-a; b++) { // number of spaces
                result += " ";
            }
            for (int c = 1; c < a; c++) {
                result += a + " ";
            }
            result += a;
            System.out.println(result);
        }
    }
}
