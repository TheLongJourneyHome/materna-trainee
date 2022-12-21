package org.example.javexercise.chap2;

import java.util.Scanner;

// for-loop
public class IsFactorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final long START_INPUT;
        long input;
        int counter = 1;
//        long rest = 0;


        System.out.println("Enter a number: ");
        input = sc.nextLong();
        START_INPUT = input;

        // test if the number can be divided by 9 - 1
        for (int i = 2; input % i == 0 && input > 0; i++) {
            input /= i;
//            rest = input % i;
            /*System.out.println(input);
            System.out.println(rest);*/
            counter++;
        }

        // if input = 1, then won't enter for loop, but still valid here
        if (input != 1) {
            System.out.printf("%d is not a factorial%n", START_INPUT);
        } else {
            System.out.printf("%d = %d!%n", START_INPUT, counter);
        }
        System.out.println(counter);
    }

    // other solution
/*    public class IsFactorial {

        public static void main( String[] args ) {
            //tag::solution[]
            System.out.println( "Enter a number:" );
            long n = new Scanner( System.in ).nextLong();

            if ( n < 1 )
                System.err.println( "Factorials are always >= 1" );
            else {
                long number  = n;
                long divisor = 2;

                while ( number % divisor == 0 ) {
                    number /= divisor;
                    divisor++;
                }

                if ( number == 1 )
                    System.out.printf( "%d = %d!%n", n, divisor - 1 );
                else
                    System.out.printf( "%d is not a factorial%n", n );
            }
            //end::solution[]
        }*/
}
