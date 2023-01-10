package org.example.javaxercise.chap5.stringbuilder;

// stringbuilder
// delete
// append
public class RemoveVowel {
    public static void main(String[] args) {
        System.out.println(removeVowels("Hallo Javanesen")); // -> Hll Jvnsn
        System.out.println(removeVowels("BE NICE")); // -> B NC
        System.out.println("\n2nd Version");

        System.out.println(removeVowels2nd("Hallo Javanesen")); // -> Hll Jvnsn
        System.out.println(removeVowels2nd("BE NICE")); // -> B NC
    }

    // delete version
    public static String removeVowels(String string) {

        StringBuilder result = new StringBuilder(string);
        System.out.print(result + "  -> ");
        int index;
        int vowelsFound = 0; // else out of bounds error because result string is shorter with each vowel found than string

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'a' || string.charAt(i) == 'e' || string.charAt(i) == 'i' || string.charAt(i) == 'o' || string.charAt(i) == 'u' ||
                    string.charAt(i) == 'A' || string.charAt(i) == 'E' || string.charAt(i) == 'I' || string.charAt(i) == 'O' || string.charAt(i) == 'U')
            {
                index = i;
                result.deleteCharAt(index - vowelsFound);
                vowelsFound++;
            }
        }

        return result.toString();
    }

    // append version
    public static String removeVowels2nd(String string) {

        StringBuilder result = new StringBuilder();
        System.out.print(string + "  -> ");


        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != 'a' && string.charAt(i) != 'e' && string.charAt(i) != 'i' && string.charAt(i) != 'o' && string.charAt(i) != 'u' &&
                    string.charAt(i) != 'A' && string.charAt(i) != 'E' && string.charAt(i) != 'I' && string.charAt(i) != 'O' && string.charAt(i) != 'U')
            {
                result.append(string.charAt(i));
            }
        }

        return result.toString();
    }
}


// solutions
/*
public class RemoveVowel {

    //tag::solution-1[]
    public static String removeVowels1( String string ) {
        string = string.replace( "a", "" ).replace( "A", "" );
        string = string.replace( "Ã¤", "" ).replace( "Ã„", "" );
        string = string.replace( "e", "" ).replace( "E", "" );
        string = string.replace( "o", "" ).replace( "O", "" );
        string = string.replace( "Ã¶", "" ).replace( "Ã–", "" );
        string = string.replace( "u", "" ).replace( "U", "" );
        string = string.replace( "Ã¼", "" ).replace( "Ãœ", "" );
        string = string.replace( "i", "" ).replace( "I", "" );
        string = string.replace( "y", "" ).replace( "Y", "" );
        return string;
    }
    //end::solution-1[]

    //tag::solution-2[]
    public static String removeVowels2( String string ) {
        char[] chars = new char[string.length()];
        int len = 0;

        for ( int i = 0; i < string.length(); i++ ) {
            char c = string.charAt( i );

            if ( "aeiouÃ¶Ã¤Ã¼yAEIOUÃ„Ã–ÃœY".indexOf( c ) < 0 )
                chars[ len++ ] = c;
        }

        return new String( chars, 0, len );
    }
    //end::solution-2[]

    //tag::solution-3[]
    public static String removeVowels3( String string ) {
        StringBuilder result = new StringBuilder( string.length() );
        for ( int i = 0; i < string.length(); i++ ) {
            char c = string.charAt( i );
            switch ( c ) {
                case 'a', 'e', 'i', 'o', 'u', 'y', 'Ã¤', 'Ã¶', 'Ã¼' -> { }
                default -> result.append( c );
            }
        }
        return result.toString();
    }
    //end::solution-3[]

    //tag::solution-4[]
    private static boolean isVowel( char c ) {
        return "aeiouyÃ¤Ã¶Ã¼AEIOUYÃ„Ã–Ãœ".indexOf( c ) >= 0;
    }

    public static String removeVowels4( String string ) {
        StringBuilder result = new StringBuilder( string.length() );
        for ( int i = 0; i < string.length(); i++ ) {
            char c = string.charAt( i );
            if ( ! isVowel( c ) )
                result.append( c );
        }
        return result.toString();
    }
    //end::solution-4[]

    //tag::solution-5[]
    public static String removeVowels5( String string ) {
        return string.replaceAll( "[aeiouyÃ¤Ã¶Ã¼AEIOUYÃ„Ã–Ãœ]", "" );
    }
    //end::solution-5[]

    //tag::solution-6[]
    public static String removeVowels6( String string ) {
        String result = "";
        String[] tokens = string.split( "[aeiouyÃ¤Ã¶Ã¼AEIOUYÃ„Ã–Ãœ]" );
        for ( String value : tokens )
            result += value;
        return result;
    }
    //end::solution-6[]

    public static void main( String[] args ) {
        System.out.println( removeVowels1( "Hallo Javanesen" ) );
        System.out.println( removeVowels1( "NETT SAGEN" ) );
        System.out.println( removeVowels2( "Hallo Javanesen" ) );
        System.out.println( removeVowels3( "Hallo Javanesen" ) );
        System.out.println( removeVowels4( "Hallo Javanesen" ) );
        System.out.println( removeVowels5( "Hallo Javanesen" ) );
        System.out.println( removeVowels6( "Hallo Javanesen" ) );
    }
}*/
