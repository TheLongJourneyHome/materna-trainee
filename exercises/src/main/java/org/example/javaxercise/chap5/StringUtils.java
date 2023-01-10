package org.example.javaxercise.chap5;

// Zeichenketten
// substring
// indexOf
public class StringUtils {
    public static void main(String[] args) {
        /*String test = "BlaBlubber";
        System.out.println(test.substring(1,4)); // laB, begin inclusive, end exclusive*/

        countMatches(null, null);       // = 0
        countMatches("", null);         // = 0
        countMatches("abba", null);  // = 0
        countMatches("abba", "");    // = 0
        countMatches("abba", "a");   // = 2
        countMatches("aaaa", "aa");  // = 2
        countMatches("abba", "ab");  // = 1
        countMatches("abba", "xxx"); // = 0
    }

    /**
     * Counts how many times the substring appears in the larger string.
     *
     * A {@code null} or empty ("") String input returns {@code 0}.
     *
     * <pre>
     * StringUtils.countMatches(null, *)       = 0
     * StringUtils.countMatches("", *)         = 0
     * StringUtils.countMatches("abba", null)  = 0
     * StringUtils.countMatches("abba", "")    = 0
     * StringUtils.countMatches("abba", "a")   = 2
     * StringUtils.countMatches("aaaa", "aa")  = 2
     * StringUtils.countMatches("abba", "ab")  = 1
     * StringUtils.countMatches("abba", "xxx") = 0
     * </pre>
     *
     * @param string  the String to check, may be null
     * @param other   the substring to count, may be null
     * @return the number of occurrences, 0 if either String is {@code null}
     */
    public static int countMatches( String string, String other ) {
        int counter = 0;
        if (string == null || other == null || string.isEmpty() || other.isEmpty()) {
            System.out.println("Either was null: 0");
            return 0;
        }

        for (int i = 0; i < string.length()-other.length()+1; i += other.length()) {
            if (string.substring(i,i+other.length()).equals(other)) {
                counter++;
            }
        }

        System.out.println(counter);
        return counter;
    }
}

// solution
// indexOf -> indexOf(int ch, int fromIndex) -> Returns the index within this string of the first occurrence of the specified character(s), starting the search at the specified index.
/*
//tag::solution[]
private static final int INDEX_NOT_FOUND = -1;

    public static int countMatches( String string, String other ) {

        if (    string == null || other == null
                || string.length() == 0 || other.length() == 0 )
            return 0;

        int result = 0;

        for ( int index = 0;
              (index = string.indexOf( other, index )) != INDEX_NOT_FOUND;
              index += other.length() )
            result++;

        return result;
    }
    //end::solution[]

    public static void main( String[] args ) {
        System.out.println( countMatches( "abba", "" ) );
        System.out.println( countMatches( "abba", "a" ) );
        System.out.println( countMatches( "abba", "ab" ) );
        System.out.println( countMatches( "abba", "xxx" ) );
        System.out.println( countMatches( "aaaa", "aa" ) );
    }*/
