package org.example.javexercise.chap5;

// Zeichenketten
// indexOf
// substring
// charAt
// Math.abs
public class CrewSize {
    public static void main(String[] args) {
        largerCrew("|||||-||");
        largerCrew("|-|||");
        largerCrew("|-||");
        largerCrew("|||-|||");
    }

    public static void largerCrew(String ships) {
        // missing empty check
        int hyphenPos = ships.indexOf('-');
        int pirateCrewSize;
        int raidedCrewSize;
        int difference;
        String pirateCrew = ships.substring(0, hyphenPos);
        String raidedCrew = ships.substring(hyphenPos + 1);


        pirateCrewSize = countCrewSize(pirateCrew);
        raidedCrewSize = countCrewSize(raidedCrew);
        difference = Math.abs(pirateCrewSize - raidedCrewSize);

        if (difference == 0) {
            System.out.println(ships + " => Ships had the same crew size");
        } else {
            System.out.printf("%s => %s ship had a larger crew, difference %d %n", ships, pirateCrewSize > raidedCrewSize ? "Pirate" : "Raided", difference);
        }
        System.out.println();
    }

    public static int countCrewSize(String crew) {
        int counter = 0;

        for (int i = 0; i < crew.length(); i++) {
            counter = crew.charAt(i) == '|' ? counter + 1 : counter;
        }

        System.out.println(counter);
        return counter;
    }
}

// solution
/*
//tag::solution[]
public static void printDecodedCrewSizes( String string ) {
    int index = string.indexOf( '-' );
    if ( index < 0 )
        throw new IllegalArgumentException( "Separator - is missing in " + string );
    System.out.print( string + " => " );
    int diff = 2 * index - (string.length() - 1);
    switch ( Integer.signum( diff ) ) {
        case -1 -> System.out.printf(
                "Raided ship had a larger crew, difference %d%n", -diff );
        case  0 -> System.out.println( "Ships had the same crew size" );
        case +1 -> System.out.printf(
                "Pirate ship had a larger crew, difference %d%n", diff );
    }
}
    //end::solution[]

    public static void main( String[] args ) {
        printDecodedCrewSizes( "|-|||" );
        printDecodedCrewSizes( "|-||" );
        printDecodedCrewSizes( "|||-|||" );
        printDecodedCrewSizes( "|||||-||" );
        printDecodedCrewSizes( "|||||||" );
    }*/
