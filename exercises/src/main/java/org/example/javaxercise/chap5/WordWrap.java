package org.example.javaxercise.chap5;

// Zeichenketten
// trim
    // Returns a string whose value is this string, with all leading and trailing space removed, where space is defined as any character whose codepoint is less than or equal to 'U+0020' (the space character).
// substring
// lastIndexOf / indexOf
    // Returns the index within this string of the last occurrence of the specified character, searching backward starting at the specified index.
// recursive / recursion
public class WordWrap {
    public static void main(String[] args) {
        String s = "Live now; make now always the most precious time. "
                + "Now will never come again.";
        System.out.println( wrap( s, 30 ) );
    }

    public static String wrap(String string, int width) {

        if (string.length() <= width) { // check if the given string is still greater than the max width limit, else return the string and don't change anything here
            return string;
        }

        // with this words that surpass width, will be line broken earlier and the word remains whole
        int breakLineAt = string.lastIndexOf(' ', width); // search backwards from max width length and find the first space in the given string and break it there (at this index)
        if (breakLineAt < 0) { // if there is no more space found, then break point is at the position of width
            breakLineAt = width;
        }

        String firstPart = string.substring(0, breakLineAt);
        // recursion
        String remaining = wrap(string.substring(breakLineAt).trim(), width);

        return firstPart + "\n" // linebreak
                + remaining; // repeat for remaining until string of recursion becomes smaller or even width
    }
}


/*
// solution
public class WordWrap {

    //tag::solution[]
    public static String wrap( String string, int width ) {
        if ( string.length() <= width )
            return string;
        int breakIndex = string.lastIndexOf( ' ', width );
        if ( breakIndex == -1 )
            breakIndex = width;
        String firstLine = string.substring( 0, breakIndex );
        String remaining = wrap( string.substring( breakIndex ).trim(), width );
        return firstLine + "\n" + remaining;
    }
    //end::solution[]

    public static void main( String[] args ) {
        //tag::example[]
        String s = "Live now; make now always the most precious time. "
                + "Now will never come again.";
        System.out.println( wrap( s, 30 ) ); // not 10!!!
        //end::example[]
    }
}*/
