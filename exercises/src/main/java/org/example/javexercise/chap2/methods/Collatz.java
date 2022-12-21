package org.example.javexercise.chap2.methods;

public class Collatz {
    public static void main(String[] args) {
        // without static before collatz method, need object of the class
        Collatz bla = new Collatz();
        bla.collatz(19);
        collatz(7);
        System.out.println();
        System.out.println();
        collatz(27);
        System.out.println("***************************************************");
        collatzMax(27);
    }

    static void collatz(long n) {

        for (long i = n; i != 1; i = i % 2 == 0 ? (i/2) : (i*3 + 1) ) {
            System.out.println(i);
        }
    }


    // only prints newest max
    static void collatzMax(long n) {
        long maxNumber = 0;
        for (long i = n; i != 1; i = i % 2 == 0 ? (i/2) : (i*3 + 1) ) {
//            System.out.println(i);
            if (maxNumber < i) {
                System.out.println(i);
                maxNumber = Math.max(maxNumber, i);
            }
        }
    }

    // rekursiv = call its own code
}


// solution
/*class Collatz {

    //tag::solution[]
    static void collatz( long n ) {
        while ( n > 1 ) {
            System.out.print( n + " -> " );
            if ( n % 2 == 0 )
                n /= 2;
            else
                n = 3 * n + 1;
        }
        System.out.println( 1 );
    }

    static long collatzMax( long n ) {
        long max = n;
        while ( n > 1 ) {
            if ( n % 2 == 0 )
                n /= 2;
            else {
                n = 3 * n + 1;
                if ( n > max )
                    max = n;
            }
        }
        return max;
    }

    static long collatz( long n, long max ) {
        if ( n > 1 ) {
            if ( n % 2 == 0 )
                return collatz( n / 2, Math.max( n, max ) );
            return collatz( 3 * n + 1, Math.max( n, max ) );
        }
        return max;
    }

    public static void main( String[] args ) {
        collatz( 27 );
        System.out.println( collatzMax( 27 ) );
        System.out.println( collatz( 27, 0 ) );
        collatz( 20 );
        System.out.println( collatzMax( 20 ) );
        System.out.println( collatz( 20, 0 ) );


        System.out.println( collatzMax( 27 ) );
        System.out.println( collatz( 27, 0 ) );
    }
    //end::solution[]
}*/
