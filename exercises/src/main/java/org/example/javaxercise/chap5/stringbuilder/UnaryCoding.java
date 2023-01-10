package org.example.javaxercise.chap5.stringbuilder;

import java.util.Arrays;

// strinbuilder
// insert
// append
// encode & decode
// delete
// indexOf
// Array
public class UnaryCoding {
    public static void main(String[] args) {
//        System.out.println(unaryCode(6)); // 1111110, encoding sub method
        encode(0, 1, 2, 3, 0, 1); // → "0101101110010"
        encode(0, 0, 0, 0); // → "0000"
        encode(); // → ""
        System.out.println("Hello World!");
//        System.out.println(decodeUnary("1111110")); decoding sub method

        System.out.println(Arrays.toString(decode("0101101110010"))); // → [0, 1, 2, 3, 0, 1]
    }

    public static String encode(int... values) {
        StringBuilder result = new StringBuilder();
        for (int value : values) {
            result.append(unaryCode(value));
        }
        System.out.println(result);
        return result.toString();
    }

    public static String unaryCode(int number) {
        StringBuilder result = new StringBuilder("0");

        for (int i = 0; i < number; i++) {
            result.insert(0, 1);
        }

        return result.toString();
    }


    public static int[] decode(String unaryCode) {
        StringBuilder wholeString = new StringBuilder(unaryCode);
        int index = unaryCode.indexOf("0");
        // In Java, it is not possible to create an array without specifying its size. The size of an array must be specified when it is declared, and it cannot be changed later.
        int[] decodedArray = new int[arraySize(unaryCode)]; // array size as big as number of 0 in the string
        System.out.println("Array length: " + decodedArray.length);

        // loop through x = array size
        for (int i = 0; i < decodedArray.length; i++) {
//            System.out.println(wholeString);
            String currentString = wholeString.substring(0, index + 1);
//            System.out.println(currentString);
            wholeString.delete(0, index + 1); // remaining index
//            System.out.println(wholeString);
            decodedArray[i] = decodeUnary(currentString);

            index = wholeString.indexOf("0"); // reassign index
        }

        System.out.print(unaryCode + " -> ");
        return decodedArray;
    }

    public static int decodeUnary(String unaryCode) {
        int counter = 0;
        for (int i = 0; i < unaryCode.length(); i++) {
            counter = Character.getNumericValue(unaryCode.charAt(i)) == 1 ? counter + 1 : counter;
        }
        return counter;
    }

    public static int arraySize(String unaryCode) {
        int counter = 0;
        for (int i = 0; i < unaryCode.length(); i++) {
            counter = Character.getNumericValue(unaryCode.charAt(i)) == 0 ? counter + 1 : counter;
        }
        return counter;
    }

}


// solution
/*
public class UnaryCoding {

    //tag::solution-a[]
    private static int ensurePositive( int value ) {
        if ( value < 0 )
            throw new IllegalArgumentException(
                    "value is negative, but must be positive" );
        return value;
    }

    static String encode( int... values ) {
        StringBuilder codes = new StringBuilder( values.length );
        for ( int value : values )
            codes.append( "1".repeat( ensurePositive( value ) ) ).append( '0' );
        return codes.toString();
    }
    //end::solution-a[]

    //tag::solution-b[]
    static int[] decode( String string ) {
        if ( string.isEmpty() )
            return new int[0];

        if ( ! string.endsWith( "0" ) )
            throw new IllegalArgumentException(
                    "string must end with 0 but did end with "
                            + string.charAt( string.length() - 1 ) );

        int arrayLength = 0;

        for ( int i = 0; i < string.length(); i++ ) {
            if ( string.charAt( i ) == '0' )
                arrayLength++;
            else if ( string.charAt( i ) != '1' )
                throw new IllegalArgumentException(
                        "string can only contain 0 or 1 but found " + string.charAt( i ) );
        }

        int[] result = new int[ arrayLength ];
        int resultIndex = 0;

        int count = 0;
        for ( int i = 0; i < string.length(); i++ ) {
            if ( string.charAt( i ) == '1' )
                count++;
            else {
                result[ resultIndex++ ] = count;
                count = 0;
            }
        }

        return result;
    }
    //end::solution-b[]

    private static String toString( byte[] bytes ) {
        StringBuilder sb = new StringBuilder( bytes.length * 9 );
        for ( byte b : bytes )
            sb.append( Integer.toBinaryString( (b & 0xFF) + 0x100 ).substring( 1 ) )
                    .append( ' ' );
        return sb.toString();
    }

    private static byte[] getBytes( String s ) {
        ByteBuffer byteBuffer = ByteBuffer.allocate( s.length() / 8 + 1 );
        for ( int i = 0; i < s.length(); i += 8 ) {
            int b = s.length() - i;
            String eightBits = s.substring( i, i + ((8 <= b) ? 8 : b) );
            byteBuffer.put( (byte) Integer.parseUnsignedInt( eightBits, 2 ) );
        }
        return byteBuffer.array();
    }

    public static void main( String[] args ) {
        String unaryCode = encode( 0, 1, 2, 3, 0, 1 );
        System.out.println( unaryCode );
        System.out.println( encode( 0, 0, 0, 0 ) );
        System.out.println( Arrays.toString( decode( "0101101110010" ) ) );
        // System.out.println( Arrays.toString( decode( "1" ) ) );

        // String s = "0101010101010101000100101011110000011111000001111010100010001001010";
        byte[] array = getBytes( unaryCode );
        System.out.println( toString( array ) );
    }
}*/
