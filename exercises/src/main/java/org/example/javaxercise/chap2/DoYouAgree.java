package org.example.javaxercise.chap2;

import java.util.Scanner;

// switch-case
public class DoYouAgree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer;

        System.out.println("Do you agree?");
        answer = sc.nextLine().toLowerCase();

        switch (answer) {
            case "ay", "aye", "ay, ay", "ja", "joo" -> System.out.println("Keep it up!");
            default -> System.out.println("Don't you dare!");
        }

        // old switch case with fall through
        /*switch (answer) {
            case "ay", "aye", "ay, ay", "ja", "joo":
                System.out.println("Keep it up!");
                break;
            default: System.out.println("Don't you dare!");
        }*/
        // with if
        /*if (answer == "ay" || answer == "aye" || answer == "ay, ay" ||
        answer == "ja" || answer == "joo") {
            System.out.println("Keep it up!");
        } else {
            System.out.println("Don't you dare!");
        }*/
    }
}
