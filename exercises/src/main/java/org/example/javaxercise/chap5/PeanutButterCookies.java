package org.example.javaxercise.chap5;

// Zeichenketten
// String array
// contains
// !!!
public class PeanutButterCookies {
    public static void main(String[] args) {
        howManyCookies("PSESEPESP"); // 3
        howManyCookies("PPPEEESSS"); // 0
        howManyCookies("SEPEPLSEE"); // 1

        howManyCookies("PPPSESEPESP"); // 3
        // 0 1 2 3 4 5 6 7 8 (9)
        //             ^inc   ^ => String.length() exclusive index
    }

    public static int howManyCookies(String ingredients) {
        ingredients = ingredients.toLowerCase();
        int cookieAmount = 0;

        for (int i = 0; i <= ingredients.length() - 3; /*i += 3*/) {
            // i+3 when cookie made and counter up, else i+1 and check next 3
            String isCookie = ingredients.substring(i, i + 3);
            if (canMakeCookies(isCookie)) {
                cookieAmount++;
                i += 3;
            } else {
                i++;
            }
        }

        System.out.printf("\"%s\" -> %d %n", ingredients.toUpperCase(), cookieAmount);
        return cookieAmount;
    }

    public static boolean canMakeCookies(String substring) {
        String[] allCombinations = {"pse", "pes", "spe", "sep", "eps", "esp"};

        for (String isCookie : allCombinations) {
            if (substring.contains(isCookie)) {
                return true;
            }
        }
        return false;
    }
}



// solution
/*
//tag::solution[]
static void countCookies( String input ) {
    int cookies = 0;
    for ( int i = 0; i < input.length() - 2; ) {
        String triplet = input.substring( i, i + 3 );
        if ( hasRecipeIngredients( triplet ) ) {
            cookies++;
            i += 3;
        }
        else
            i++;
    }

    System.out.printf( "Cookies: %d, Ingredients remaining: %d%n",
            cookies,
            input.length() - 3 * cookies );
}

    private static boolean hasRecipeIngredients( String triplet ) {
        return triplet.length() == 3
                && triplet.contains( "P" )
                && triplet.contains( "S" )
                && triplet.contains( "E" );
    }
    //end::solution[]

    public static void main( String[] args ) {
        countCookies( "PSESEPESP" );
        countCookies( "PPPEEESSS" );
        countCookies( "SEPEPLSEE" );
    }*/
