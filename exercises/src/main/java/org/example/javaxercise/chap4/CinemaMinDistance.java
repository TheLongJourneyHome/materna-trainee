package org.example.javaxercise.chap4;

import java.awt.*;
import java.util.Objects;

// Arrays
// distance
public class CinemaMinDistance {

    public static void main(String[] args) {
        Point[] points = { new Point(10, 20), new Point(12, 2), new Point(44, 4) };
        System.out.println(minDistance(points, points.length));
        System.out.println(pWithMinDistance(points, points.length));
    }

    public static double minDistance(Point[] points, int size) {
        Objects.requireNonNull(points); // null check for Point array
        for (Point p : points) { // null check for every Point
            Objects.requireNonNull(p);
        }

        Point zero = new Point();
        zero.setLocation(0,0);
        double minimumDistance = Double.MAX_VALUE; // start with highest -> it can only get lower or stay the same, if looking for next lowest value
//        System.out.println(minimumDistance);

        for (int i = 0; i < size; i++) {
//            Point.distance(zero.getX(), zero.getY(), points[i].getX(), points[i].getY());
            System.out.println(Point.distance(zero.getX(), zero.getY(), points[i].getX(), points[i].getY()));
            minimumDistance = Double.min(minimumDistance, Point.distance(zero.getX(), zero.getY(), points[i].getX(), points[i].getY())); // saves the minimum distance
        }
        System.out.println();

        return minimumDistance;
    }

    public static Point pWithMinDistance(Point[] points, int size) {
        Objects.requireNonNull(points); // null check for Point array
        for (Point p : points) { // null check for every Point
            Objects.requireNonNull(p);
        }

        Point pWithMinDistance = new Point();

        Point zero = new Point();
        zero.setLocation(0,0);
        double minimumDistance = Double.MAX_VALUE; // start with highest -> it can only get lower or stay the same, if looking for next lowest value
//        System.out.println(minimumDistance);

        for (int i = 0; i < size; i++) {

            if (Point.distance(zero.getX(), zero.getY(), points[i].getX(), points[i].getY()) < minimumDistance) {
                minimumDistance = Double.min(minimumDistance, Point.distance(zero.getX(), zero.getY(), points[i].getX(), points[i].getY())); // saves the minimum distance
                pWithMinDistance.setLocation(points[i]); // save the point with min distance and return it later, if it stays the point with the least distance
            }

        }

        return pWithMinDistance;
    }

}

// other solution
/*
//tag::solution1[]
static double minDistance( Point[] points, int size ) {

    if ( points.length == 0 || size > points.length )
        throw new IllegalArgumentException(
                "Array is either empty or size out of bounds" );

    double minDistance = points[ 0 ].distance( 0, 0 );

    // Index variable i starting at 1, second element
    for ( int i = 1; i < size; i++ ) {
        double distance = points[ i ].distance( 0, 0 );
        if ( distance < minDistance )
            minDistance = distance;
    }

    return minDistance;
}
    //end::solution1[]

    //tag::solution2[]
    static Point minDistance2( Point[] points, int size ) {
        Point  nearest = points[ 0 ];
        double minDistance = nearest.distance( 0, 0 );

        for ( int i = 1; i < size; i++ ) {
            double distance = points[ i ].distance( 0, 0 );
            if ( distance < minDistance ) {
                minDistance = distance;
                nearest = points[ i ];
            }
        }
        return nearest;
    }
    //end::solution2[]

    public static void main( String[] args ) {
        Point[] points = { new Point( 10, 20 ), new Point( 12, 2 ), new Point( 44, 4 ) };

        System.out.println( minDistance( points, 3 ) );
    }*/
