package org.example.javexercise.chap4;

import java.util.Arrays;

// Arrays
// TO-DO chapter 4 optional 1.2.2 Draw mountain
// check if next number is new max /, even -, lower than current max \
// even - -> if next one is even again, else lower or higher
public class DrawMountain {
    public static void main(String[] args) {
//        int[] test = {1, 7, 5, 4, 3, 3, 2, 8};
        int[] test = {0, 1, 1, 2, 2, 3, 3, 3, 4, 5, 4, 3, 2, 2, 1, 0};
        printMountain(test);
    }

    public static void printMountain(int[] altitudes) {
        int[] sortedAltitudes = Arrays.copyOf(altitudes, altitudes.length); // copy array and sort it
        Arrays.sort(sortedAltitudes);

        System.out.println(Arrays.toString(sortedAltitudes));
        System.out.println(Arrays.toString(altitudes));
        System.out.println();

        int maxHeight = sortedAltitudes[sortedAltitudes.length-1]; // get the max height of the mountain
//        System.out.println(maxHeight);

        for (int i = 0; i <= maxHeight; i++) {
            System.out.print(maxHeight-i);
//            System.out.print(emptySpaceBetwween(maxHeight - i, altitudes)); // max height, from top to down (max value)

//            boolean reachedTop = altitudes[i] == maxHeight;
            int maxHeightPosition = returnMaxHeightPosition(altitudes, maxHeight);
            System.out.print(emptySpaceBetwweenOptional(maxHeight, maxHeight - i, altitudes, maxHeightPosition)); // max height, from top to down (max value)
            System.out.println();
        }
    }

    // create the mountain string
    public static String emptySpaceBetwween(int untilValue, int[] altitudes) {
        String emptySpace = "";
        for (int i = 0; i < altitudes.length; i++) {
            if (untilValue != altitudes[i]) {
                emptySpace += " ";
            } else {
                emptySpace += "*";
            }
        }
        return emptySpace;
    }

    // Optional
    // /-\ instead of *
    // TO-DO: really messy with extra method to, can be improved
    public static String emptySpaceBetwweenOptional(int maxHeight, int untilValue, int[] altitudes, int maxHeightPosition) {
        String emptySpace = "";
//        boolean reachedTop = false; // flag does not work here
        for (int i = 0; i < altitudes.length; i++) {
            if (untilValue != altitudes[i]) {
                emptySpace += " ";
            } else {
                if (untilValue == maxHeight) {
                    emptySpace += "^";
//                    reachedTop = true;
                } else if (i+1 < altitudes.length && altitudes[i+1] == untilValue) { // when there will be another one with same height
                        emptySpace += "-";
                } else {
                    // check next position for: / - \
                    if (i+1 > maxHeightPosition) {
                        emptySpace += "\\";
                    } else {
                        emptySpace += "/";
                    }
//                    emptySpace += "*";
                }
            }
        }
        return emptySpace;
    }
    public static int returnMaxHeightPosition(int[] altitude, int maxHeight) {
        int counter = 0;
        for (int position : altitude) {
            counter++;
            if (position == maxHeight) {
                return counter;
            }
        }
        return 0;
    }
}



// other solution
/*
//tag::solution[]
private static String mountainChar() { return "*"; }

    public static void printMountain( int[] altitudes ) {

        int maxAltitude = altitudes[ 0 ];

        for ( int currentAltitude : altitudes )
            if ( currentAltitude > maxAltitude )
                maxAltitude = currentAltitude;

        // include height 0, so itâ€™s >= 0
        for ( int height = maxAltitude; height >= 0; height-- ) {
            System.out.print( height + " " );
            for ( int altitude : altitudes )
                System.out.print( altitude == height ? mountainChar() : ' ' );
            System.out.println();
        }
    }
    //end::solution[]

    public static void main( String[] args ) {
        int[] mountain = { 0, 1, 1, 2, 2, 3, 3, 3, 4, 5, 4, 3, 2, 2, 1, 0 };
        printMountain( mountain );
    }*/
