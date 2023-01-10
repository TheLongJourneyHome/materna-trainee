package org.example.javaxercise.chap2;

import java.util.Scanner;

// for-loop
public class Factorial {
    public static void main(String[] args) {
/*        public static int multiplyExact(int x, int y):
        Returns the product of integer arguments x and y.
                It throws an ArithmeticException if the result overflows an int
        (which means if result is less than Integer.MIN_VALUE or greater than Integer.MAX_VALUE).*/

        Scanner sc = new Scanner(System.in);

        int input;
        long result = 1;
        String calcPath = "1";
        String resultString;


        System.out.print("Calculate the factorial of: ");
        input = sc.nextInt();

        if (input < 0) {
            System.out.println("Number must not be negative");
        } else {
            if (input > 1) {
                for (int i = 1; i < input; i++) {
                    calcPath += " * " + (i + 1);
                    result = Math.multiplyExact(result, i + 1);
                }
                calcPath += " = " + result;
                resultString = input + "! = " + calcPath;
            } else { // == 0 || == 1
                resultString = input + "! = " + result;
            }
            System.out.println(resultString);
        }

    }

    // another solution without creating too many variables
/*    public static void main( String[] args ) {
        //tag::solution[]
        System.out.println( "Enter a number:" );
        int n = new java.util.Scanner( System.in ).nextInt();

        if ( n < 0 )
            System.err.println( "Number must not be negative" );
        else if ( n < 2 )
            System.out.printf( "%d! = 1%n", n );
        else {
            System.out.printf( "%d! = 1", n );
            long factorial = 1;

            for ( int multiplier = 2; multiplier <= n; multiplier++ ) {
                System.out.printf( " * %d", multiplier );
                factorial *= multiplier;
            }

            System.out.println( " = " + factorial );
        }
        //end::solution[]
    }*/
}
