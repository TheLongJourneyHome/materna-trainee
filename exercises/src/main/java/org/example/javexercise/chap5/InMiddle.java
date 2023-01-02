package org.example.javexercise.chap5;

// Zeichenketten
// \t -> tab sequence -> 1 string length
// compare strings
// region matches
public class InMiddle {
    public static void main(String[] args) {
/*        System.out.println("\tCiaoCiao ");
        System.out.println("HelloWorld".length());
        System.out.println("\t".length());
        System.out.println("Hello\tWorld".length());
        System.out.println("".length());*/
        isCiaoCiaoInMiddle("CiaoCiao"); // → true

        isCiaoCiaoInMiddle("!CiaoCiao!"); // → true

        isCiaoCiaoInMiddle("SupaCiaoCiaoCute"); // → true

        isCiaoCiaoInMiddle("x!_CiaoCiaoabc"); // → true

        isCiaoCiaoInMiddle("\tCiaoCiao "); // → true

        isCiaoCiaoInMiddle("BambooCiaoCiaoBlop"); // → false

        isCiaoCiaoInMiddle("Bernie und Ert"); // → false
    }

    public static boolean isCiaoCiaoInMiddle(String s) {
        if (!s.contains("CiaoCiao")) {
            System.out.println(s);
            System.out.println(false);
            System.out.println();
            return false;
        }

//        boolean ciaoInMiddle = false; // save it here, so we check the whole string and don't return too early, so CiaoCiaoCiaoCiao is also true!
        String ciaoCiao = "";

        // check string until found 'C' of CiaoCiao
        for (int i = 0; i < s.length(); i++) {

            // save the 7 next characters to a string and see if it is "CiaoCiao"
            // if it's not C or the remaining length is not enough, continue until the loop is over
            // only then do the next task
            if (s.charAt(i) == 'C' && i + 7 < s.length()) {
                for (int j = i; j < i+7 +1; j++) {
                    ciaoCiao += s.charAt(j);
                }
                System.out.println(ciaoCiao);
                // we found CiaoCiao
                if (ciaoCiao.equals("CiaoCiao")) {
                    // when 'oC' in the middle, then it's in the middle -> true
                    System.out.println("Testing");
                    System.out.println(s.charAt(i+3));
                    System.out.println(s.charAt(s.length() / 2 -1));
                    System.out.println(s.charAt(i+4));
                    System.out.println(s.charAt(s.length() / 2));

                    if (s.charAt(i+3) == s.charAt(s.length() / 2 -1) && s.charAt(i+4) == s.charAt(s.length() / 2)) {
                        System.out.println(true);
                        System.out.println();
                        return true;
                    }
                }
            }

            ciaoCiao = ""; // reset for next char check
        }

        System.out.println(false);
        System.out.println();
        return false;
    }
}

// solution with regionMatches
/*
//tag::solution[]
public static boolean isStringInMiddle( String string, String middle ) {

    if ( middle.length() > string.length() )
        return false;

    int start = string.length() / 2 - middle.length() / 2;
    return string.regionMatches( start, middle, 0 // middle offset, middle.length() );
}

    public static boolean isCiaoCiaoInMiddle( String string ) {
        return isStringInMiddle( string, "CiaoCiao" );
    }
    //end::solution[]

    public static void main( String[] args ) {
        System.out.println( isCiaoCiaoInMiddle( "CiaoCiao" ) );
        System.out.println( isCiaoCiaoInMiddle( "!CiaoCiao!" ) );
        System.out.println( isCiaoCiaoInMiddle( "SupaCiaoCiaoCute" ) );
        System.out.println( isCiaoCiaoInMiddle( "x!_CiaoCiaoabc" ) );
        System.out.println( isCiaoCiaoInMiddle( "\t\tCiaoCiao  " ) );
        System.out.println( isCiaoCiaoInMiddle( "BambooCiaoCiaoBlop" ) );
        System.out.println( isCiaoCiaoInMiddle( "BabyTigerChristine" ) );
    }*/
