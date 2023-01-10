package org.example.javaxercise.chap4;

import java.awt.*;
import java.util.Arrays;

// Arrays
// understanding memory allocation (reference and values)
public class PointFields {
    public static void main(String[] args) {
        Point[] points = { null, null, null, null };
        Point p = new Point();
        p.setLocation( 1, 2 );
        points[ 0 ] = p;
        System.out.println(points[0]); // 1, 2
        System.out.println();

        p.setLocation( 3, 4 );
        points[ 1 ] = p;
        System.out.println(points[1]); // 3, 4
        System.out.println(points[0]); // 3, 4
        System.out.println();

        Point q = points[ 1 ]; // when changing q, it will overwrite all the values in the array?
        System.out.println(q); // 3, 4
        System.out.println(points[0]);
        System.out.println();

        q.setLocation( 5, 6 );
        System.out.println(q); // 5, 6
        System.out.println(points[0]);
        System.out.println( Arrays.toString( points ) ); // (5, 6), (5, 6), null, null
        System.out.println();

        points[ 2 ] = points[ 3 ] = q;
        System.out.println(points[0]);
        System.out.println( Arrays.toString( points ) ); // (5, 6), (5, 6), (5, 6), (5, 6)
    }
}
