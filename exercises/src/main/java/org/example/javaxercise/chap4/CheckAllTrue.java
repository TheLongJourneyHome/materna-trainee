package org.example.javaxercise.chap4;

import java.util.Objects;

// Arrays
// vararg
public class CheckAllTrue {
    public static void main(String[] args) {
//        allTrue(); // no argument does not work here
        boolean test1 = allTrue(true, true, true); // true
        boolean test2 = allTrue(true); // true
        boolean test3 = allTrue(true, false); // false
//        boolean test4 = allTrue(true, null); // exception

        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test3);
    }

    public static boolean allTrue(boolean oneAnswer, boolean... answers) {
        Objects.requireNonNull(answers); // or check individually for null == (.equals for objects, == for simple types like int, long, double... null)
        for (boolean answer: answers) {
            if (!answer) {
                return false;
            }
        }

        return oneAnswer;
    }
}
