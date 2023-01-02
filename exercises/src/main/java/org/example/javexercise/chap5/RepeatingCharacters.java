package org.example.javexercise.chap5;

import java.util.Objects;

// Zeichenketten
public class RepeatingCharacters {
    public static void main(String[] args) {
//        System.out.println(-0);
        System.out.println(isEveryCharacterTwice("eehhrrwwüürrddiiggeerr$$ccaappttaaiinn")); // → 1

        System.out.println(isEveryCharacterTwice("ccapptttaaiinn")); // → -3

        System.out.println(isEveryCharacterTwice("222")); // → 0

//        System.out.println(isEveryCharacterTwice(null)); // → NullPointerException
    }

    public static int isEveryCharacterTwice(String checkString) {
        Objects.requireNonNull(checkString);

        int index = 1;
        boolean allDouble = true;

        if (checkString.length() % 2 != 0) {
            return 0;
        }

        // +2, only check every 2 indexes
        // -1 so we don't check the last index
        for (int i = 0; i < checkString.length()-1; i += 2) {
//            counter = checkString.charAt(i) == checkString.charAt(i + 1) ? counter + 1 : counter;
            allDouble = checkString.charAt(i) == checkString.charAt(i + 1);
            if (!allDouble) {
                index = -(i+1);
                return index;
            }
        }

        return index;
    }
}

// solution
/*//tag::solution[]
private static int isEveryCharacterTwice( String string ) {

    int FAILURE_CODE = 0;
    int SUCCESS_CODE = 1;

    if ( string.length() % 2 != 0 )
        return FAILURE_CODE;

    for ( int i = 0; i < string.length(); i += 2 ) {
        char first  = string.charAt( i );
        char second = string.charAt( i + 1 );
        if ( first != second )
            return -(i + 1);
    }

    return SUCCESS_CODE;
}
    //end::solution[]

    public static void main( String[] args ) {
        System.out.println( isEveryCharacterTwice( "eehhrrwwÃ¼Ã¼rrddiiggeerr$$ccaappttaaiinn" ) );
        System.out.println( isEveryCharacterTwice( "ccapptttaaiinn" ) );
        System.out.println( isEveryCharacterTwice( "222" ) );
    }*/
