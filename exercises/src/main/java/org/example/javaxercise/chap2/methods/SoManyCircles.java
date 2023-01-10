package org.example.javaxercise.chap2.methods;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

// methods, HTML
public class SoManyCircles {
//    https://www.artists.de/281604-hommage-au-pointillismus

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int circleWidthLength;
        int circleRowRepetition;

        System.out.println("Enter number of circles per row: ");
        circleWidthLength = sc.nextInt();
        System.out.println("Enter number of repetitions: ");
        circleRowRepetition = sc.nextInt();

        startTag();
        drawRectWithCircle(circleRowRepetition, circleWidthLength, 5, 5, 4);
        endTag();
    }

/*    static void userInput() {
        Scanner sc = new Scanner(System.in);
        int circleWidthLength;
        int circleRowRepetition;

        System.out.println("Enter number of circles per row: ");
        circleWidthLength = sc.nextInt();
        System.out.println("Enter number of repetitions: ");
        circleRowRepetition = sc.nextInt();
    }*/

    // circle row
    // x,y = 5, r = 4
    static void drawCircleRow (int circleWidthLength, int cx, int cy, int cr) {
        int x = cx;
        int y = cy;
        int r = cr;
        String color;

        for (int i = 0; i < circleWidthLength; i++) {

            color = randomColor();
            // radius *2 is the gap to the next circle
            // * 2 at the end, so we get 1 circle gap between
            System.out.printf("   <circle cx=\"%d\" cy=\"%d\" r=\"%d\" stroke=\"black\" stroke-width=\"1\" fill=\"%s\" />%n", ( cx + (i*(r*2))*2 ), cy, r, color);
        }
    }

    // circle rectangle out of circle rows
    static void drawRectWithCircle(int circleRowRepetition, int circleWidthLength, int cx, int cy, int cr) {
        int x = cx;
        int y = cy;
        int r = cr;
        int noOfPearlsPerRow = circleWidthLength;

        for (int i = 0; i < circleRowRepetition; i++) {

            y += (r * 2);
            if (i % 2 == 0) { // when even
                x = cx;
                noOfPearlsPerRow = circleWidthLength;
                drawCircleRow(noOfPearlsPerRow, x, y, r);
            } else { // when uneven, 1 circle diameter gap, when first circle starts and total circles -1
                x += (r * 2);
                noOfPearlsPerRow -= 1;
                drawCircleRow(noOfPearlsPerRow, x, y, r);
            }

        }
    }

    static void startTag() {
//        style="background-color:LightGray
        System.out.println("<svg height=\"1000\" width=\"1000\" style=\"background-color:LightGray;\">");
    }

    static void endTag() {
        System.out.println("</svg>");
    }

    static String randomColor() {
        int randomColor = ThreadLocalRandom.current().nextInt(1,7);
        String color = switch (randomColor) {
            case 1 -> "blue";
            case 2 -> "green";
            case 3 -> "red";
            case 4 -> "yellow";
            case 5 -> "orange";
            default -> "black";
        };

        return color;
    }
}


// other solution
/*
public class SoManyCircles {

    static void circleSvg( int x, int y, int offset ) {
        System.out.printf( "<circle cx=\"%d\" cy=\"%d\" r=\"7\" fill=\"%s\" />%n",
                x + offset, y, randomColor() );
    }

    static void startSvg() {
        System.out.println(   "<svg height=\"1000\" width=\"1000\" "
                + "style='background-color: #5C5B57'>" );
    }

    static void endSvg() {
        System.out.println( "</svg>" );
    }

    static String randomColor() {
        return switch ( (int) (Math.random() * 6) ) {
            case 0 -> "#137546";
            case 1 -> "#AB1912";
            case 2 -> "#9F7B07";
            case 3 -> "#110F14";
            case 4 -> "#97948F";
            default -> "#004F88";
        };
    }

    public static void main( String[] args ) {

        final int DISTANCE = 20;
        final int MARGIN = 2 * DISTANCE;

        startSvg();
        for ( int y = MARGIN; y <= 1000 - MARGIN; y = y + DISTANCE ) {
            int offset = y % (2 * DISTANCE) == 0 ? 0 : DISTANCE / 2;

            for ( int x = MARGIN; x < 1000 - MARGIN; x = x + DISTANCE ) {
                circleSvg( x, y, offset );
            }
        }
        endSvg();
    }
}*/
