package org.example.javexercise.chap5;

import java.util.Arrays;

// Zeichenketten
// split
// replaceAll
// substring
// !!!
public class Decolumnizer {
    public static void main(String[] args) {
        System.out.println(
                "        I’m dishonest, and a to watch out for,\n" +
                "        dishonest man you    because you can\n" +
                "        can always trust to  never predict when\n" +
                "        be dishonest.        they’re going to do\n" +
                "        Honestly, it’s the   something incredibly\n" +
                "        honest ones you want stupid.");

        String longText =
                "I’m dishonest, and a to watch out for,\n" +
                "dishonest man you    because you can\n" +
                "can always trust to  never predict when\n" +
                "be dishonest.        they’re going to do\n" +
                "Honestly, it’s the   something incredibly\n" +
                "honest ones you want stupid.";

        decolumnize(longText);

        System.out.println("test  test test               test   test test bla".replaceAll("\\s+", "   ")); // -> all whitespaces became triple white space
    }

    public static void decolumnize(String string) {
        /*
        I’m dishonest, and a to watch out for,
        dishonest man you    because you can
        can always trust to  never predict when
        be dishonest.        they’re going to do
        Honestly, it’s the   something incredibly
        honest ones you want stupid.
        */
        // 21 length -> next
        // white space too long -> next
        // 2nd part always with \n

        String[] lines = string.split("\n");
        System.out.println(Arrays.toString(lines));

        String firstPart = "";
        String remainingPart = "";
        for (String line : lines) {
            firstPart += line.substring(0, 21) + "\n";
            remainingPart += line.substring(21) + "\n";
//            line.indexOf("  "); // -> once it's more than one space
        }

        System.out.println(firstPart);
        System.out.println(remainingPart);
        System.out.println();

        string = firstPart + remainingPart;
//        string = string.replaceAll("\\s+", " "); // replace all multi or single spaces with one space

        System.out.println(string);
    }
}


// solution
/*
//tag::solution-a[]
private static boolean isSpaceAt( String string, int index ) {
    if ( index >= string.length() )
        return true;
    return string.charAt( index ) == ' ';
}
    //end::solution-a[]

    //tag::solution-b[]
    private final static int COLUMN_NOT_FOUND = -1;

    private static int findColumnIndex( String[] lines ) {
        int length = lines[ 0 ].length();
        for ( String line : lines )
            length = Math.max( length, line.length() );

        mainLoop:
        for ( int column = 1; column < length - 1; column++ ) {
            for ( String line : lines )
                if ( ! isSpaceAt( line, column ) )
                    continue mainLoop;
            return column;
        }

        return COLUMN_NOT_FOUND;
    }
    //end::solution-b[]

    //tag::solution-c[]
    public static void decolumnize( String string ) {
        String[] lines = string.split( "\n" );
        if ( lines.length < 2 ) {
            System.out.println( string );
            return;
        }

        int column = findColumnIndex( lines );

        if ( column == COLUMN_NOT_FOUND ) {
            System.out.println( string );
            return;
        }

        // Left column
        for ( String line : lines ) {
            int a = line.length();
            System.out.println(
                    line.substring( 0, (a <= column) ? a : column ).trim() );
        }

        // Right column
        for ( String line : lines )
            if ( column < line.length() )
                System.out.println( line.substring( column + 1 ).trim() );
            else
                System.out.println();
    }
    //end::solution-c[]

    public static void main( String[] args ) {

        //    System.out.println( isSpaceAt( " b", 0 ) );
        //    System.out.println( isSpaceAt( " b", 1 ) );
        //    System.out.println( isSpaceAt( " b", 2 ) );
        //    System.out.println( isSpaceAt( " b", 3 ) );

        String text;
        text = "Iâ€™m dishonest, and a to watch out for,\n" +
                "dishonest man you    because you can\n" +
                "can always trust to  never predict when\n" +
                "be dishonest.        theyâ€™re going to do\n" +
                "Honestly, itâ€™s the   something incredibly\n" +
                "honest ones you want stupid.";
        System.out.println( text + "\n=> " );
        decolumnize( text );

        text = "Iâ€™m dishonest, and a never predict when\n" +
                "dishonest man you    theyâ€™re going to do\n" +
                "can always trust to  something incredibly\n" +
                "be dishonest.        stupid.\n" +
                "Honestly, itâ€™s the\n" +
                "honest ones you want\n" +
                "to watch out for,\n" +
                "because you can";
        System.out.println( text + "\n=> " );
        decolumnize( text );

        text = "Iâ€™m dishonest, and a\n" +
                "dishonest man you\n" +
                "can always trust to\n" +
                "be dishonest.\n" +
                "\n" +
                "Honestly, itâ€™s the\n" +
                "honest ones you want\n" +
                "to watch out for,\n" +
                "because you can\n" +
                "never predict when\n" +
                "theyâ€™re going to do\n" +
                "something incredibly\n" +
                "stupid.";
        System.out.println( text + "\n=> " );
        decolumnize( text );

        text = "Iâ€™m dishonest, and a never predict when\n" +
                "dishonest man you    theyâ€™re going to do\n" +
                "can always trust to  something incredibly\n" +
                "be dishonest.\n" +
                "                     stupid.\n" +
                "Honestly, itâ€™s the\n" +
                "honest ones you want\n" +
                "to watch out for,\n" +
                "because you can";
        System.out.println( text + "\n=> " );
        decolumnize( text );

        text = "Iâ€™m dishonest, and a    never predict when\n" +
                "dishonest man you       theyâ€™re going to do\n" +
                "can always trust to     something incredibly\n" +
                "be dishonest.           stupid.\n" +
                "Honestly, itâ€™s the\n" +
                "honest ones you want\n" +
                "to watch out for,\n" +
                "because you can";
        System.out.println( text + "\n=> " );
        decolumnize( text );

        decolumnize( "" );
        decolumnize( "One line" );
    }*/
