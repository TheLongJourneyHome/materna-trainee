package org.example.javaxercise.chap2;

import java.util.Scanner;

// while-loop
public class SmallestLargestDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long input;
        int max = 0;
        int min;

        System.out.println("Enter number: ");
        input = Math.abs(sc.nextLong());
        min = input == 0 ? 0 : 9;

        // if input = 0 -> max 0 and min 0, not max 0 and min 9
        while (input > 0) {
            max = Math.max(max, (int) (input % 10));
            min = Math.min(min, (int) (input % 10));
            input /= 10;
        }
        // for-loop works as well
/*        for ( long value = Math.abs( n ); value != 0; value /= 10 ) {
            long lastDigit = value % 10;
            largest  = Math.max( lastDigit, largest );
            smallest = Math.min( lastDigit, smallest );
        }*/

        System.out.printf("max: %d, min: %d %n", max, min);
    }
}
