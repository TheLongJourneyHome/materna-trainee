package org.example.javaxercise.chap8;

import java.util.Objects;

// 7.3.4
// pattern variable
// fail-fast method
// pattern matching for instance of
// 1.6.5
public class Toaster {
    int capacity;
    boolean stainless;
    boolean extraLarge;

    @Override public boolean equals( Object o ) {
/*        if ( !(o instanceof Toaster) ) return false;

        Toaster toaster = (Toaster) o;
        return    capacity == toaster.capacity
                && stainless == toaster.stainless && extraLarge == toaster.extraLarge;*/
        if ( !(o instanceof Toaster toaster) ) return false;

        return    capacity == toaster.capacity
                && stainless == toaster.stainless && extraLarge == toaster.extraLarge;
    }

    @Override public int hashCode() {
        return Objects.hash( capacity, stainless, extraLarge );
    }
}

// solution
/*
class PatterVariableToasterSolution1 {
    public class Toaster {
        int capacity;
        boolean stainless;
        boolean extraLarge;

        //tag::solution1[]
        @Override public boolean equals( Object o ) {
            if ( !(o instanceof Toaster other) ) return false;

            return    capacity == other.capacity
                    && stainless == other.stainless && extraLarge == other.extraLarge;
        }
        //end::solution1[]

        @Override public int hashCode() {
            return Objects.hash( capacity, stainless, extraLarge );
        }
    }
}

class PatterVariableToasterSolution2 {
    public class Toaster {
        int capacity;
        boolean stainless;
        boolean extraLarge;

        //tag::solution2[]
        @Override public boolean equals( Object o ) {
            return    o instanceof Toaster other
                    && capacity == other.capacity
                    && stainless == other.stainless && extraLarge == other.extraLarge;

        }
        //end::solution2[]

        @Override public int hashCode() {
            return Objects.hash( capacity, stainless, extraLarge );
        }
    }
}*/
