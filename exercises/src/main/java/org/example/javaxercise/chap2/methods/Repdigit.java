package org.example.javaxercise.chap2.methods;

// methods
// understand
// explain
public class Repdigit {
    public static void main(String[] args) {
        System.out.println(isRepdigit(99));

        System.out.println(isRepdigit(888));
        System.out.println(isRepdigit(998));
        System.out.println(isRepdigit(899));
        System.out.println(isRepdigit(9));
    }

    static boolean isRepdigit( long n ) {
        if ( (n % 100) / 10 != n % 10 )
            return n < 10;
        return isRepdigit( n / 10 );
    }
    // 999
    // if 99 / 10 != 9 -> if 9 != 9 -> return true/false
    // compared tens and ones
    // if it's just within tens (0-9) then return true
    // if the compared number tens and ones are not the same, return n < 10
    // we know if the number is within then it's already true, but if we enter return the number with a number >= 10 then it's false (entered cuz digits are not the same)
    // we loop it til we compared the numbers next to each other, until it reaches ones (0-9)

    // 8997 -> 97 /10 != 7 -> 9 != 7 -> true, return the whole number in the beginning 8997 < 10 -> false
    // 988 -> 88 /10 != 8 -> 8 != 8 -> false, repeat the loop with number in the beginning /10 -> isRepdigit (988/10) -> isRepdigit (98)
        // 98 % 100 = 98 -> 98 /10 != 8 -> 9 != 8 - true -> 98 < 10
    // 77 -> 77 % 100 = 77 -> 77 /10 != 7 -> 7 != 7 -> false -> repeat again with 7
        // 7 % 100 = 7 -> 7/10 != 7 -> 0 != 7 -> true -> return 7 < 10 -> TRUE



    /*
    if ( (n % 100) / 10 != n % 10 ) == if ( n % 100 % 11 != 0 )
        Why is this the same?
    */
    // every number with 2 or more digits that is a repdigit can be divided by 11 and returns rest 0 if that's the case
    // if the number is only 1 digit long, you enter the true condition, or if the number is more than 2 digits long and can't be divided by 11 with rest 0
        // single digit -> true, multiple digits -> false, when entered
}
