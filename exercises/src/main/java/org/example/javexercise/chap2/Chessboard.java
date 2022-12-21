package org.example.javexercise.chap2;

import java.util.Scanner;

// nested for-loops
public class Chessboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int height;
        int width;


        System.out.println("Enter height: ");
        height = sc.nextInt();
        System.out.println("Enter width: ");
        width = sc.nextInt();

        // even starts with _ -> #
        // uneven start with #-> _
        for (int h = 0; h < height; h++) {

            String patternRow = "";

            for (int w = 0 + h; w < width + h; w++) { // add current h to w, so it switches from even and uneven
                patternRow += w % 2 == 0 ? "_" : "#";
            }

            System.out.println(patternRow);

        }
    }

/*    public static void main( String[] args ) {
        //tag::solution[]
        System.out.print( "Checkerboard width: " );
        int width = new java.util.Scanner( System.in ).nextInt();

        System.out.print( "Checkerboard height: " );
        int height = new java.util.Scanner( System.in ).nextInt();

        for ( int y = 0; y < height; y++ ) {
            for ( int x = 0; x < width; x++ )
                System.out.print( (x + y) % 2 == 1 ? '#' : '_' );
            System.out.println();
        }
        //end::solution[]

        System.out.println();

        // Alternative solution with an array for the two characters
        char[] chars = { '_', '#' };
        for ( int y = 0; y < height; y++ ) {
            for ( int x = 0; x < width; x++ )
                System.out.print( chars[ (x + y) % 2 ] );
            System.out.println();
        }
    }*/
}
