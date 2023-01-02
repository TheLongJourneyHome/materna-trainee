package org.example.javexercise.chap5;

// Zeichenketten
// substring
// equals
// error handling
public class RepeatingStrings {
    public static void main(String[] args) {
        repeatingStrings("🌼🌼🌼"); // liefert "🌼".

        repeatingStrings("🌼🌻" + "🌼🌻" + "🌼🌻"); // liefert "🌼🌻".

        repeatingStrings("Ciao" + "Ciao"); // liefert "Ciao".

        repeatingStrings("Captain CiaoCiaoCaptain CiaoCiao"); // liefert "Captain CiaoCiao".

        repeatingStrings("🌕🌔🌓🌑"); // liefert null

        repeatingStrings("CaptainCiaoCiaoCaptain"); // liefert null

        repeatingStrings("🌼"); // liefert null

        repeatingStrings(""); // liefert null

        repeatingStrings(null); // liefert null
    }

    // given a string
    // check how many times a pattern repeats
    // start to check from the biggest -> half the string length ABCDABCD -> ABCD? -> ABC -> AB -> A => ABCD, ABC and the rest won't repeat right away
    public static String repeatingStrings(String str) {
        try {
            str.length();
        } catch (NullPointerException e) {
            System.out.println("The input is null");
            return null;
        }
        // check all possible patterns that could repeat -> str.length()/2, half the string length, because patterns can't be greater than half of total length
        for (int checkAllPatterns = 1; checkAllPatterns <= str.length() / 2; checkAllPatterns++) {
            String pattern = str.substring(0, checkAllPatterns);
            // increment by current total pattern length
            for (int i = checkAllPatterns; i <= str.length()-checkAllPatterns; i += checkAllPatterns) { // <= important
                String isPattern = str.substring(i, i+checkAllPatterns);
                if (isPattern.equals(pattern)) {
                    System.out.println(pattern);
                    return pattern;
                }
                break; // only want to know if the next pattern is the same, without break we can count the number of repetitions of the pattern in the string, but need to implement count first
            }

        }

        System.out.println("null");
        return null;
    }

}


// solution
/*
public class RepeatingStrings {
    //tag::solutiona[]
    public static String repeatingStrings( String string ) {

        if ( string == null || string.length() < 2 )
            return null;

        // Step 1: generate substrings, of length 1, length x, ...

        for ( int length : lengths( string.length() ) ) {
            String substring = string.substring( 0, length );

            // Step 2: check if repetitions of substring are equals to this text

            String repeatedSubstring = substring;
            while ( repeatedSubstring.length() < string.length() )
                repeatedSubstring += substring;

            if ( repeatedSubstring.equals( string ) )
                return substring;
        }

        return null;
    }
    //end::solutiona[]
    // System.out.printf( "Repeating '%s' leads to '%s'%n", substring, repeatedSubstring );

    //tag::solutionb[]
    static int[] lengths( int length ) {

        int[] dividers    = new int[ length / 2 ];
        int dividersIndex = 0;

        for ( int i = 1; i <= length / 2; i++ )
            if ( length % i == 0 )
                dividers[ dividersIndex++ ] = i;

        return Arrays.copyOf( dividers, dividersIndex );
    }
    //end::solutionb[]

    public static void main( String[] args ) {
        System.out.println( repeatingStrings( "\uD83C\uDF3C\uD83C\uDF3C\uD83C\uDF3C" ) );
        System.out.println( repeatingStrings( "\uD83C\uDF3C\uD83C\uDF3B\uD83C\uDF3C\uD83C\uDF3B\uD83C\uDF3C\uD83C\uDF3B" ) );
        System.out.println( repeatingStrings( "CiaoCiao" ) );
        System.out.println( repeatingStrings( "Captain CiaoCiaoCaptain CiaoCiao" ) );
        System.out.println( repeatingStrings( "ababab" ) );
        System.out.println( repeatingStrings( "* * * * * * " ) );
        System.out.println( repeatingStrings( "\uD83C\uDF15\uD83C\uDF14\uD83C\uDF13\uD83C\uDF11" ) );
        System.out.println( repeatingStrings( "CaptainCiaoCiaoCaptain" ) );
        System.out.println( repeatingStrings( "" ) );
        System.out.println( repeatingStrings( "c" ) );
        System.out.println( repeatingStrings( null ) );
    }
}*/
