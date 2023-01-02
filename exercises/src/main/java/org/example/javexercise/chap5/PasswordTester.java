package org.example.javexercise.chap5;

import java.util.Scanner;
import java.util.regex.Pattern;

// Zeochenketten
// password
// pattern
// digit
// upperCase
// lowerCase
// contains
// charAt
// valueOf
public class PasswordTester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String myPassword;

        System.out.println("Please enter your password:");
        myPassword = sc.nextLine();

        isGoodPassword(myPassword);
    }

    public static boolean isGoodPassword(String password) {
        // length minimum = 10
        // Uppercase
        // Lowercase
        // digit
        // special characters -> "!@#$%^&*()-_+={}[]|\\:;'\"<>,./?~`"
/*        Note that some of the special characters may need to be escaped if they are used in a string literal in Java.
        For example, the backslash character (\) and the single and double quote characters (' and ") should be escaped with an additional backslash when used in a string literal.

        To fix the regular expression, you need to escape the backslash characters by using two backslashes (\\) instead of one.
        This will allow the backslashes to be treated as literal characters, rather than escape characters.*/

//        Pattern specialCharacterS = Pattern.compile("!@#$%^&*()-_+={}[]|\\\\:;'\"<>,./?~`"); // Error
/*        The issue is caused by the fact that the regular expression contains a range of characters between the left and right square brackets ([ and ]).
        In regular expressions, square brackets are used to define a character class, which matches any single character that is contained within the brackets.

        However, in this regular expression, the square brackets are not being used to define a character class, so they need to be escaped with a backslash (\).
        To escape the square brackets, you need to use two backslashes (\\) instead of one, because the backslash character is also used as an escape character in regular expressions.*/
//        Pattern specialCharacters = Pattern.compile("!@#$%^&*()-_+=\\{\\}\\[\\]|\\\\:;'\"<>,./?~`");
        String specialCharacters = "!@#$%^&*()-_+={}[]|\\:;'\"<>,./?~`";
        int minLength = 10;

        // when all conditions are fulfilled, the password is good
        boolean goodLength = password.length() >= minLength;
        int upperCaseChars = 0;
        int lowerCaseChars = 0;
        int digits = 0;
        int specialChars = 0;


        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                upperCaseChars++;
            } else if (Character.isLowerCase(password.charAt(i))) {
                lowerCaseChars++;
            } else if (Character.isDigit(password.charAt(i))) {
                digits++;
            } else if ( specialCharacters.contains(String.valueOf(password.charAt(i)) ) ) {
                specialChars++;
            }
        }

        System.out.printf("Reaches minimum length of %d: %s %n" +
                "Amount of uppercase characters: %d %n" +
                "Amount of lowercase characters: %d %n" +
                "Amount of digits: %d %n" +
                "Amount of special characters: %d %n %n",
                minLength, goodLength,
                upperCaseChars,
                lowerCaseChars,
                digits,
                specialChars);
        System.out.print("Your password is good: ");
        System.out.println(goodLength && upperCaseChars > 0 && lowerCaseChars > 0 && digits > 0 && specialChars > 0);

        return goodLength && upperCaseChars > 0 && lowerCaseChars > 0 &&
                digits > 0 && specialChars > 0;
    }
}


// solution
/*
//tag::solution[]
public static final int MIN_PASSWORD_LEN = 8;

    public static boolean isGoodPassword( String password ) {

        if ( password.length() < MIN_PASSWORD_LEN ) {
            System.err.println( "Password is too short" );
            return false;
        }

        if ( ! containsUppercaseLetter( password ) ) {
            System.err.println( "Must contain uppercase letters" );
            return false;
        }

        if ( ! containsLowercaseLetter( password ) ) {
            System.err.println( "Must contain lowercase letters" );
            return false;
        }

        if ( ! containsDigit( password ) ) {
            System.err.println( "Must contain a number" );
            return false;
        }

        if ( ! containsSpecialCharacter( password ) ) {
            System.err.println( "Must contain special characters like .," );
            return false;
        }

        return true;
    }

    private static boolean containsUppercaseLetter( String string ) {
        for ( int i = 0; i < string.length(); i++ ) {
            char c = string.charAt( i );
            if ( Character.isUpperCase( c ) )
                return true;
        }
        return false;
    }

    private static boolean containsLowercaseLetter( String string ) {
        for ( int i = 0; i < string.length(); i++ ) {
            char c = string.charAt( i );
            if ( Character.isLowerCase( c ) )
                return true;
        }
        return false;
    }

    private static boolean containsDigit( String string ) {
        for ( int i = 0; i < string.length(); i++ ) {
            char c = string.charAt( i );
            if ( Character.isDigit( c ) )
                return true;
        }
        return false;
    }

    private static boolean containsSpecialCharacter( String string ) {
        for ( int i = 0; i < string.length(); i++ ) {
            char c = string.charAt( i );
            if ( c == '.' || c == ',' )
                return true;
        }
        return false;
    }

    public static void main( String[] args ) {
        System.out.println( isGoodPassword( "zukurz" ) );
        System.out.println( isGoodPassword( "nurkleinbuchstaben" ) );
        System.out.println( isGoodPassword( "keineziffern" ) );
        System.out.println( isGoodPassword( "Mit0Sonderzeichen" ) );
        System.out.println( isGoodPassword( "Mit 3 Sonderzeichen .$#&" ) );
    }
//end::solution[]*/
