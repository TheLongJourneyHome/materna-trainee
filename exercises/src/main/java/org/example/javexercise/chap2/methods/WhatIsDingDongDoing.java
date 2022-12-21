package org.example.javexercise.chap2.methods;

// methods
// understand
// explain
// improve code
public class WhatIsDingDongDoing {
    public static void main(String[] args) {
        System.out.println(ding(9876));
        System.out.println(ding2(9876));

        System.out.println(ding(987654));
        System.out.println(ding2(987654));

    }

    static long ding( long dong ) {
        return dong == 0 ? 0
                : (dong % 10 + ding( dong / 10 ));
    }
    // give in a number (long)
    // check if it's 0, if it's 0 then return 0
    // if not check the rest of the number dividing with 10 and add it with the number but divided by 10 (9876 -> 987)
        // see example

    // example 9876
    /*
    9876 -> 6 +
    (987 -> 7 +
    (98 -> 8 +
    (9 -> 9 +
    0 ) ) ) -> 30
    * */
    // it adds all the digits together
    // hard to read, better this way
    static long ding2( long dong ) {
        int result = 0;
        for (; dong > 0; dong /= 10) {
            result += dong % 10;
        }
        return result;
    }
}
