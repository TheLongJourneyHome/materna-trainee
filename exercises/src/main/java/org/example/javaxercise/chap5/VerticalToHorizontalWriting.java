package org.example.javaxercise.chap5;

// Zeichenketten
// split
// charAt
// nested loops Y X
// replace
// coordinates
public class VerticalToHorizontalWriting {

//    private static final String TEST = "test";

    public static void main(String[] args) {
        /*
        S U
        EY!
        AO
        -> SEA (1) + _YO (2) + U!_ (3)
        */
        /*String s = "s u\n" +
                "ey!\n" +
                "ao ";*/

        // different string length after splitting (6,4,5)
        String s = "s usn)\n" +
                "ey!o\n" +
                "ao o:"; // -> sea you! soon :)


        System.out.println(s);
        System.out.println();
        printVerticalToHorizontalWriting( s );
    }

    public static void printVerticalToHorizontalWriting(String message) {
        String[] lines = message.split("\n");
        int wordLength = lines.length; // height, y
        int maxWidth = getMaxWidth(lines); // probably not needed here

        String result = "";

        for (int y = 0; y < maxWidth; y++) { // check all the chars until max string length reached (of the the string with the biggest string length)

            for (int chars = 0; chars < wordLength; chars++) {
                String line = lines[chars] + " ".repeat(maxWidth); // handle out of bounds
//                System.out.println(line);
                result += line.charAt(y); // lines[0,1,2][0,0,0] -> S,E,A print from top to down at the same index every time
            }
        }

        System.out.println(result);
        System.out.println(result.length());
    }

    // return the line with the largest width
    public static int getMaxWidth(String[] lines) {
        int maxWidth = lines[0].length();

        for (String line : lines) {
//            System.out.println(line.length());
            maxWidth = Math.max(maxWidth, line.length());
        }

//        System.out.println(maxWidth);
        return maxWidth;
    }
}


// solution
/*
public class VerticalToHorizontalWriting {

    //tag::solution[]
    static void printVerticalToHorizontalWriting( String string ) {
        String oneliner   = string.replace( "\n", "" );
        int numberOfLines = string.length() - oneliner.length() + 1;
        for ( int i = 0; i < oneliner.length(); i++ ) {
            char c = oneliner.charAt(   (i / numberOfLines)
                    + (i % numberOfLines) * numberOfLines );
            System.out.print( c );
        }
    }
    //end::solution[]

    public static void main( String[] args ) {
        String s = "s u\n" +
                "ey!\n" +
                "ao ";
        printVerticalToHorizontalWriting( s );
    }
}*/
