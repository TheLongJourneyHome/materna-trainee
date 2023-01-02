package org.example.javexercise.chap5;

import java.util.Scanner;

// Zeichenketten
// diamond
// spacing
public class DiamondPrinter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int range;

        System.out.println("Please enter diamond size between 1-51: ");
        range = sc.nextInt();

        printDiamond(range);
    }

    public static void printDiamond(int range) {
        // A-Z, 26
        // (26*2)-1 = 51
        // ABCDEFGHIJKLMNOPQRSTUVWXYZ
        // diamond range = uneven -> (range+1)/2
        // (7+1)/2 = 4, (8+1)/2 = 4.5 -> 4
        if ( range < 1 || range > 51 )
            throw new IllegalArgumentException( "Range: " + range + ", mustn't be smaller than 1 or greater than 26" );

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int y = 0; y < range; y++) {
            String result = "";
            int z;

            // past the middle, lower the string length again to form a diamond shape
            if (y < range / 2) {
                z = y;
            } else {
                z = range - (y + 1);
            }

            // amount of spaces to form the diamond shape
            // e.g. index[2] -> 3rd y-position -> x length (z*2+1) = 5 -> 7-5 = 2 -> 2 / 2 -> 1 => 1 space (because we print just from 1 side the spaces)
            int spaceLeft = (range - ((z * 2) + 1)) / 2;
            for (int space = 0; space < spaceLeft; space++) {
                result += " ";
            }

            for (int x = 0, currentRange = (z*2)+1; x < currentRange; x++) {
                // 7: ABCD + CBA
                // reverse print
                if (x < (currentRange + 1) / 2) {
                    result += alphabet.charAt(x);
                } else {
                    result += alphabet.charAt(currentRange - (x + 1));
                }
            }
            System.out.println(result);

        }

        //  size will be uneven and the next number from the last uneven input will have the same size (e.g. 7 = 8):
/*        for (int y = 0; y < range; y++) {
            String result = "";
            for (int x = 0; x < range; x++) {
                // 7: ABCD + CBA
                if (x < (range + 1) / 2) {
                    result += alphabet.charAt(x);
                } else {
                    result += alphabet.charAt(range - (x + 1));
                }
            }
            System.out.println(result);

        }*/
    }
}

// solution
/*//tag::solution[]
private static void printDiamondCore( char character, char stopCharacter ) {
    if ( character == stopCharacter ) {
        System.out.print( character );
        return;
    }
    System.out.print( character );
    printDiamondCore( (char) (character + 1), stopCharacter );
    System.out.print( character );
}

    public static void printDiamond( int diameter ) {
        if ( diameter < 1 )
            return;

        diameter = (diameter <= 2 * 26 - 1) ? diameter : 2 * 26 - 1;

        int radius = diameter / 2;
        for ( int indentation = radius; indentation >= -radius; indentation-- ) {
            int absIndentation = Math.abs( indentation );
            System.out.print( " ".repeat( absIndentation ) );
            printDiamondCore( 'A', (char) ('A' + radius - absIndentation) );
            System.out.println();
        }
    }
    //end::solution[]

    public static void main( String[] args ) {
        printDiamond( 7 );
        printDiamond( 1 );
        printDiamond( 0 );
        printDiamond( 200 );
    }*/
