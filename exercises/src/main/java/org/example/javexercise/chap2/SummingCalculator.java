package org.example.javexercise.chap2;

import java.util.Scanner;

// for-loop - infinite loop until condition
// do-while-loop
public class SummingCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;


        System.out.println("Press 0 to give the result and end the program");
        System.out.println("Add following numbers: ");
        // could write body code inside the for (...)
        for (int addedNumber; /*no condition, always true*/; /*do something*/) {
            addedNumber = sc.nextInt();
            if (addedNumber == 0) {
                break;
            }
            result += addedNumber;
        }

        System.out.println("Sum: " + result);
    }

    // more example solutions
/*    public static void main( String[] args ) {
        //tag::solution1[]
        final int END_OF_INPUT = 0;
        int sum   = 0;
        int input = 0;

        do {
          input = new java.util.Scanner( System.in ).nextInt();
          sum += input;
        } while ( input != END_OF_INPUT );

        System.out.printf( "Sum: %d%n", sum );
        //end::solution1[]

        //tag::solution2[]
        final int END_OF_INPUT = 0;
        int sum = 0;

        for ( int input;
              (input=new java.util.Scanner(System.in).nextInt()) != END_OF_INPUT; )
            sum += input;

        System.out.printf( "Sum: %d%n", sum );
        //end::solution2[]
    }*/
}
