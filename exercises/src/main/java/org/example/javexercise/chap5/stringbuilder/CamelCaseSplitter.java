package org.example.javexercise.chap5.stringbuilder;

// stringbuilder
// append
// check uppercase
public class CamelCaseSplitter {
    public static void main(String[] args) {
        camelCaseSplitter("List"); // → "List"

        camelCaseSplitter("CiaoCiao"); // → "Ciao Ciao"

        camelCaseSplitter("numberOfElements"); // → "number Of Elements"

        camelCaseSplitter("CiaoCiaoCAPTAIN"); // → "Ciao Ciao CAPTAIN"
    }

    public static String camelCaseSplitter(String string) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            if (i > 0 && i < string.length()-1 && Character.isUpperCase(string.charAt(i))) { // ignore first and last character
                if ( !Character.isUpperCase(string.charAt(i-1)) ) { // when the last character was not uppercase, else not ' ' for the word that is uppercase
                    // can use lowercase check here as well -> see solution
                    result.append(' ');
                }
            }
            result.append(string.charAt(i));
        }
        System.out.println(result.toString());
        return result.toString();
    }
}


// solution
/*
public class CamelCaseSplitter {

    //tag::solution[]
    private static String camelCaseSplitter( String string ) {
        StringBuilder result = new StringBuilder( string );

        for ( int i = 1; i < result.length(); i++ ) {
            char previousChar = result.charAt( i - 1 );
            char currentChar  = result.charAt( i );
            boolean isPreviousCharLowercase = Character.isLowerCase( previousChar );
            boolean isCurrentCharUppercase  = Character.isUpperCase( currentChar );
            if ( isPreviousCharLowercase && isCurrentCharUppercase ) {
                result.insert( i, " " );
                i++;
            }
        }

        return result.toString();
    }
    //end::solution[]

    public static void main( String[] args ) {
        System.out.println( camelCaseSplitter( "List" ) );
        System.out.println( camelCaseSplitter( "CiaoCiao" ) );
        System.out.println( camelCaseSplitter( "numberOfElements" ) );
        System.out.println( camelCaseSplitter( "CiaoCiaoCAPTAIN" ) );
        System.out.println( camelCaseSplitter( "CiaoCiaoCAPTAINCiaoCiao" ) );
        System.out.println( camelCaseSplitter( "1" ) );
        System.out.println( camelCaseSplitter( "" ) );

        // ?<= zero-width positive lookbehind
        // ?=  zero-width positive lookahead

        String regex = "(?<=\\p{javaLowerCase})(?=\\p{javaUpperCase})";
        String s = String.join( " ", "CiaoCiaoCAPTAINCiaoCiao".split( regex ) );
        System.out.println( s );
    }
}*/
