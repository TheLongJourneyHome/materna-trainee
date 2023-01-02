package org.example.javexercise.chap5.stringbuilder;

// strinbguilder
// character addition -> ABCZ
// typecasting
// append
public class Caesar {

    public static void main(String[] args) {
/*        Scanner sc = new Scanner(System.in);
        int displacementNumber;
        System.out.println("Enter number of displacement: ");
        displacementNumber = sc.nextInt();*/

//        caesar("abxyz. ABXYZ!", 13); // → "noklm. NOKLM!"
        System.out.println(caesar("abxyz. ABXYZ!", 13));

//        decaesar(caesar("abxyz. ABXYZ!", 13), 13); // → "abxyz. ABXYZ!"
        System.out.println(decaesar(caesar("abxyz. ABXYZ!", 13), 13));

        /*
        // testing for understanding
        System.out.println(Character.isLowerCase('B'));
        System.out.println((char) 65); // from hashcode to character
        System.out.println('A');
        System.out.println(Character.hashCode('A')); // from character to hashcode
        System.out.println((char) ('A' + 26)); // -> [, 25 = Z
        System.out.println('a');
        System.out.println((char) ('a' + 26)); // -> {, 25 = z
        */


    }

    // from a-z ot A-Z, when we do the addition and it passes Z -> new method -> iterate "rotation" numbe of times and count where the addition would pass Z (but only when its greate Z the value -> result int that we can count from beginning again

    public static String caesar(String toEncrypt, int rotation) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < toEncrypt.length(); i++) {
            result.append(encrypt(toEncrypt.charAt(i), rotation));
        }
//        System.out.println(result.toString());
        return result.toString();
    }

    public static String decaesar(String toDecrypt, int rotation) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < toDecrypt.length(); i++) {
            result.append(decrypt(toDecrypt.charAt(i), rotation));
        }
//        System.out.println(result.toString());
        return result.toString();
    }

    public static Character encrypt(Character c, int rotation) {
        char encrypt = (char) (c + rotation);

        /*if (encrypt <= 'z' || encrypt <= 'Z') {
            return c; // only return the addition of the string if not z or Z passed after the addition
        }*/

        // when uppercase check for Z
        if (Character.isUpperCase(c)) {

            if (encrypt <= 'Z') {
                return encrypt;
            } else {
                int counter = 0;
                for (int i = 1; i <= rotation; i++) {
                    // count how many times it's bigger than 'Z'
                    if ((char)(c + i) > 'Z') {
                        counter++;
                    }
                }
                // add the remaining jump increments (counter) to the beginning of A again
                return (char) ('A' + counter - 1); // counter -1 because A is already 1 jump increment
            }

        } else if (Character.isLowerCase(c)) {

            if (encrypt <= 'z') {
                return encrypt;
            } else {
                int counter = 0;
                for (int i = 1; i <= rotation; i++) {
                    // count how many times it's bigger than 'Z'
                    if ((char)(c + i) > 'z') {
                        counter++;
                    }
                }
                return (char) ('a' + counter - 1);
            }

        } else { // is digit, or special character
            return c;
        }
    }

    public static Character decrypt(Character c, int rotation) {
        char decrypt = (char) (c - rotation);


        if (Character.isUpperCase(c)) {

            if (decrypt >= 'A') {
                return decrypt;
            } else {
                int counter = 0;
                for (int i = 1; i <= rotation; i++) {
                    if ((char)(c - i) < 'A') {
                        counter++;
                    }
                }
                return (char) ('Z' - (counter - 1));
            }

        } else if (Character.isLowerCase(c)) {

            if (decrypt >= 'a') {
                return decrypt;
            } else {
                int counter = 0;
                for (int i = 1; i <= rotation; i++) {
                    if ((char)(c - i) < 'a') {
                        counter++;
                    }
                }
                return (char) ('z' - (counter - 1));
            }

        } else {
            return c;
        }
    }
}



// solution
/*
public class CaesarCipher {

    //tag::solution-1[]
    public static final int ALPHABET_LENGTH = 26;

    private static int rotate( int c, int rotation ) {
        if ( rotation < 0 )
            throw new IllegalArgumentException(
                    "rotation is not allowed to be negative, but was " + rotation );

        if ( c >= 'A' && c <= 'Z' )   // Character.isUpperCase( c ) is too broad
            return 'A' + (c - 'A' + rotation) % ALPHABET_LENGTH;
        else if ( c >= 'a' && c <= 'z' )
            return 'a' + (c - 'a' + rotation) % ALPHABET_LENGTH;
        else
            return c;
    }
    //end::solution-1[]

    //tag::solution-2[]
    public static String caesar( String s, int rotation ) {
        StringBuilder result = new StringBuilder( s.length() );

        for ( int i = 0; i < s.length(); i++ )
            result.append( (char) rotate( s.charAt( i ), rotation ) );

        return result.toString();

        // Freaky solution
        // IntUnaryOperator rotation = c -> rotate( c, rotation );
        // return s.chars().map( rotation ).mapToObj( Character::toString )
        //         .collect( Collectors.joining() );
    }

    public static String decaesar( String s, int rotation ) {
        return caesar( s, ALPHABET_LENGTH - rotation );
    }
    //end::solution-2[]

    public static void main( String[] args ) {
        System.out.println( (char) rotate( 'A', 0 ) );
        System.out.println( (char) rotate( 'A', 1 ) );
        //    System.out.println( (char) rotate( 'A', -1 ) );

        char rotation = 13;
        String s = "abxyz. ABXYZ!";
        System.out.println( s );
        System.out.println( caesar( s, rotation ) );
        System.out.println( decaesar( caesar( s, rotation ), rotation ) );
    }
}*/
