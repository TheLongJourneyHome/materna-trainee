package org.example.javaxercise.chap4;

// Arrays
// compare array contents
public class SweetsFairSharing {

    public static void main(String[] args) {
        int[] values = { 10, 20, 30, 40, 40, 50 };
        System.out.println("Result is: " + findSplitPoint(values));

        int[] values2 = { 0, 0, 0 };
        System.out.println("Result is: " +  findSplitPoint( values2 ) );
        int[] values3 = { 10, 20, 30, 40, 40, 100 };
        System.out.println("Result is: " +  findSplitPoint( values3 ) );
    }

    // gives the relative difference and it shouldn't be greater than 10%
    // e.g. a has 5 and b has 10
    // -> 50 (max value 50% more than lower value -> but 10% is the limit)
    private static int relativeDifference( int a, int b ) {
        if ( a == b ) return 0;
        int absoluteDifference = Math.abs( a - b );
        return (int) (100. * absoluteDifference / Math.max( a, b ));
    }

    public static int findSplitPoint(int[] sweets) {

        int firstHalf = 0;
        int secondHalf = 0;
        int result = -1;

        for ( int i = 0; i < sweets.length; i++ ) {
            firstHalf += sweets[i];

            for (int j = i+1; j < sweets.length; j++ ) { // add all the remaining ints of the arrays to the second half
                secondHalf += sweets[j]; // i+1, so we won't add the values i already added before
            }
            System.out.println(firstHalf); // comments for testing purposes and debugging if needed
            System.out.println(secondHalf);
            System.out.println(relativeDifference(firstHalf, secondHalf));
            System.out.println();
            if ( relativeDifference(firstHalf, secondHalf) <= 10 ) {
                result = i + 1; // position where it's fair, +1 so we can say 4th position -> sweets[3] = 4th position
                return result;
            }
            secondHalf = 0; // reset it again, cuz it will be different in the next loop
            System.out.println(secondHalf);
            System.out.println();
        }

        return result;
    }


}


// other solution
/*
//tag::solution[]
public static int findSplitPoint( int[] values ) {

    if ( values.length < 2 )
        return -1;

    int sumLeft = values[ 0 ];

    int sumRight = 0;
    for ( int i = 1; i < values.length; i++ )
        sumRight += values[ i ];

    for ( int splitIndex = 1; splitIndex < values.length; splitIndex++ ) {
        int relativeDifference = relativeDifference( sumLeft, sumRight );

        Logger.getLogger( "MuggingFairly" )
                .info( "splitIndex=" + splitIndex
                        + ", sum left/right=" + sumLeft + "/" + sumRight
                        + ", difference=" + relativeDifference );

        if ( relativeDifference <= 10 )
            return splitIndex;

        int element = values[ splitIndex ];
        sumLeft  += element;
        sumRight -= element;
    }
    return -1;
}

    // https://en.wikipedia.org/wiki/Relative_change_and_difference
    private static int relativeDifference( int a, int b ) {
        if ( a == b ) return 0;
        int absoluteDifference = Math.abs( a - b );
        return (int) (100. * absoluteDifference / Math.max( a, b ));
    }
    //end::solution[]

    public static void main( String[] args ) {
        int[] values1 = { 10, 20, 30, 40, 40, 50 };
        System.out.println( findSplitPoint( values1 ) );
        int[] values2 = { 0, 0, 0 };
        System.out.println( findSplitPoint( values2 ) );
        int[] values3 = { 10, 20, 30, 40, 40, 100 };
        System.out.println( findSplitPoint( values3 ) );
    }*/
