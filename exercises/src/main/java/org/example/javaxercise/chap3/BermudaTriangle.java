package org.example.javaxercise.chap3;

import java.awt.*;

// class, object, package
public class BermudaTriangle {
    public static void main(String[] args) {

        Polygon bermuda = new Polygon();
        Polygon randomTriangle = createRandomTriangle(); // new already inside this method
        // points between 0 to 50
        bermuda.addPoint(11,39);
        bermuda.addPoint(23,12);
        bermuda.addPoint(47,23);

        // ship coordinates
        int shipX = 9;
        int shipY = 22;

        // check if point is within bermuda
        System.out.println(bermuda.contains(shipX, shipY)); // false
        shipX = 21;
        shipY = 21;
        System.out.println(bermuda.contains(shipX, shipY)); // true

        resetWithRandomTriangle(bermuda);

        // \uD83D\uDC19 -> kraken
        // \uD83C\uDF2B -> mist
        // \uD83C\uDF2B -> rainbow
        for (int y = 0; y < 50; y++) {
            for (int x = 0; x < 50; x++) {
                if (x == 0 || x == 49 || y == 0 || y == 49) {
                    System.out.print("="); // edge
                } else {
                    System.out.print(bermuda.contains(x,y) ? "*" : "N"); // kraken (triangle) : mist
                }
            }
            System.out.println();
        }
    }

    static Polygon resetWithRandomTriangle( Polygon polygon ) {
        polygon.reset(); // reset the polygon

        // add random values for the polygon
        polygon.addPoint(randomNumber(),randomNumber());
        polygon.addPoint(randomNumber(),randomNumber());
        polygon.addPoint(randomNumber(),randomNumber());

        return polygon;
    }

    static Polygon createRandomTriangle() {
        return resetWithRandomTriangle(new Polygon());
    }

    static int randomNumber () {
        // range 0-49

        return (int) (Math.random() * 50);
    }
}


// solution
/*
public class BermudaTriangle2 {

    //tag::solution[]
    private static final int DIMENSION = 50;

    static Polygon resetWithRandomTriangle( Polygon poly ) {
        poly.reset();

        Random random = ThreadLocalRandom.current();
        poly.addPoint( random.nextInt( DIMENSION ), random.nextInt( DIMENSION ) );
        poly.addPoint( random.nextInt( DIMENSION ), random.nextInt( DIMENSION ) );
        poly.addPoint( random.nextInt( DIMENSION ), random.nextInt( DIMENSION ) );

        return poly;
    }

    static Polygon createRandomTriangle() {
        return resetWithRandomTriangle( new Polygon() );
    }
    //end::solution[]

    public static void main( String[] args ) {
        Polygon polygonX = resetWithRandomTriangle( new Polygon() );
        Polygon polygon = createRandomTriangle();

        for ( int y = 0; y < DIMENSION; y++ ) {
            for ( int x = 0; x < DIMENSION; x++ )
                System.out.print( polygon.contains( x, y ) ? "#" : " " );
            System.out.println();
        }
    }
}*/
