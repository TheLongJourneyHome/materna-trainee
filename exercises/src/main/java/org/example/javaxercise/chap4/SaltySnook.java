package org.example.javaxercise.chap4;

import java.util.Objects;

// Arrays
// equals
public class SaltySnook {
    public static void main(String[] args) {
        String[] signs1 = { "F", "DO", "MOS", "MOS", "MOS", "MOS", "WES" };
        isProbablyApproaching( signs1 );  // true
        System.out.println();

        String[] signs2 = { "F", "DO", "MOS", "MOS", "WES", "MOS", "MOS" }; // counter 1, 1
        isProbablyApproaching( signs2 );  // false
        System.out.println();

        String[] signs3 = { "F", "O", "O", "O", "F", "O", "O", "O", "O", "O" };
        isProbablyApproaching( signs3 );
        System.out.println();

        String[] signs4 = { "F", "O", "O", "O", "F", "O", "O", "O", "F", "O", "O" };
        isProbablyApproaching( signs4 );
        System.out.println();
    }

    static boolean isProbablyApproaching(String[] signs) {
        Objects.requireNonNull(signs); // null check String array
        boolean savedSign = false;
        String currentSign = "";
        int counter = 0;

        for (int i = 0; i < signs.length; i++) {
            Objects.requireNonNull(signs[i]);

            if (i < signs.length - 1) { // when reached last, don't check next

                if (!savedSign) { // if not assign yet or reset
                    currentSign = signs[i];
/*                    System.out.println(currentSign);
                    System.out.println(currentSign.equals(signs[i+1]));*/
                    savedSign = true;
                }
                if (currentSign.equals(signs[i+1])) { // check current sign
                    counter++;
                    System.out.println(counter);
                    if (counter >= 3) { // once we reached our goal return true ( 3 more of the same)
                        System.out.println(true);
                        return true;
                    }
                } else { // reset once it's not 0 anymore
                    savedSign = false;
                    counter = 0;
                }

            }

        } // if we never returned true, then it must be false

        System.out.println(false);
        return false;
    }
}


// other solution
/*
public class SaltySnook {
    //tag::solution[]
    public static boolean isProbablyApproaching( String[] signs ) {

        final int MIN_OCCURRENCES = 4;

        if ( signs.length < MIN_OCCURRENCES )
            return false;

        for ( int i = 0, count = 1; i < signs.length - 1; i++ ) {
            String currentSign = Objects.requireNonNull( signs[ i ] );
            String nextSign    = Objects.requireNonNull( signs[ i + 1 ] );
            if ( currentSign.equals( nextSign ) ) {
                count++;
                if ( count == MIN_OCCURRENCES )
                    return true;
            }
            else // ! currentSign.equals( nextSign )
                count = 1;
        }
        return false;
    }
    //end::solution[]
    //      count = currentSign.equals( nextSign ) ? count + 1 : 1;
    //      if ( count == MIN_OCCURRENCES ) return true;

    class SaltySnookAlternativeSolution  {
        public static boolean isProbablyApproaching( String[] signs ) {
            if ( signs.length < 4 )
                return false;

            for ( int i = 0; i < signs.length - 3; i++ )
                if (    signs[ i     ].equals( signs[ i + 1 ] )
                        && signs[ i + 1 ].equals( signs[ i + 2 ] )
                        && signs[ i + 2 ].equals( signs[ i + 3 ] ) )
                    return true;

            return false;
        }
    }

    public static void main( String[] args ) {
        String[] signs1 = { "F", "DO", "MOS", "MOS", "MOS", "MOS", "WES" };
        System.out.println( isProbablyApproaching( signs1 ) );   // true

        String[] signs2 = { "F", "DO", "MOS", "MOS", "WES", "MOS", "MOS" };
        System.out.println( isProbablyApproaching( signs2 ) );  // false
    }*/
