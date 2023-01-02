package org.example.javexercise.chap5;

import java.util.Objects;

// Zeichenketten
// vararg
// break
// charAt
// indexOf -> found then return index start counting from 0, else if not found then index = -1
// substring
public class ShortName {
    public static void main(String[] args) {
        shortestName("Albert Tross", "Blowfish", "Nick Olaus", "Jo Ker"); // → "Jo"
//        shortestName("eerth", "", "oko");
//        shortestName("");
//        System.out.println("ABCDEF".indexOf('G')); // -> when index not found, then -1
    }

    public static String shortestName(String... names) {
        Objects.requireNonNull(names);
        String result = "";
        boolean init = false;
        String name1 = "";
        String name2 = "";

        for (String name : names) {

            for (int i = 0; i < name.length(); i++) {
                // as long there is no single space, fill name1 with the characters, else fill name2 with the remaining characters
                if (name.charAt(i) != ' ') {
                    name1 += name.charAt(i);
//                    System.out.println(name1);
                } else {
                    for (int j = i + 1; j < name.length(); j++) {
                        name2 += name.charAt(j);
//                        System.out.println(name2);
                    }
                    break; // exit loop
                }
            }
            System.out.println(name1);
            System.out.println(name2);

            if (!init && name2.equals("")) {
                result = name1;
            } else {
                result = name1.length() > name2.length() ? name2 : name1; // when name1 longer, then take name2
            }
            init = true;

            // if there is no 2nd name in the string
            if (name2.equals("")) {
                if (name1.length() < result.length() && !name.isEmpty()) {
                    result = name1;
                }
            } else {
                String shorterNameInString = name1.length() > name2.length() ? name2 : name1;
                if (shorterNameInString.length() < result.length() && !shorterNameInString.isEmpty()) {
                    result = shorterNameInString;
                }
            }

            name1 = "";
            name2 = "";

            /*if (!init) {
                result = name;
                init = true;
            }
            if (name.length() < result.length() && !name.isEmpty()) {
                result = name;
            }*/
        }

        System.out.println();
        System.out.print("Result is: ");
        System.out.println(result);
        return result;
    }
}

// solution
/*
//tag::solution[]
private static final int INDEX_NOT_FOUND = -1;

    private static String shortest( String s1, String s2 ) {
        return s1.length() <= s2.length() ? s1 : s2;
    }

    private static String shortestName( String... names ) {

        if ( names.length == 0 )
            return "";

        String result = names[ 0 ];

        for ( String name : names ) {
            int spacePos = name.indexOf( ' ' );
            if ( spacePos == INDEX_NOT_FOUND )
                result = shortest( result, name );
            else {
                String part1 = name.substring( 0, spacePos );
                String part2 = name.substring( spacePos + 1 );
                result = shortest( result, shortest( part1, part2 ) );
            }
        }
        return result;
    }
    //end::solution[]

    public static void main( String[] args ) {
        System.out.println( shortestName( "Albert Tross", "Blowfish", "Nick Olaus", "Jo Ker" ) );
    }*/
