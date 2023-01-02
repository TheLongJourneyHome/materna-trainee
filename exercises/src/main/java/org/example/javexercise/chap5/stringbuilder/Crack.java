package org.example.javexercise.chap5.stringbuilder;

// stringbuilder
// private static final variable
// insert
// delete
public class Crack {

    public static final String CRACKLE = "»♬CRACK♪«";
    public static void main(String[] args) {
        String message = "You Son Of a Biscuit Eater";
        System.out.print(message + " -> ");
        String crackledMessage = crackle(message);
        System.out.println(crackledMessage);

        System.out.println("\n Decrackle it: ");

        String decrackledMessage = decrackle(crackledMessage);
        System.out.print("-> ");
        System.out.println(decrackledMessage);
    }

    public static String crackle(String string) {
        StringBuilder crackledMessage = new StringBuilder(string);
        int randomTimes = (int) (Math.random() * string.length()); // random index of the string [0 - string.length-1]
        // at random position and random amount of time

        // random amount of time
        for (int i = 0; i < randomTimes+1; i++) {
            int randomIndex = (int) (Math.random() * string.length());
            crackledMessage.insert(randomIndex, CRACKLE);
        }

        return crackledMessage.toString();
    }

    public static String decrackle(String string) {
        StringBuilder decrackledMessage = new StringBuilder(string);
        int index = decrackledMessage.indexOf(CRACKLE);

        // while CRACKLE is found, delete it and repeat until it cannot be found anymore
        while (index > 0) {
//            System.out.println(index);
            decrackledMessage.delete(index, index + CRACKLE.length());
            index = decrackledMessage.indexOf(CRACKLE);
        }

        return decrackledMessage.toString();
    }
}


// solution
/*
public class Crack {

    //tag::solution[]
    private static final String CRACK = "â™¬CRACKâ™ª";

    public static String crackle( String string ) {
        int capacity = string.length() + string.length() * CRACK.length() / 10;
        StringBuilder result = new StringBuilder( capacity );
        result.append( string );

        for ( int i = string.length() - 1; i >= 0; i-- )
            if ( Math.random() < 0.1 )
                result.insert( i, CRACK );

        return result.toString();
    }

    public static String decrackle( String string ) {
        return string.replace( CRACK, "" );
    }
    //end::solution[]

    public static void main( String[] args ) {
        String s = "Why does it take pirates so long to learn the alphabet? "
                + "Because they can spend years at C!";
        String t = crackle( s );
        System.out.println( t );
        System.out.println( decrackle( t ) );
    }
}*/
