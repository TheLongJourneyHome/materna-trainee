package org.example.javexercise.chap4;

import java.util.Arrays;

// Arrays
// vararg
// check digit in number
// swap array values
// continue
public class Tetraphobia {
    public static void main(String[] args) {
        int[] numbers = {1, 44, 2, 4, 43};
        int[] newNumbers = fourLast(numbers);
        System.out.println(Arrays.toString(newNumbers));

        int[] numbers2 = fourLast(4, 4, 44, 1234);
        System.out.println(Arrays.toString(numbers2));

    }

    public static int[] fourLast(int... numbers) {
        final int IS_FOUR = 4;
        if (numbers.length < 2) {
            return numbers;
        }

        for(int start = 0; start < numbers.length; start++) {
            // return to loop beginning, when number doesn't contain 4
            if (!containsDigit(IS_FOUR, numbers[start])) {
                continue;
            }
            // code below will only be executed when number contains 4

            // check from the other side now for a number that doesn't contain 4
            // don't check the values at position of start, else -> see fours > 0 result
//            for (int fours = 0; fours < numbers.length; fours++) { // [44, 4, 43, 2, 1]
//            for (int fours = numbers.length - 1; fours > 0; fours--) { // [1, 44, 4, 43, 2]
            for (int fours = numbers.length - 1; fours > start; fours--) { // [1, 2, 44, 4, 43]
                if (containsDigit(IS_FOUR, numbers[fours])) {
                    continue;
                }

                int savePosition = numbers[start];
                numbers[start] = numbers[fours];
                numbers[fours] = savePosition;
            }
        }

        return numbers;
    }

    public static boolean containsDigit(int digit, int value) {
        return String.valueOf(value).contains(String.valueOf(digit));
    }

    /*
    1, 44, 2, 4, 43
    [1, 2, 44, 4, 43] <- we are at numbers[2]: check first non 4 until pos 2
    [0][1][2][3][4]

    1: 1, 44, 2, 3, 43
    2: 1, 2, 44, 3, 43
    3: 1, 2, 3, 44, 43
    [1, 2, 3, 44, 43]
    */
}


// check if a number contains a specific digit
/*public class Test {

    you can convert the number to a string
    and use the contains method of the String class
    to check if the string contains the digit as a substring


    public static void checkDigit1() {
        int number = 12345;
        int digit = 3;

        if (String.valueOf(number).contains(String.valueOf(digit))) {
            System.out.println(number + " contains the digit " + digit);
        } else {
            System.out.println(number + " does not contain the digit " + digit);
        }
    }

    Alternatively, you can use the toString method of
    the Integer class instead of the String.valueOf method
    to convert the number to a string:


    public static void checkDigit2() {
        int number = 12345;
        int digit = 3;

        if (Integer.toString(number).contains(Integer.toString(digit))) {
            System.out.println(number + " contains the digit " + digit);
        } else {
            System.out.println(number + " does not contain the digit " + digit);
        }
    }
}*/


// solution
/*
//tag::solution[]
private static boolean containsFour( int number ) {
    return String.valueOf( number ).contains( "4" );
//        return number == 4; // not like this, because it only compares if the numbers are the same, but we want to know if the number contains the digit, 44 == 4 -> false, but with the string.contains it would be true
}

    public static int[] fourLast( int... numbers ) {

        if ( numbers.length < 2 )
            return numbers;

        for ( int startIndex = 0; startIndex < numbers.length; startIndex++ ) {
            if ( ! containsFour( numbers[ startIndex ] ) )
                continue; // return to the loop and continue

            // from right to left search the first number without a 4
            for ( int endIndex = numbers.length - 1;
                  endIndex > startIndex; endIndex-- ) {
                if ( containsFour( numbers[ endIndex ] ) )
                    continue;
                // swap number[i] (with 4) and number[j] no 4
                int swap = numbers[ startIndex ]; // save the first value where found 4
                numbers[ startIndex ] = numbers[ endIndex ]; // replace the first value where found no 4 (but from right to left) with the position of first 4 found
                numbers[ endIndex ]   = swap; // swap it
            }
        }
        return numbers;
    }
    //end::solution[]

    public static void main( String[] args ) {
        int[] numbers1 = { 1, 44, 2, 4, 43 };
        System.out.println( Arrays.toString( fourLast( numbers1 ) ) );
        System.out.println( Arrays.toString( fourLast( 4, 4, 44, 1234 ) ) );

        System.out.println();
        System.out.println(String.valueOf( 4 ).contains( "4" ));
        System.out.println(numbers1[ 3 ] == 4);
    }*/
