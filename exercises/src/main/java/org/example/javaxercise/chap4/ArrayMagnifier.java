package org.example.javaxercise.chap4;

import java.util.Arrays;

// Arrays
// multidimensional arrays
// [][] or more
public class ArrayMagnifier {
    public static void main(String[] args) {
        int zoomFactor = 2;
        int[][] treasureMap = {{1, 2, 3}, {4, 5, 6}};
//        int[][] treasureMap = {{1, 2, 3}, {4, 5, 6},{8,8,9,9,10}}; // [[1, 1, 2, 2, 3, 3], [1, 1, 2, 2, 3, 3], [4, 4, 5, 5, 6, 6], [4, 4, 5, 5, 6, 6], [8, 8, 8, 8, 9, 9, 9, 9, 10, 10], [8, 8, 8, 8, 9, 9, 9, 9, 10, 10]]
        int[][] magnifiedTreasureMap = magnify(treasureMap, zoomFactor);
        int[][] moreZoomeTreasureMap = magnify(magnifiedTreasureMap, 4);

//        System.out.println(Arrays.toString(treasureMap));
        System.out.println(Arrays.deepToString(treasureMap));
        System.out.println();
        System.out.println(Arrays.deepToString(magnifiedTreasureMap));
        System.out.println(Arrays.deepToString(moreZoomeTreasureMap));
    }

    public static int[][] magnify(int[][] arrays, int factor) {

        final int FACTOR = factor;
        int[][] magnifiedMap = new int[arrays.length * FACTOR][];

        for (int outerArray = 0; outerArray < magnifiedMap.length; outerArray ++) {
//            System.out.println(arrays[outerArray/FACTOR].length);
            for (int i = 0; i < FACTOR; i += FACTOR) {

                    int[] row = new int[arrays[outerArray/FACTOR].length * FACTOR];
                    for (int innerArray = 0; innerArray < row.length; innerArray += FACTOR) {
        /*            row[j] = array[j];
                    row[j+1] = array[j];*/
                        for (int k = 0; k < FACTOR; k ++) {
                            row[innerArray + k] = arrays[outerArray/FACTOR][innerArray/FACTOR]; // need to divide with FACTOR, else it will be out of bounds
                        }
                    }
                    // add current row to current outer array position
                    magnifiedMap[outerArray+i] = row;
            }
        }

        return magnifiedMap;
    }
}

// other solution
/*//tag::solution[]
public static int[][] magnify( int[][] array, int factor ) {
    int width = array[ 0 ].length;
    int height = array.length;
    int[][] result = new int[ height * factor ][ width * factor ];

    for ( int row = 0; row < result.length; row++ ) {
        int[] cols = result[ row ];
        for ( int col = 0; col < cols.length; col++ )
            cols[ col ] = array[ row / factor ][ col / factor ];
    }
    return result;
}

    private static void printValues( int[][] array ) {
        for ( int[] rows : array ) {
            for ( int col = 0; col < rows.length; col++ )
                System.out.printf( "%03d%s",
                        rows[ col ], col == rows.length - 1 ? "" : ", " );
            System.out.println();
        }
    }

    private static void fillWithRandomValues( int[][] array ) {
        for ( int row = 0; row < array.length; row++ ) {
            int[] cols = array[ row ];
            for ( int col = 0; col < cols.length; col++ ) {
                array[ row ][ col ] = ThreadLocalRandom.current().nextInt( 256 );
            }
        }
    }

    public static void main( String[] args ) {
        int[][] testArray = new int[ 2 ][ 5 ];
        fillWithRandomValues( testArray );
        printValues( testArray );
        int[][] result = magnify( testArray, 2 );
        printValues( result );
    }
//end::solution[]*/



// messy code
/*public static int[][] magnify(int[][] arrays, int factor) {

    final int FACTOR = factor;
    int[][] magnifiedMap = new int[arrays.length * FACTOR][];

    for (int h = 0; h < magnifiedMap.length; h ++) {
        System.out.println(arrays[h/2].length);

        for (int i = 0; i < FACTOR; i += FACTOR) { // next arrays with different row at position * FACTOR, in this case arrays[2] & [3], [0] and [1] have the same values

//                for (int[] array : arrays) {

            // array at the arrays position h
            int[] row = new int[arrays[h/FACTOR].length * FACTOR];
//                    for (int j = 0; j < arrays[h/FACTOR].length; j += FACTOR) { // from position until factor jump, the value stays the same
            for (int j = 0; j < row.length; j += FACTOR) { // from position until factor jump, the value stays the same

//            row[j] = array[j]; // make this variable as well
//                    row[j+1] = array[j];

                for (int k = 0; k < FACTOR; k ++) {
                    row[j + k] = arrays[h/FACTOR][j/FACTOR];
                }
            }
            // magnifiedMap[0], magnifiedMap[1] ... -> arrays.length * FACTOR -1
            magnifiedMap[h+i] = row;
//                }
        }


    }

    return magnifiedMap;*/

