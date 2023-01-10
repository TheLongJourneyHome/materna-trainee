package org.example.javaxercise.chap2.methods;


import java.util.Scanner;

// methods
public class LinePrinter {
    protected static void line() {
        // 1.6.1
        Scanner sc = new Scanner(System.in);
        int amountOfHearts;

        System.out.println("How many ♥ do you want to print?");
        amountOfHearts = sc.nextInt();

        for (int i = 0; i < amountOfHearts; i++) {
            System.out.print("♥");
        }
        System.out.println();
        // 1.6.2
    }

    protected static void line(int len) {
        line(len, '-');
    }

    protected static void line(int len, char c) {
        char symbol = c;
        for (int i = 0; i < len; i++) {
            System.out.printf(String.valueOf(symbol));
        }
    }

    protected static void line(String prefix, int len, char c, String suffix) {
        System.out.print(prefix);
        line(len, c);
        System.out.println(suffix);
    }

    // extra from solution
    // check how many full strings fit
    // check how long the remaining string will be if it won't fit anymore
    public static void line( int len, String string ) {
        int noOfFullStrings = len / string.length();

        String remainString = string.substring(0, len % string.length());

        while (noOfFullStrings-- > 0)
            System.out.print(string);

        System.out.println(remainString);
    }

    // solution
/*    //tag::solution1[]
    public static void line() {
        System.out.print( "â™¥â™¥â™¥â™¥â™¥â™¥â™¥â™¥â™¥â™¥" );
    }
    //end::solution1[]

    //tag::solution2[]
    public static void line( int len, char c ) {
        while ( len-- > 0 )
            System.out.print( c );
    }

    public static void line( int len ) {
        line( len, '-' );
    }

    public static void line( String prefix, int len, char c, String suffix ) {
        System.out.print( prefix );
        line( len, c );
        System.out.print( suffix );
    }
    //end::solution2[]

    public static void line( int len, String string ) {
        int noOfFullStrings = len / string.length();

        String remainString = string.substring( 0, len % string.length() );

        while ( noOfFullStrings-- > 0 )
            System.out.print( string );

        System.out.println( remainString );
    }*/
}
