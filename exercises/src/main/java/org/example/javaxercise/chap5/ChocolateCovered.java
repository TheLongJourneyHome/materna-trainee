package org.example.javaxercise.chap5;

// Zeichenketten
// substring
// array
// extended for loop
// split
// indexOf
// charAt
// String.length
// private static variable outside of methods, private static final String
public class ChocolateCovered {

//    private static final String FRUIT = "F";
    public static void main(String[] args) {
        String fruit = "ddddd\n" +
                "dhhhd\n" +
                "dhFhd\n" +
                "dhhhd\n" +
                "ddddd";

//        checkChocolate(fruit);
        System.out.println(checkChocolate(fruit));
        System.out.println();

        System.out.println(checkChocolate("F"));
    }

    public static boolean checkChocolate(String isChocolateFruit) {

        // if only 'F' exists, then return false
        if (isChocolateFruit.length() < 3) {
            return false;
        }

        System.out.println(isChocolateFruit);
        System.out.println(isChocolateFruit.indexOf('F')); // -> 14 index of 'F' (with line breaks)

        // in case the string has line breaks, transform it into a string without line breaks
        String checkChocolateFruit = "";
        String[] oneLines = isChocolateFruit.split("\n");
        for (String oneLine : oneLines) {
            checkChocolateFruit += oneLine;
        }

        System.out.println(checkChocolateFruit);
        System.out.println(checkChocolateFruit.indexOf('F')); // -> 12 (without line breaks)

        System.out.println(checkChocolateFruit.charAt((checkChocolateFruit.length() / 2)));
        System.out.println(checkChocolateFruit.charAt((checkChocolateFruit.length() / 2)) == 'F');

        // if the index in the middle is not a Fruit, then return false
        if (checkChocolateFruit.charAt((checkChocolateFruit.length() / 2)) != 'F') {
            return false;
        }

        // left and right needs to be symmetrical
        String firstChocolateHalf = checkChocolateFruit.substring(0, checkChocolateFruit.indexOf('F')); // first chocolate half
        System.out.println(firstChocolateHalf);
        String secondChocolateHalf = checkChocolateFruit.substring(checkChocolateFruit.indexOf('F') + 1); // second half
        System.out.println(secondChocolateHalf);

        if (firstChocolateHalf.length() != secondChocolateHalf.length()) {
            return false;
        }

        // check if mirrored chocolate is the same
        for (int i = 0; i < firstChocolateHalf.length(); i++) {
            System.out.printf("index i: %d %n" +
                    "first choc char = %s && second choc char = %s %n %n", i, firstChocolateHalf.charAt(i), secondChocolateHalf.charAt((secondChocolateHalf.length() - 1) - i));
            if (firstChocolateHalf.charAt(i) != secondChocolateHalf.charAt((secondChocolateHalf.length() - 1) - i)) {
                return false;
            }
        }

        return true;
    }
}

// solution
// recursion
/*
public class ChocolateCovered {

    //tag::solution[]
    private static final String FRUIT = "F";

    public static boolean checkChocolate( String string ) {
        return checkChocolate( string, 0 );
    }

    private static boolean checkChocolate( String string, int layer ) {

        if ( string.isEmpty() )
            return false;

        if ( string.length() == 1 )
            return string.equals( FRUIT ) && layer != 0;

        if ( string.charAt( 0 ) != string.charAt( string.length() - 1 ) )
            return false;

        return checkChocolate( string.substring( 1, string.length() - 1 ),
                layer + 1 );
    }
    //end::solution[]

    public static void main( String[] args ) {
        System.out.println( checkChocolate( "dhFhd" ) );
        System.out.println( checkChocolate( "dhXhd" ) );
        System.out.println( checkChocolate( "dhFhdd" ) );
        System.out.println( checkChocolate( "F" ) );
        System.out.println( checkChocolate( "" ) );
    }
}*/
