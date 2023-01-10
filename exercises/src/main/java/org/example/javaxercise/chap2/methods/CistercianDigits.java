package org.example.javaxercise.chap2.methods;

import java.util.Scanner;

// methods, hard
// http://tutego.de/javabuch/aufgaben/imperativ.html#_zisterzienser_zahlschrift_neu
public class CistercianDigits {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input;

        System.out.println("Enter a positive number between 1 and 9999 to create a pattern: ");
        input = sc.nextInt();

        if (input < 1 || input > 9999) {
            System.out.println("Input must be a number between 1 and 9999!");
        } else {
            svgTagBegin();
            gTagBegin();

            separateInt(input);

            gTagEnd();
            svgTagEnd();
        }
    }

    static void svgTagBegin() {
        System.out.println("<svg height=\"1400\" width=\"1400\">");
    }

    static void svgTagEnd() {
        System.out.println("</svg>");
    }

    static void gTagBegin() {
        System.out.println("<g style=\"stroke:grey;stroke-linecap:round;stroke-width:2\">");
    }

    static void gTagEnd() {
        System.out.println("</g>");
    }

    static void separateInt(int number) {
        int thousands;
        int hundreds;
        int tens;
        int ones;

        ones = number % 10;
        number /= 10;
        tens = number % 10;
        number /= 10;
        hundreds = number % 10;
        number /= 10;
        thousands = number % 10;
//        System.out.printf("%d  %d  %d  %d  ", thousands, hundreds, tens, ones);

        createPattern(thousands, hundreds, tens, ones);
    }

    static void createPattern(int thousands, int hundreds, int tens, int ones) {
        // middle line
        System.out.println("<line x1=\"100\" y1=\"85\" x2=\"100\" y2=\"115\" />");

        createThousands(thousands);
        createHundreds(hundreds);
        createTens(tens);
        createOnes(ones);
    }

    static void createOnes(int ones) {
        switch (ones) {
            case 1 -> System.out.println("<line x1=\"100\" y1=\"85\" x2=\"110\" y2=\"85\" />");
            case 2 -> System.out.println("<line x1=\"100\" y1=\"95\" x2=\"110\" y2=\"95\" />");
            case 3 -> System.out.println("<line x1=\"100\" y1=\"85\" x2=\"110\" y2=\"95\" />");
            case 4 -> System.out.println("<line x1=\"100\" y1=\"95\" x2=\"110\" y2=\"85\" />");
            case 5 -> { // 1+4
                System.out.println("<line x1=\"100\" y1=\"85\" x2=\"110\" y2=\"85\" />");
                System.out.println("<line x1=\"100\" y1=\"95\" x2=\"110\" y2=\"85\" />");
            }
            case 6 -> System.out.println("<line x1=\"110\" y1=\"85\" x2=\"110\" y2=\"95\" />");
            case 7 -> { // 1+6
                System.out.println("<line x1=\"100\" y1=\"85\" x2=\"110\" y2=\"85\" />");
                System.out.println("<line x1=\"110\" y1=\"85\" x2=\"110\" y2=\"95\" />");
            }
            case 8 -> { // 2+6
                System.out.println("<line x1=\"100\" y1=\"95\" x2=\"110\" y2=\"95\" />");
                System.out.println("<line x1=\"110\" y1=\"85\" x2=\"110\" y2=\"95\" />");
            }
            default -> { // default 9: 1+2+6
                System.out.println("<line x1=\"100\" y1=\"85\" x2=\"110\" y2=\"85\" />");
                System.out.println("<line x1=\"100\" y1=\"95\" x2=\"110\" y2=\"95\" />");
                System.out.println("<line x1=\"110\" y1=\"85\" x2=\"110\" y2=\"95\" />");
            }
        }
    }

    static void createTens(int tens) {
        // same as one, but mirrored in x -> -20
        // all x2 -20, x1 -20 for '6' as well
        switch (tens) {
            case 1 -> System.out.println("<line x1=\"100\" y1=\"85\" x2=\"90\" y2=\"85\" />");
            case 2 -> System.out.println("<line x1=\"100\" y1=\"95\" x2=\"90\" y2=\"95\" />");
            case 3 -> System.out.println("<line x1=\"100\" y1=\"85\" x2=\"90\" y2=\"95\" />");
            case 4 -> System.out.println("<line x1=\"100\" y1=\"95\" x2=\"90\" y2=\"85\" />");
            case 5 -> { // 1+4
                System.out.println("<line x1=\"100\" y1=\"85\" x2=\"90\" y2=\"85\" />");
                System.out.println("<line x1=\"100\" y1=\"95\" x2=\"90\" y2=\"85\" />");
            }
            case 6 -> System.out.println("<line x1=\"90\" y1=\"85\" x2=\"90\" y2=\"95\" />");
            case 7 -> { // 1+6
                System.out.println("<line x1=\"100\" y1=\"85\" x2=\"90\" y2=\"85\" />");
                System.out.println("<line x1=\"90\" y1=\"85\" x2=\"90\" y2=\"95\" />");
            }
            case 8 -> { // 2+6
                System.out.println("<line x1=\"100\" y1=\"95\" x2=\"90\" y2=\"95\" />");
                System.out.println("<line x1=\"90\" y1=\"85\" x2=\"90\" y2=\"95\" />");
            }
            default -> { // default 9: 1+2+6
                System.out.println("<line x1=\"100\" y1=\"85\" x2=\"90\" y2=\"85\" />");
                System.out.println("<line x1=\"100\" y1=\"95\" x2=\"90\" y2=\"95\" />");
                System.out.println("<line x1=\"90\" y1=\"85\" x2=\"90\" y2=\"95\" />");
            }
        }
    }

    static void createHundreds(int hundreds) {
        // mirror top to down, but right stays right (y = 85 -> 115 (+20), y = 95 -> 105 (+10)
        switch (hundreds) {
            case 1 -> System.out.println("<line x1=\"100\" y1=\"115\" x2=\"110\" y2=\"115\" />");
            case 2 -> System.out.println("<line x1=\"100\" y1=\"105\" x2=\"110\" y2=\"105\" />");
            case 3 -> System.out.println("<line x1=\"100\" y1=\"115\" x2=\"110\" y2=\"105\" />");
            case 4 -> System.out.println("<line x1=\"100\" y1=\"105\" x2=\"110\" y2=\"115\" />");
            case 5 -> { // 1+4
                System.out.println("<line x1=\"100\" y1=\"115\" x2=\"110\" y2=\"115\" />");
                System.out.println("<line x1=\"100\" y1=\"105\" x2=\"110\" y2=\"115\" />");
            }
            case 6 -> System.out.println("<line x1=\"110\" y1=\"115\" x2=\"110\" y2=\"105\" />");
            case 7 -> { // 1+6
                System.out.println("<line x1=\"100\" y1=\"115\" x2=\"110\" y2=\"115\" />");
                System.out.println("<line x1=\"110\" y1=\"115\" x2=\"110\" y2=\"105\" />");
            }
            case 8 -> { // 2+6
                System.out.println("<line x1=\"100\" y1=\"105\" x2=\"110\" y2=\"105\" />");
                System.out.println("<line x1=\"110\" y1=\"115\" x2=\"110\" y2=\"105\" />");
            }
            default -> { // default 9: 1+2+6
                System.out.println("<line x1=\"100\" y1=\"115\" x2=\"110\" y2=\"115\" />");
                System.out.println("<line x1=\"100\" y1=\"105\" x2=\"110\" y2=\"105\" />");
                System.out.println("<line x1=\"110\" y1=\"115\" x2=\"110\" y2=\"105\" />");
            }
        }
    }

    static void createThousands(int thousands) {
        // mirror top to down and right to left -> use 10 and 100 rules
        // (all x2 -20, x1 -20 for '6' as well)
        switch (thousands) {
            case 1 -> System.out.println("<line x1=\"100\" y1=\"115\" x2=\"90\" y2=\"115\" />");
            case 2 -> System.out.println("<line x1=\"100\" y1=\"105\" x2=\"90\" y2=\"105\" />");
            case 3 -> System.out.println("<line x1=\"100\" y1=\"115\" x2=\"90\" y2=\"105\" />");
            case 4 -> System.out.println("<line x1=\"100\" y1=\"105\" x2=\"90\" y2=\"115\" />");
            case 5 -> { // 1+4
                System.out.println("<line x1=\"100\" y1=\"115\" x2=\"90\" y2=\"115\" />");
                System.out.println("<line x1=\"100\" y1=\"105\" x2=\"90\" y2=\"115\" />");
            }
            case 6 -> System.out.println("<line x1=\"90\" y1=\"115\" x2=\"90\" y2=\"105\" />");
            case 7 -> { // 1+6
                System.out.println("<line x1=\"100\" y1=\"115\" x2=\"90\" y2=\"115\" />");
                System.out.println("<line x1=\"90\" y1=\"115\" x2=\"90\" y2=\"105\" />");
            }
            case 8 -> { // 2+6
                System.out.println("<line x1=\"100\" y1=\"105\" x2=\"90\" y2=\"105\" />");
                System.out.println("<line x1=\"90\" y1=\"115\" x2=\"90\" y2=\"105\" />");
            }
            default -> { // default 9: 1+2+6
                System.out.println("<line x1=\"100\" y1=\"115\" x2=\"90\" y2=\"115\" />");
                System.out.println("<line x1=\"100\" y1=\"105\" x2=\"90\" y2=\"105\" />");
                System.out.println("<line x1=\"90\" y1=\"115\" x2=\"90\" y2=\"105\" />");
            }
        }
    }

    // Comments for rules
    /*// central mid line -> <line x1="100" y1="85" x2="100" y2="115" />
    //
    // diagonal upper right, bottom left to top right -> <line x1="100" y1="95" x2="110" y2="85" />
    // diagonal bottom right, bottom left to top right -> <line x1="100" y1="115" x2="110" y2="105" />
    //
    // top left square side, top -> <line x1="100" y1="85" x2="90" y2="85" />
    // top left square side, bottom -> <line x1="100" y1="95" x2="90" y2="95" />
    // top left square side, side (left) -> <line x1="90" y1="85" x2="90" y2="95" />
    //
    // bottom left square side, bottom -> <line x1="100" y1="115" x2="90" y2="115" />
    // bottom left square side, top -> <line x1="100" y1="105" x2="90" y2="105" />
    // bottom left square side, side (left) -> <line x1="90" y1="115" x2="90" y2="105" />


    // all numbers have middle line -> <line x1="100" y1="85" x2="100" y2="115" />
    // x1/2 = 100 is the middle line
    // y1 = 85 is the top of line
    // y2 = 115 is the bottom of line
    // 115 bottom, 105 bottom top, 95 top bottom, 85 top

    // 1: top right, top -> <line x1="100" y1="85" x2="110" y2="85" />
    // 2: top right, bottom -> <line x1="100" y1="95" x2="110" y2="95" /> // both y 95, if only y1 95 and y2 85, then it goes diagonal down from left to right
    // 3: top right, diagonal down, left to right -> <line x1="100" y1="85" x2="110" y2="95" />
    // 4: top right, diagonal up, left to right -> <line x1="100" y1="95" x2="110" y2="85" />
    // 5: 1 + 4
    // 6: top right, side -> <line x1="110" y1="85" x2="110" y2="95" />
    // 7: 1 + 6
    // 8: 2 + 6
    // 9: 1 + 2 + 6

    // * 10 -> mirror right to left (x2 -20, x1 -20 when side line)
    // * 100 -> mirror top to down, but right stays right (y = 85 -> 115 (+20), y = 95 -> 105 (+10)
    // * 1000 -> mirror top to down and right to left -> use 10 and 100 rules*/
}


// other solution
/*public class CistercianDigits {

    static void printSvgLine( int x, int y, int dx1, int dy1, int dx2, int dy2 ) {
        System.out.printf( "<line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" />\n",
                x + dx1, y + dy1, x + dx2, y + dy2 );
    }

    static void printCistercianDigits( int value, int x, int y, int size ) {
        printSvgLine( x, y, 0, -size - size / 2, 0, size + size / 2 );
        printQuadrant( value % 10, x, y, size, false, false );        // top right corner (___*)
        printQuadrant( (value / 10) % 10, x, y, size, true, false );  // top left corner (__*_)
        printQuadrant( (value / 100) % 10, x, y, size, false, true ); // bottom right corner (_*__)
        printQuadrant( (value / 1000) % 10, x, y, size, true, true ); // bottom left corner (*___)
    }

    static void printQuadrant( int value, int x, int y, int size,
                               boolean mirroredX, boolean mirroredY ) {
        int dx = mirroredX ? -size : size;
        int dy = mirroredY ? -size : size;
        y -= 0.5 * dy;

        switch ( value ) {
            case 1, 5, 7, 9 -> printSvgLine( x, y, 0, -dy, dx, -dy );
        }
        switch ( value ) {
            case 2, 8, 9 -> printSvgLine( x, y, 0, 0, dx, 0 );
        }
        switch ( value ) {
            case 3 -> printSvgLine( x, y, 0, -dy, dx, 0 );
            case 4, 5 -> printSvgLine( x, y, 0, 0, dx, -dy );
            case 6, 7, 8, 9 -> printSvgLine( x, y, dx, -dy, dx, 0 );
        }
    }

    public static void main( String[] args ) {
        final int SIZE = 10;
        final int startX = 20;
        final int startY = 20;
        System.out.println( "<svg height=\"1400\" width=\"1400\">\n" +
                "<g style=\"stroke:grey;stroke-linecap:round;stroke-width:2\">" );
        printCistercianDigits( 9394, 100, 100, SIZE );

//    int value = 1;
//    for ( int _i = 0; _i <= 34; _i++ ) {
//      for ( int i_ = 0; i_ <= 34; i_++ ) {
//        printCistercianDigits( value, startX + (i_ * 40), startY + (_i * 40), SIZE );
//        value++;
//      }
//    }

        System.out.println( "</g>\n</svg>" );
    }
}*/
