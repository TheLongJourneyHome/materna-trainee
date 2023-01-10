package org.example.javaxercise.chap2.methods;

import java.util.Scanner;

// methods, HTML
// https://jsfiddle.net/
public class MultiplicationTable {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int repeats;

        System.out.println("Enter amount of quantity, but must be greater than zero: ");
        repeats = sc.nextInt();

        if (repeats > 0) {
            createHtmlTagBegin();
            tableTagBegin();
            tableHeader();
            tableInner(repeats);
            tableTagEnd();
            createHtmlTagEnd();
        } else {
            System.out.println("Quantity must be greater than zero!");
        }
    }

    static void createHtmlTagBegin() {
        System.out.println("<html>");
    }
    static void createHtmlTagEnd() {
        System.out.println("</html>");
    }


    static void tableTagBegin() {
        System.out.println("    <table>");
    }
    static void tableTagEnd() {
        System.out.println("    </table>");
    }

    static void tableHeader() {
        System.out.println("        <tr><th>Quantity</th><th>Flamethrower</th><th>Fire extinguisher</th></tr>");
    }

    static void tableInner(int repeats) {

        for (int i = 1; i <= repeats; i++) {

            int flamethrower = 500;
            int fireExtinguisher = 100;
            int quantity = 1;

            flamethrower *= i;
            fireExtinguisher *= i;
            quantity *= i;

            System.out.printf("           <tr><td>%d</td><td>%d</td><td>%d</td></tr>%n", quantity, flamethrower, fireExtinguisher);
        }
    }
}

// solution
/*
public class MultiplicationTable {

    //tag::solution[]
    private static void startTable() { System.out.println( "<table>" ); }

    private static void endTable() { System.out.println( "</table>" ); }

    private static void startRow() { System.out.print( "<tr>" ); }

    private static void endRow() { System.out.println( "</tr>" ); }

    private static void headerCell( String value ) {
        System.out.print( "<th>" + value + "</th>" );
    }

    private static void dataCell( String value ) {
        System.out.print( "<td>" + value + "</td>" );
    }

    private static void dataCell( int value ) {
        dataCell( Integer.toString( value ) );
    }

    public static void main( String[] args ) {
        final int BASE_PRICE_FLAMETHROWER      = 500;
        final int BASE_PRICE_FIRE_EXTINGUISHER = 100;

        startTable();

        startRow();
        headerCell( "Quantity" );
        headerCell( "Flamethrower" );
        headerCell( "Fire extinguisher" );
        endRow();

        for ( int i = 1; i <= 10; i++ ) {
            startRow();
            dataCell( i );
            dataCell( BASE_PRICE_FLAMETHROWER * i );
            dataCell( BASE_PRICE_FIRE_EXTINGUISHER * i );
            endRow();
        }

        endTable();
    }
    //end::solution[]
}*/
