package org.example.javaxercise.chap2;

import java.util.Scanner;

// nested for-loops
public class XmasTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int width;

        System.out.println("Enter christmas tree max width: ");
        width = sc.nextInt();

        // output for 7 and 8 are the same
        // 1 - 3 - 5 - 7 - NO -> for 7
        // 1 - 3 - 5 - 7 - "9" - NO -> for 8
        for (int i = 1; i <= width; i+=2) {
            String xmasTreeRow = "";
            for (int space = 1; space <= (width-i)/2; space++) {
                xmasTreeRow += " ";
            }

            // can there be more than 1 'o' per row? if yes, then call Math.random() inside the for loop
            int rng = (int)(Math.random() * (i+1) + 1); // random number in the range from 1 to current width (i+1), because random is exclusive for max
            for (int xmasTree = 2; xmasTree <= i+1; xmasTree++) {
                xmasTreeRow += (xmasTree != rng) ? "*" : "o";
            }

            System.out.println(xmasTreeRow);
        }
    }

    // other solution
/*    public static void main( String[] args ) {
        //tag::solution[]
        int width = 7;

        for ( int stars = 1, indentation = (width - 1) / 2;
              stars <= width;
              stars += 2, indentation-- ) {

            for ( int i = 0; i < indentation; i++ )
                System.out.print( ' ' );

            for ( int col = 0; col < stars; col++ )
                System.out.print( Math.random() < 0.9 ? '*' : 'o' );

            System.out.println();
        }
        //end::solution[]
    }*/
}
