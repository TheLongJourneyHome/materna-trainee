package org.example.javaxercise.chap5;

// Zeichenketten
// substring
// charAt
// indexOf
// replace
// repeat
public class PrintUnderline {
    public static void main(String[] args) {
        String example = "There is more treasure in books than in all the pirates' loot on Treasure Island";

        System.out.println(example);
//        System.out.println(example.indexOf("ttreasure")); // -1
/*        System.out.println(example.indexOf("treasure"));
        System.out.println("treasure".length());
        System.out.println(example.substring(example.indexOf("treasure"), example.indexOf("treasure") + "treasure".length() + 2));*/


        printUnderline(example, "treasure");
    }

    public static void printUnderline(String string, String search) {
        String source = string.toLowerCase();
        String target = search.toLowerCase();
        String result = "";

        int index = source.indexOf(target);
        while (index > 0) { // || target.length() > source.length()
            String toReplace = source.substring(0, index);
//            result += toReplace.replace(source.substring(0, index), "*"); // replace substring until target position with empty spaces
            result += replaceWithSpace(toReplace);

            String replaceTarget = source.substring(index, index + target.length());
//            result += replaceTarget.replace(replaceTarget, "-"); // replace target substring until reached target length to underline
            result += underline(replaceTarget);

            source = source.substring(index + target.length()); // replace the source string with the remaining string left
            index = source.indexOf(target); // check if the target is still in string and get the index, if that's not the case -> -1
//            index = -1;
        }

        System.out.println(result);
        System.out.println(source);
    }

    public static String replaceWithSpace(String string) {
        for (int i = 0; i < string.length(); i++) {
            string = string.replace(string.charAt(i), ' ');
        }

        return string;
    }

    public static String underline(String string) {
        for (int i = 0; i < string.length(); i++) {
            string = string.replace(string.charAt(i), '-');
        }

        return string;
    }
}


// solution
/*
public static void main( String[] args ) {
    String text = "There is more treasure in books than in all the pirates' loot on Treasure Island";
    printUnderline( text, "treasure" );
}

    //tag::solution[]
    public static void printUnderline( String string, String search ) {
        System.out.println( string );

        string = string.toLowerCase();
        search = search.toLowerCase();

        String secondLine = "";
        for ( int index = 0;
              (index = string.indexOf(search, index) ) >= 0;
              index += search.length() ) {
            secondLine += " ".repeat( index - secondLine.length() ) +
                    "-".repeat( search.length() );
        }
        System.out.println( secondLine );
    }
//end::solution[]*/
