package org.example.javexercise.chap4;

// Arrays
// label break flag in solution
    // break label corresponds to a goto to the end of theblock
    // exit nested loops with label break, not nested loops just with break
// check solutions how to handle 2 dimensional checks"
public class CheckSudoku3x3 {

    public static void main(String[] args) {

        int[][] array1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] array2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 8}};

        int[][] array3 = {{2, 2, 3}, {4, 3, 8}, {4, 8, 8}};

        checkSudoku(array1);
        checkSudoku(array2);
        checkSudoku(array3);
    }

    public static void checkSudoku(int[][] miniSudoku) {

        int one = 0, two = 0, three = 0, four = 0, five = 0, six = 0, seven = 0, eight = 0, nine = 0;
        for (int[] row : miniSudoku) { // 3 rows

            for (int value : row) { // 3 values
                switch (value) {
                    case 1 -> one++;
                    case 2 -> two++;
                    case 3 -> three++;
                    case 4 -> four++;
                    case 5 -> five++;
                    case 6 -> six++;
                    case 7 -> seven++;
                    case 8 -> eight++;
                    default -> nine++;
                }
            }

        }
        if (one == 0 || two == 0 || three == 0 || four == 0 || five == 0 || six == 0 || seven == 0 || eight == 0 || nine == 0) {
            System.out.printf("Missing %s%s%s%s%s%s%s%s%s%n",
                    one == 0 ? "1 " : "",
                    two == 0 ? "2 " : "",
                    three == 0 ? "3 " : "",
                    four == 0 ? "4 " : "",
                    five == 0 ? "5 " : "",
                    six == 0 ? "6 " : "",
                    seven == 0 ? "7 " : "",
                    eight == 0 ? "8 " : "",
                    nine == 0 ? "9 " : "");
        } else {
            System.out.println("The input is valid");
        }
        System.out.println();
    }
}

// other solution
// print missing in new line
/*
public static void main( String[] args ) {
    int[][] array = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 8 }
    };

    //tag::solution1[]
    final int DIMENSION = 3;
    for ( int i = 1; i <= DIMENSION * DIMENSION; i++ ) {
        boolean found = false;
        matrixLoop:
        for ( int row = 0; row < DIMENSION; row++ ) {
            for ( int column = 0; column < DIMENSION; column++ ) {
                int element = array[ row ][ column ];
                if ( element == i ) {
                    found = true;
                    break matrixLoop;
                }
            }
        }
        if ( ! found )
            System.out.printf( "Missing %d%n", i );
    }
    //end::solution1[]

    //tag::solution2[]
    boolean[] numberExisted = new boolean[ DIMENSION * DIMENSION ];

    for ( int row = 0; row < DIMENSION; row++ ) {
        for ( int column = 0; column < DIMENSION; column++ ) {
            int element = array[ row ][ column ];
            if ( element >= 1 && element <= 9 )
                numberExisted[ element - 1 ] = true;
        }
    }

    for ( int i = 0; i < numberExisted.length; i++ ) {
        boolean found = numberExisted[ i ];
        if ( ! found )
            System.out.printf( "Missing %d%n", i + 1 );
    }
    //end::solution2[]
}
*/
