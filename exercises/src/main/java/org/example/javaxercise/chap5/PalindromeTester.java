package org.example.javaxercise.chap5;

import java.util.Scanner;

// Zeichenketten
// [^a-zA-Z0-9]
// replace
// trim
// reuse code
// regex
// pattern
public class PalindromeTester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String test;
        System.out.println("Enter string to test for palindrome: ");
        test = sc.nextLine();

        System.out.println(isPalindrome(test));
        System.out.println(isPalindromeIgnoringCase(test));

        // »Pepe in Tahiti hat nie Pep« oder »Sei fies – stets sei fies!«
        System.out.println("»A man a plan a canal Panama« ");
        System.out.println(isPalindromeIgnoringNonLettersAndDigits("»A man a plan a canal Panama« "));
    }

    public static boolean isPalindrome(String s) {

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i) ) {
                return false;
            }
        }

        return true;
    }

    // reuse the code!!!!
    public static boolean isPalindromeIgnoringCase(String s) {
        s = s.toLowerCase();
//        return isPalindrome(s);

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i) ) {
                return false;
            }
        }

        return true;
    }

    // replaceAll("[^a-zA-Z0-9]", "")
//    This takes advantage of the negation (^) operator in character classes which basically says, "match everything except the following characters."
    // different from the solution and didn't use "Character.isLetterOrDigit(char)"
    public static boolean isPalindromeIgnoringNonLettersAndDigits(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").trim();
//        return isPalindromeIgnoringCase(s); // reusing code is better!!!
        s = s.toLowerCase();
        System.out.println(s);

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i) ) {
                return false;
            }
        }

        return true;
    }
}

// solution
/*
//tag::solution[]
public static boolean isPalindrome( String string ) {

    for ( int index = 0; index < string.length() / 2; index++ ) {
        char frontChar = string.charAt( index );
        char backChar  = string.charAt( string.length() - index - 1 );
        if ( frontChar != backChar )
            return false;
    }
    return true;
}

    public static boolean isPalindromeIgnoringCase( String string ) {
        return isPalindrome( string.toLowerCase() );
    }

    public static boolean isPalindromeIgnoringNonLettersAndDigits(String string) {

        for ( int startIndex = 0, endIndex = string.length() - 1;
              startIndex < endIndex;
              startIndex++, endIndex-- ) {
            while ( ! Character.isLetterOrDigit( string.charAt( startIndex ) ) )
                startIndex++;
            while ( ! Character.isLetterOrDigit( string.charAt( endIndex ) ) )
                endIndex--;

            char frontChar = Character.toLowerCase( string.charAt( startIndex ) );
            char backChar  = Character.toLowerCase( string.charAt( endIndex ) );
            if ( frontChar != backChar )
                return false;
        }
        return true;
    }

    public static boolean isPalindromeRecursive( String string ) {

        if ( string.length() < 2 )
            return true;

        if ( string.charAt( 0 ) != string.charAt( string.length() - 1 ) )
            return false;

        return isPalindromeRecursive( string.substring( 1, string.length() - 1 ) );
    }
    //end::solution[]

    //  public static boolean isPalindrome( String s ) {
    //    String reversed = "";
    //
    //    for ( int i = s.length() - 1; i >= 0; i-- )
    //      reversed += s.charAt( i );
    //
    //    return reversed.equals( s );
    //  }

    public static void main( String[] args ) {
        System.out.println( isPalindrome( "otso" ) );
        System.out.println( isPalindromeIgnoringCase( "Otto" ) );
        System.out.println( isPalindromeIgnoringNonLettersAndDigits( "Ott o" ) );
        System.out.println( isPalindromeIgnoringNonLettersAndDigits( "Sei fies â€“ stets sei fies!" ) );
        System.out.println( isPalindromeIgnoringNonLettersAndDigits( "Pepe in Tahiti hat nie Pep" ) );
        System.out.println( isPalindromeIgnoringNonLettersAndDigits( "" ) );
        System.out.println( isPalindromeIgnoringNonLettersAndDigits( "1" ) );
        System.out.println( isPalindromeIgnoringNonLettersAndDigits( "11" ) );
        System.out.println( isPalindromeIgnoringNonLettersAndDigits( "112" ) );
        System.out.println( isPalindromeRecursive( "otto" ) );

        boolean isPalindrome = new StringBuilder( "otto" ).reverse().toString().equals( "otto" );
        System.out.println( isPalindrome );
    }*/
