package org.example.javexercise.chap4;

import java.util.concurrent.ThreadLocalRandom;

// arrays
// extended for-loop
public class Windy {
    public static void main(String[] args) {
        /*
        creating array with length and other stuff
        int[] test = new int[10];
        test[0] = 1;
        */

/*        // extended for-loop
        for (int windSpeedNum : windSpeed) {
            System.out.println(windSpeedNum);
        }*/

//        int[] windSpeed = {77, 22, 11};
        int[] windSpeed = {randomNumber(0,200), randomNumber(0,200), randomNumber(0,200)}; // length 3
        int[] windDirection = {randomNumber(0, 360), randomNumber(0, 360), randomNumber(0, 360), randomNumber(0, 360)}; // length 4
        // better create a for loop method and loop < length...

        weatherForecast(windSpeed, windDirection);
    }

    static int randomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1); // max+1 because it's exclusive else
    }


    static void weatherForecast(int[] windSpeed, int[] windDirection) {
        // only print when both values from both arrays at position i are available
        for (int i = 0; i < windSpeed.length && i < windDirection.length; i++) {
            System.out.printf("Wind speed %d km/h and wind direction %d°", windSpeed[i], windDirection[i]);
            // only print ", " when array.length-1 (second to last)
            if (i < windSpeed.length-1) {
                System.out.print(", ");
            }
        }
    }
}

// solution
/*public static void main( String[] args ) {
    //tag::solution[]
    final int MAX_WIND_SPEED = 200;
    final int MAX_DEGREE     = 360;

    final int LENGTH = 5;
    int[] windSpeed     = new int[ LENGTH ];
    int[] windDirection = new int[ LENGTH ];

    for ( int i = 0; i < LENGTH; i++ ) {
        windSpeed[ i ]     = (int) (Math.random() * MAX_WIND_SPEED);
        windDirection[ i ] = (int) (Math.random() * MAX_DEGREE);
    }

    for ( int i = 0; i < LENGTH; i++ ) {
        System.out.printf( "Wind speed %d km/h and wind direction %dÂ°",
                windSpeed[ i ], windDirection[ i ] );
        if ( i != LENGTH - 1 )
            System.out.print( ", " );
    }
    //end::solution[]
}*/
