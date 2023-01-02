package org.example.javexercise.chap5.stringbuilder;

// stringbuilder
// insert
// replace
// delete
// append

//StringBuilder object to string
/*StringBuilder sb = new StringBuilder("Hello, World!");
        String str = sb.toString();*/
/*StringBuilder sb = new StringBuilder("Hello, World!");
        String str = new String(sb);*/
public class StringFiller {
    public static void main(String[] args) {
        mix("We’re out of rum!", "-"); // → "W-e-'-r-e- -o-u-t- -o-f- -r-u-m-!"

        mix("Blimey", "👻"); // → "B👻l👻i👻m👻e👻y"

        mix("HI", "♥"); // → "H♥I"

        mix("♥", "!!"); // → "♥"

        mix("", "👻"); // → ""
    }

    public static String mix(String string, String inserts) {
        if ( string == null || string.isEmpty() )
            return "";

        if ( inserts == null || inserts.isEmpty() )
            return string;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {

            // solution is better and shorter!!
            if (i < string.length()-1) { // don't fill when the current index is the last index
                sb.append(string.charAt(i));
                sb.append(inserts);
            } else {
                sb.append(string.charAt(i));
            }
        }

        System.out.println(sb.toString()); // toString() not needed here, because print already converts it to a string
        return sb.toString();
    }
}

// solution
/*
public class StringFiller {

    //tag::solution[]
    private static String mix( String string, String fill ) {

        if ( string == null || string.isEmpty() )
            return "";

        if ( fill == null || fill.isEmpty() )
            return string;

        StringBuilder result = new StringBuilder();

        for ( int i = 0; i < string.length() - 1; i++ ) {
            char c = string.charAt( i );
            result.append( c ).append( fill );
        }

        result.append( string.charAt( string.length() - 1 ) );

        return result.toString();
    }
    //end::solution[]

    public static void main( String[] args ) {
        System.out.println( mix( "We're out of rum!", "-" ) );
        System.out.println( mix( "Blimey", "\uD83D\uDC7B" ) );
        System.out.println( mix( "HI", "â™¥" ) );
        System.out.println( mix( "â™¥", "!!" ) );
        System.out.println( mix( "", "!!" ) );
    }
}*/
