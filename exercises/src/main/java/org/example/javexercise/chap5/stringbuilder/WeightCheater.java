package org.example.javexercise.chap5.stringbuilder;

// stringbuilder
// replace
public class WeightCheater {
    public static void main(String[] args) {
        cheatedWeight(0); // → 0

        cheatedWeight(1234); // → 1234

        cheatedWeight(4321); // → 1324

        cheatedWeight(100); // → 100

        cheatedWeight(987654321); // → 187654329
    }


    public static int cheatedWeight(int weight) {
        if (weight == 0) {
            return 0;
        }
        String numbers = String.valueOf(weight);
        StringBuilder result = new StringBuilder(numbers);
        int indexSmallest = -1;
        int smallestValue = 9;

        for (int i = 0; i < numbers.length(); i++) {
            // ignore 0
            if (Character.getNumericValue(numbers.charAt(i)) > 0) {
//                biggestValue = Math.max(0, Character.getNumericValue(numbers.charAt(i)));
                // get the smallest value and the first id where it is
                if (smallestValue > Character.getNumericValue(numbers.charAt(i)) ) {
                    smallestValue = Character.getNumericValue(numbers.charAt(i));
                    indexSmallest = numbers.indexOf(String.valueOf(numbers.charAt(i)));
                }
            }
        }

        // only swap when the first value isn't already the smallest value!
        if (Character.getNumericValue(numbers.charAt(0)) != smallestValue) {
            result.replace(0, 1, String.valueOf(numbers.charAt(indexSmallest)) ); // replace first index with value of the smallest number
            result.replace(indexSmallest, indexSmallest + 1, String.valueOf(numbers.charAt(0)) ); // swap this as well, first position (index 0) value to the index of the smallest
        }


        System.out.println(smallestValue);
        System.out.println(indexSmallest);
        System.out.println();

        System.out.println(Integer.parseInt(result.toString()));
        System.out.println();


        return Integer.parseInt(result.toString());
    }
}


// solution
/*
public class WeightCheater {

    //tag::solution[]
    private static void swap( StringBuilder string, int i, int j ) {
        if ( i == j ) return;
        char temp = string.charAt( i );
        string.setCharAt( i, string.charAt( j ) );
        string.setCharAt( j, temp );
    }

    public static int cheatedWeight( int weight ) {
        StringBuilder weightString = new StringBuilder().append( weight );
        char smallestDigit = weightString.charAt( 0 );
        int  smallestDigitIndex = 0;
        for ( int i = 1; i < weightString.length(); i++ ) {
            char c = weightString.charAt( i );
            if ( c != '0' && c < smallestDigit ) {
                smallestDigit = c;
                smallestDigitIndex = i;
            }
        }

        swap( weightString, smallestDigitIndex, 0 );

        return Integer.parseInt( weightString, 0, weightString.length(), 10 );
    }
    //end::solution[]

    public static void main( String[] args ) {
        System.out.println( cheatedWeight( 0 ) );
        System.out.println( cheatedWeight( 1 ) );
        System.out.println( cheatedWeight( 9 ) );
        System.out.println( cheatedWeight( 1234 ) );
        System.out.println( cheatedWeight( 4321 ) );
        System.out.println( cheatedWeight( 100 ) );
        System.out.println( cheatedWeight( 987654321 ) );
    }
}*/
