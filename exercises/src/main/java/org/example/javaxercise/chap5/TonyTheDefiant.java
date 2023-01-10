package org.example.javaxercise.chap5;

import java.util.Scanner;

// Zeichenketten
// contains
// equals
public class TonyTheDefiant {
    public static void main(String[] args) {
        tonysAnswer();
    }

    public static void tonysAnswer() {
        Scanner sc = new Scanner(System.in);
        String question;
        String answer;
        System.out.println("The police officer is asking: ");
        question = sc.nextLine();

        answer = question.isEmpty() ? "...?" : question.toLowerCase().equals("no idea?") ? "Aye!" : question.contains("?") ? question + " No idea!" : "...";

        System.out.println(answer);
    }
}

// solution
/*
public static void main( String[] args ) {
    //tag::solution[]
    String input = new Scanner( System.in ).nextLine().trim();
    if ( input.equalsIgnoreCase( "no idea?" ) )
        System.out.println( "Aye!" );
    else if ( input.endsWith( "?" ) ) {
        System.out.println( input + " No idea!" );
    }
    //end::solution[]
}
*/


//    In Java, it is generally recommended to use the String.equals() method to compare two strings, rather than the == operator.
/*
    String str1 = "hello";
    String str2 = "hello";

// Using the == operator
if (str1 == str2) {
        System.out.println("The strings are equal");
        } else {
        System.out.println("The strings are not equal");
        }

// Using the String.equals() method
        if (str1.equals(str2)) {
        System.out.println("The strings are equal");
        } else {
        System.out.println("The strings are not equal");
        }*/
/*
In this case, the == operator will return false, because str1 and str2 refer to two different memory locations,
even though they have the same contents. The String.equals() method, on the other hand, will return true,
because the contents of the two strings are equal.
So, to compare the contents of two strings in Java, it is generally recommended to use the String.equals() method, rather than the == operator.*/
