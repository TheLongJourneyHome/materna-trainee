package org.example.javaxercise.chap2.methods;

// methods
public class RightTriangle {
    public static void main(String[] args) {
        System.out.println(isRightTriangle(3, 4, 5)); // → true

        System.out.println(isRightTriangle(5, 4, 3)); // → true

        System.out.println(isRightTriangle(5, 12, 13)); // → true

        System.out.println(isRightTriangle(1, 2, 3)); // → false

        System.out.println(isRightTriangle(1, 1, Math.sqrt(2))); // → false
    }


    public static boolean isRightTriangle( double a, double b, double c ) {
        return (
                (a * a) + (b * b) == (c * c) ||
                (a * a) + (c * c) == (b * b) ||
                (c * c) + (b * b) == (a * a)
                );
    }
}


// other solutions
/*
public class RightTriangle {

    static class RightTriangle1 {
        //tag::solution-1[]
        public static boolean isRightTriangle( double a, double b, double c ) {
            return    a * a == b * b + c * c
                    || b * b == a * a + c * c
                    || c * c == b * b + a * a;
        }
        //end::solution-1[]

        public static void main( String[] args ) {
            // 3^2 + 4^2 = 5^3
            // Pythagorean Triple ratio of 3:4:5
            System.out.println( isRightTriangle( 3, 4, 5 ) );
            System.out.println( isRightTriangle( 5, 4, 3 ) );
            System.out.println( isRightTriangle( 5, 12, 13 ) ); // 25.0 + 144.0 = 169.0
            System.out.println( isRightTriangle( 1, 2, 3 ) );
            System.out.println( isRightTriangle( 1, 1, Math.sqrt( 2 ) ) );
            System.out.println( Math.sqrt( 2 ) * Math.sqrt( 2 ) ); // 2.0000000000000004
        }
    }

    static class RightTriangle12 {
        //tag::solution-1[]
        public static boolean isRightTriangle( double a, double b, double c ) {
            double aË£a = a * a;
            double bË£b = b * b;
            double cË£c = c * c;
            return aË£a == bË£b + cË£c || bË£b == aË£a + cË£c || cË£c == bË£b + aË£a;
        }
        //end::solution-1[]
    }

    static class RightTriangle2 {
        //tag::solution-2[]
        public static boolean isRightTriangle( double a, double b, double c ) {
            // Step 1: propagate the largest value into c

            // If a > c then swap
            if ( a > c ) {
                double swap = a;
                a = c;
                c = swap;
            }

            // If b > c then swap
            if ( b > c ) {
                double swap = b;
                b = c;
                c = swap;
            }

            // Step 2: The test
            return a * a + b * b == c * c;
        }
        //end::solution-2[]

        public static void main( String[] args ) {
            // 3^2 + 4^2 = 5^3
            // Pythagorean Triple ratio of 3:4:5
            System.out.println( isRightTriangle( 3, 4, 5 ) );
            System.out.println( isRightTriangle( 5, 4, 3 ) );
            System.out.println( isRightTriangle( 5, 12, 13 ) ); // 25.0 + 144.0 = 169.0
            System.out.println( isRightTriangle( 1, 2, 3 ) );
            System.out.println( isRightTriangle( 1, 1, Math.sqrt( 2 ) ) );
            System.out.println( Math.sqrt( 2 ) * Math.sqrt( 2 ) ); // 2.0000000000000004
        }
    }

    //  public static boolean almostEqual( double a, double b, double tolerance ) {
    //    return Math.abs( a - b ) < tolerance;
    //  }
}*/
