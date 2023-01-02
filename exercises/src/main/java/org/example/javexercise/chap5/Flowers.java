package org.example.javexercise.chap5;

// Zeichenketten
// draw flower
// TODO repeat flower exercise
// split
// repeat
// outOfBounds handling
// substring
// getNumericValue
// private static variable -> outside of main or methods
// !!!

public class Flowers {

    private static final String FLOWERS = """
                      _
                    _(_)_                          wWWWw   _
        @@@@       (_)@(_)   vVVVv     _     @@@@  (___) _(_)_
       @@()@@ wWWWw  (_)\\    (___)   _(_)_  @@()@@   Y  (_)@(_)
        @@@@  (___)     `|/    Y    (_)@(_)  @@@@   \\|/   (_)\\
         /      Y       \\|    \\|/    /(_)    \\|      |/      |
      \\ |     \\ |/       | / \\ | /  \\|/       |/    \\|      \\|/
      \\\\|//   \\\\|//   \\\\\\|//\\\\\\|/// \\|///  \\\\\\|//  \\\\|//  \\\\\\|//
      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
      """;

    public static final String[] FLOWER_LINES = FLOWERS.split("\n");
    public static final int FLOWER_HEIGHT = FLOWER_LINES.length; // y
    private static final int[] FLOWER_START_POS={0, 7, 13, 22, 29, 37, 44, 50, 57};
    private static final int LONGEST_LINE = FLOWER_LINES[FLOWER_LINES.length - 1].length(); // to handle out of bounds for later


/*    you can compare characters in Java to determine whether one is greater than or less than the other.
    In Java, characters are represented by the char type, which is a primitive data type that represents a single Unicode character*/
    public static int whichFlower(char flowerId) {
        return flowerId >= '1' && flowerId <= '8' ? Character.getNumericValue(flowerId) - 1 : 0; // -1, index counts from 0
    }

    public static String printFlowerLine(int flowerId, int heightPos) {
        String flowerLine = FLOWER_LINES[heightPos] + " ".repeat(LONGEST_LINE); // " ".repeat(LONGEST_LINE); -> handle out of bounds
        return flowerLine.substring(FLOWER_START_POS[flowerId], FLOWER_START_POS[flowerId + 1]); // from start index until next index
    }

    public static void printFlowers(String numbers) {
        for (int y = 0; y < FLOWER_HEIGHT; y++) {

            for (int x = 0; x < numbers.length(); x++) {
                System.out.print( printFlowerLine( whichFlower(numbers.charAt(x)), y ) ); // print the flower line from top to bottom
            }
            System.out.println(); // line break for next line

        }
    }

    public static void main( String[] args ) {
        printFlowers( "12345678" );
        printFlowers( "8383765432" );
        printFlowers( "ABC9" );
        printFlowers( "838" );
//        System.out.println('1' >= '2');
    }
}

/*public class Flowers {
*//*    public static void main(String[] args) {
*//**//*        String flower =
                "                _\n" +
                "              _(_)_                          wWWWw   _\n" +
                "  @@@@       (_)@(_)   vVVVv     _     @@@@  (___) _(_)_\n" +
                " @@()@@ wWWWw  (_)\\    (___)   _(_)_  @@()@@   Y  (_)@(_)\n" +
                "  @@@@  (___)     `|/    Y    (_)@(_)  @@@@   \\|/   (_)\\\n" +
                "   /      Y       \\|    \\|/    /(_)    \\|      |/      |\n" +
                "\\ |     \\ |/       | / \\ | /  \\|/       |/    \\|      \\|/\n" +
                "\\\\|//   \\\\|//   \\\\\\|//\\\\\\|/// \\|///  \\\\\\|//  \\\\|//  \\\\\\|//\n" +
                "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^";*//**//*
                "0123456789012345678901234567890123456789012345678901234567" // 0 -> 10/20/30...
*//**//*        String flowerC =
                "   _                                     \n" +
                " _(_)_                          wWWWw   _\n" +
                "(_)@(_)   vVVVv     _     @@@@  (___) _(_)_\n" +
                "  (_)\\    (___)   _(_)_  @@()@@   Y  (_)@(_)\n" +
                "     `|/    Y    (_)@(_)  @@@@   \\|/   (_)\\\n" +
                "     \\|    \\|/    /(_)    \\|      |/      |\n" +
                "      | / \\ | /  \\|/       |/    \\|      \\|/\n" +
                "   \\\\\\|//\\\\\\|/// \\|///  \\\\\\|//  \\\\|//  \\\\\\|//\n" +
                "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^";

        String flower1 =
                "        \n" +
                "        \n" +
                "  @@@@  \n" +
                " @@()@@ \n" +
                "  @@@@  \n" +
                "   /    \n" +
                "\\ |     \n" +
                "\\\\|//   \n" +
                "^^^^^^^^";

        String flower2 =
                "        \n" +
                "        \n" +
                "        \n" +
                "wWWWw   \n" +
                "(___)   \n" +
                "  Y     \n" +
                "\\ |/    \n" +
                "\\\\|//   \n" +
                "^^^^^^^^";

        String flower3 =
                "   _      \n" +
                " _(_)_    \n" +
                "(_)@(_)   \n" +
                "  (_)\\    \n" +
                "     `|/  \n" +
                "     \\|   \n" +
                "      | / \n" +
                "   \\\\\\|// \n" +
                "^^^^^^^^^^";

        String flower4 = "";

        String flower5 = "";

        String flower6 = "";

        String flower7 = "";

        String flower8 = "";

        System.out.println(flower);
        System.out.println();
        System.out.println(flower1);
        System.out.println(flower2);
        System.out.println(flower3);
        System.out.println(flower4);
        System.out.println(flower5);
        System.out.println(flower6);
        System.out.println(flower7);
        System.out.println(flower8);*//**//*
        final String FLOWERS = """
                                _
                              _(_)_                          wWWWw   _
                  @@@@       (_)@(_)   vVVVv     _     @@@@  (___) _(_)_
                 @@()@@ wWWWw  (_)\\    (___)   _(_)_  @@()@@   Y  (_)@(_)
                  @@@@  (___)     `|/    Y    (_)@(_)  @@@@   \\|/   (_)\\
                   /      Y       \\|    \\|/    /(_)    \\|      |/      |
                \\ |     \\ |/       | / \\ | /  \\|/       |/    \\|      \\|/
                \\\\|//   \\\\|//   \\\\\\|//\\\\\\|/// \\|///  \\\\\\|//  \\\\|//  \\\\\\|//
                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                """;
        printFlower("838");
        printFlower("ABC9");
        // split
    }

    public static void printFlower(String flowerPattern) {
        String flowers = "";
        for (int i = 0; i < flowerPattern.length(); i++) {
            flowers += switch (Character.getNumericValue(flowerPattern.charAt(i))) {
                case 1 -> "flower 1 "; // redundant, can delete case 1 // -> 8
                case 2 -> "flower 2 "; // 5
                case 3 -> "flower 3 "; // 9
                case 4 -> "flower 4 "; // 8
                case 5 -> "flower 5 "; // 7
                case 6 -> "flower 6 "; // 8
                case 7 -> "flower 7 "; // 5
                case 8 -> "flower 8 "; // 8
                default -> "flower 1 ";
            };
        }



        System.out.println(flowers);
    }
}*/


// solution
/*
public class Flowers {

    //tag::solution[]
    private static final String FLOWERS = """
                      _
                    _(_)_                          wWWWw   _
        @@@@       (_)@(_)   vVVVv     _     @@@@  (___) _(_)_
       @@()@@ wWWWw  (_)\\    (___)   _(_)_  @@()@@   Y  (_)@(_)
        @@@@  (___)     `|/    Y    (_)@(_)  @@@@   \\|/   (_)\\
         /      Y       \\|    \\|/    /(_)    \\|      |/      |
      \\ |     \\ |/       | / \\ | /  \\|/       |/    \\|      \\|/
      \\\\|//   \\\\|//   \\\\\\|//\\\\\\|/// \\|///  \\\\\\|//  \\\\|//  \\\\\\|//
      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
      """;

    private static final int[] FLOWER_START_POS={0, 7, 13, 22, 29, 37, 44, 50, 57};

    private static final String[] FLOWER_LINES = FLOWERS.split( "\n" );
    private static final int FLOWER_HEIGHT = FLOWER_LINES.length;
    private static final int LONGEST_LINE_LEN=FLOWER_LINES[FLOWER_HEIGHT-1].length();

    private static String flowerLine( int flower, int line ) {
        String s = FLOWER_LINES[ line ] + " ".repeat( LONGEST_LINE_LEN ); // to avoid out of bounds error
        return s.substring( FLOWER_START_POS[flower], FLOWER_START_POS[flower + 1] );
    }

    private static int flowerFromId( char id ) {
        return id >= '1' && id <= '8' ? Character.getNumericValue( id ) - 1 : 0;
    }

    public static void printFlowers( String string ) {
        for ( int line = 0; line < FLOWER_HEIGHT; line++ ) {
            for ( int i = 0; i < string.length(); i++ )
                System.out.print( flowerLine( flowerFromId( string.charAt( i ) ), line ) ); // print for amount of numbers in string, amount of flower parts of the current line
            System.out.println();
        }
    }
    //end::solution[]

    public static void main( String[] args ) {
        printFlowers( "12345678" );
        printFlowers( "8383765432" );
        printFlowers( "ABC9" );
        printFlowers( "838" );
    }
}*/
