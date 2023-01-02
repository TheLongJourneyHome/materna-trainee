package org.example.javexercise.chap5;

import java.util.Scanner;

// Zeichenketten
// concat
public class YZswapper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        printSwappedYZ("yootaxz");
        printSwappedYZ("Yanthoxzl");
        System.out.println();

/*        String test = "test";
        System.out.println(test);
        test = test.concat("TTT");
        System.out.println(test);*/

        System.out.println("Enter your test string: ");
        String testString = sc.nextLine();
        printSwappedYZ(testString);

        System.out.println();
        System.out.println("With switch case: ");
        printSwappedYZSwitch(testString);
        printSwappedYZSwitch("yootaxz");
        printSwappedYZSwitch("Yanthoxzl");

    }

    public static void printSwappedYZ(String string) {
        String swapped = "";

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'y') {
                swapped += "z";
            } else if (string.charAt(i) == 'Y') {
                swapped += "Z";
            } else if (string.charAt(i) == 'z') {
                swapped += "y";
            } else if (string.charAt(i) == 'Z') {
                swapped += "Y";
            } else {
                swapped += string.charAt(i);
            }
        }

        System.out.println(swapped);
    }

//    s1.concat("is immutable"); -> wrong
//    s1=s1.concat(" is immutable so assign it explicitly"); -> correct
    public static void printSwappedYZSwitch(String string) {
        String swapped = "";

        for (int i = 0; i < string.length(); i++) {;
            // need swapped = swapped.concat, just swapped.concat is not enough
            swapped = swapped.concat(
                    switch (string.charAt(i)) {
                        case 'y' -> "z";
                        case 'Y' -> "Z";
                        case 'z' -> "y";
                        case 'Z' -> "Y";
                        default -> String.valueOf(string.charAt(i));
                    }
            );
        }

        System.out.println(swapped);
    }
}

// solutions
/*
//tag::solution-a[]
static void printSwappedYZ1( String string ) {
    for ( int i = 0; i < string.length(); i++ ) {
        char c = string.charAt( i );
        if ( c == 'y' ) c = 'z';
        else if ( c == 'z' ) c = 'y';
        else if ( c == 'Y' ) c = 'Z';
        else if ( c == 'Z' ) c = 'Y';
        System.out.print( c );
    }
}
    //end::solution-a[]

    //tag::solution-b[]
    static void printSwappedYZ2( String string ) {
        for ( int i = 0; i < string.length(); i++ ) {
            switch ( string.charAt( i ) ) {
                case 'y': System.out.print( 'z' ); break;
                case 'z': System.out.print( 'y' ); break;
                case 'Y': System.out.print( 'Z' ); break;
                case 'Z': System.out.print( 'Y' ); break;
                default:  System.out.print( string.charAt( i ) );
            }
        }
    }
    //end::solution-b[]

    //tag::solution-c[]
    static void printSwappedYZ3( String string ) {
        for ( int i = 0; i < string.length(); i++ ) {
            char c = string.charAt( i );
            System.out.print( c == 'y' ? 'z' :
                    c == 'Y' ? 'Z' :
                            c == 'z' ? 'y' :
                                    c == 'Z' ? 'Y' :
                                            c );

        }
    }
    //end::solution-c[]

    //tag::solution-d[]
    static void printSwappedYZ4( String string ) {
        char[] c = string.toCharArray();
        for ( int i = 0; i < c.length; i++ ) {
            if ( c[ i ] == 'y' ) c[ i ] = 'z';
            else if ( c[ i ] == 'z' ) c[ i ] = 'y';
            else if ( c[ i ] == 'Y' ) c[ i ] = 'Z';
            else if ( c[ i ] == 'Z' ) c[ i ] = 'Y';
        }
        String result = new String( c );
        System.out.print( result );
    }
    //end::solution-d[]

    //tag::solution-e[]
    static void printSwappedYZ5( String string ) {
        for ( int i = 0; i < string.length(); i++ ) {
            switch ( string.charAt( i ) ) {
                case 'y' -> System.out.print( 'z' );
                case 'z' -> System.out.print( 'y' );
                case 'Y' -> System.out.print( 'Z' );
                case 'Z' -> System.out.print( 'Y' );
                default  ->  System.out.print( string.charAt( i ) );
            }
        }
    }
    //end::solution-e[]

    //tag::solution-f[]
    static void printSwappedYZ6( String string ) {
        for ( int i = 0; i < string.length(); i++ ) {
            System.out.print(
                    switch ( string.charAt( i ) ) {
                        case 'y' -> 'z'; case 'Y' -> 'Z';
                        case 'z' -> 'y'; case 'Z' -> 'Y';
                        default  -> string.charAt( i );
                    } );
        }
    }
    //end::solution-f[]

    public static void main( String[] args ) {
        printSwappedYZ1( "yYzZ" );
        System.out.println();
        printSwappedYZ2( "yYzZ" );
        System.out.println();
        printSwappedYZ3( "yYzZ" );
        System.out.println();
        printSwappedYZ4( "yYzZ" );
        System.out.println();
        printSwappedYZ5( "yYzZ" );
        System.out.println();
        printSwappedYZ6( "yYzZ" );
        System.out.println();
    }*/
