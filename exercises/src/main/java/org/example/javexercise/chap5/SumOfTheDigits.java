package org.example.javexercise.chap5;

// Zeichenketten
// String to int
// Character to int
// Integer
// parseInt
// getNumericValue
// Quersumme -> number -> string -> iterate through string -> get the value of the characters -> add them
// error handling
public class SumOfTheDigits {
    public static void main(String[] args) {
        System.out.println("3");
        digitSum("123A");
        digitSum("10938");
        digitSum(109382);
    }


    // String version is easier to make
    public static int digitSum(String value) {
        // check if the given string only contains digits
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.out.println("The input doesn't only contain digits!");
            return -1;
        }

        int result = 0;

        for (int i = 0; i < value.length(); i++) {
            System.out.print(value.charAt(i));
            result += Character.getNumericValue(value.charAt(i));

            if (i < value.length() - 1) {
                System.out.print(" + ");
            } else {
                System.out.print(" = ");
            }
        }

        System.out.println(result);
        return result;
    }

    // reuse code here
    public static int digitSum(long value) {
        return digitSum("" + value);
        // return digitSum( String.valueOf( value ) ); // -> better
    }
}


// solution
/*//tag::solution[]
static int digitSum( long value ) {
    return digitSum( String.valueOf( value ) );
}

    static int digitSum( String value ) {
        int sum = 0;

        for ( int i = 0; i < value.length(); i++ )
            // sum += value.charAt( i ) - '0';
            sum += Character.getNumericValue( value.charAt( i ) );

        return sum;
    }
    //end::solution[]

    public static void main( String[] args ) {
        System.out.println( digitSum( "12345" ) ); // 15
        System.out.println( digitSum( 12345 ) );   // 15
    }*/
