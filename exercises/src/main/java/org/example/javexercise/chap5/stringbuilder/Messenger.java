package org.example.javexercise.chap5.stringbuilder;

import java.util.Arrays;
import java.util.Objects;

// stringbuilder
// append
// whitespace
public class Messenger {
    public static void main(String[] args) {
        joinSplitMessages("Hoy", "ok"); // → "Hooky"

        joinSplitMessages("Hooky"); // → "Hooky"

        joinSplitMessages("Hk", "oy", "o"); // → "Hooky"

        joinSplitMessages("H", "", "ooky"); // → "Hooky"
    }

    public static String joinSplitMessages(String... messages) {
//        System.out.println(Arrays.toString(messages));
        StringBuilder result = new StringBuilder();
        int maxStringLength = stringMaxLength(messages);

/*        for (String message : messages) {
            message += "A".repeat(maxStringLength); // does not apply
        }*/
        for (int i = 0; i < messages.length; i++) {
//            messages[i] = messages[i] + "A".repeat(maxStringLength); // handle out of bounds (Test)
            messages[i] = messages[i] + " ".repeat(maxStringLength); // handle out of bounds (Test)
        }
//        System.out.println(Arrays.toString(messages));

        // number of repeats = biggest string length
        for (int i = 0; i < maxStringLength; i++) {

            // do it for each message in the string array
            for (String message : messages) {
                result.append(message.charAt(i));
            }

        }

        // remove all space(s)
        System.out.println(result.toString().replaceAll("\\s+", "")); // H o  o  k  y -> Hooky

        return result.toString().replaceAll("\\s+", "");
    }

    public static int stringMaxLength(String... messages) {
        Objects.requireNonNull(messages); // null check
        int maxLength = messages[0].length();

        for (String message : messages) {
            maxLength = Math.max(maxLength, message.length());
        }

        return maxLength;
    }
}

// solution
/*
public class Messenger {

    //tag::solution[]
    private static String charAtOrEmpty( String string, int index ) {
        return index < string.length() ? string.substring( index, index + 1 ) : "";
    }

    private static String joinSplitMessages( String... parts ) {
        int maxStringLength = 0;

        for ( String part : parts )
            maxStringLength = Math.max( maxStringLength, part.length() );

        StringBuilder result = new StringBuilder();
        for ( int index = 0; index < maxStringLength; index++ )
            for ( String part : parts )
                result.append( charAtOrEmpty( part, index ) );

        return result.toString();
    }
    //end::solution[]

    public static void main( String[] args ) {
        System.out.println( joinSplitMessages( "Hoy", "ok" ) ); // Hooky
        System.out.println( joinSplitMessages( "Hooky" ) ); // Hooky
        System.out.println( joinSplitMessages( "Hk", "oy", "o" ) ); // Hooky
        System.out.println( joinSplitMessages( "H", "", "ooky" ) ); // Hooky
    }
}*/
