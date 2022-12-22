package org.example.javexercise.chap4;

import java.util.Arrays;
import java.util.Objects;

// Arrays
// in place, don't create a new array, just change the current array
// copyOfRange
public class ArrayReverser {
    public static void main(String[] args) {
        double[] array1 = createDoubleArray(9);
        reverse(array1);
        System.out.println(Arrays.toString(array1));
        System.out.println();

        double[] array2 = createDoubleArray(12);
        reverse(array2);
        System.out.println(Arrays.toString(array2));
        System.out.println();

        double[] array3 = {1.0, 6.4, 8.1, 24.24, 3.33};
        System.out.println(Arrays.toString(array3));
        reverse(array3);
        System.out.println(Arrays.toString(array3));
        System.out.println();
    }

    public static void reverse( double[] numbers) {
        Objects.requireNonNull(numbers);
        /*for (double number : numbers) { // null check for every number
            Objects.requireNonNull(number);
        }*/

        double[] tempNumbers = Arrays.copyOfRange(numbers,0,numbers.length);

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = tempNumbers[tempNumbers.length-1-i]; // reverse in place
        }
//        System.out.println(Arrays.toString(tempNumbers));
    }

    public static double[] createDoubleArray(int length) {
        double[] newDoubleArray = new double[length];
        for (int i = 0; i < newDoubleArray.length; i++) {
            newDoubleArray[i] = 1.0 * i;
        }
        System.out.println(Arrays.toString(newDoubleArray));
        return newDoubleArray;
    }
}

// other solution
/*public static void main( String[] args ) {
    double[] elements = { Math.random() * 10, Math.random() * 10,
            Math.random() * 10, Math.random() * 10 };

    for ( double element : elements )
        System.out.printf( "%f ", element );

    reverse( elements );
    System.out.println();

    for ( double element : elements )
        System.out.printf( "%f ", element );
}

    //tag::solution[]
    public static void reverse( double[] numbers ) {
        final int middle = numbers.length / 2;

        for ( int left = 0; left < middle; left++ ) {
            int right = numbers.length - left - 1;
            swap( numbers, left, right );
        }
    }

    private static void swap( double[] numbers, int i, int j ) {
        double swap  = numbers[ i ];
        numbers[ i ] = numbers[ j ];
        numbers[ j ] = swap;
    }
//end::solution[]*/


// testing Arrays.copyOfRange
/*
public static void main(String[] args) {
    double[] array = new double[10];
    for (int i = 0; i < array.length; i++) {
        array[i] = 1.0 * i;
    }
    System.out.println(Arrays.toString(array));

    reverse(array);
}

    public static void reverse( double[] numbers) {
        Objects.requireNonNull(numbers);
        for (double number : numbers) { // null check for every number
            Objects.requireNonNull(number);
        }

        double[] tempNumbersBegin = Arrays.copyOfRange(numbers,0,numbers.length/2);
        double[] tempNumbersEnd = Arrays.copyOfRange(numbers, numbers.length/2,numbers.length); // if uneven num-length+1

        System.out.println(Arrays.toString(tempNumbersBegin));
        System.out.println(Arrays.toString(tempNumbersEnd));
    }*/
