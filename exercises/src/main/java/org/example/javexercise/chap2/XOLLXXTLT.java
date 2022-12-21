package org.example.javexercise.chap2;

// nested for-loops, check all!
// didn't solve...
// TODO 1.5.12. repeat
public class XOLLXXTLT {
    public static void main(String[] args) {

        // var l o t x
        // xol + lxx = tlt
        // digit 0-9
        // test every variable and compare with each other -> nested loops

        // 0-9 (0 inclusive, 10 exclusive=
        for (int l = 0; l < 10; l++) {
            for (int o = 0; o < 10; o++) {
                for (int t = 0; t < 10; t++) {
                    for (int x = 0; x < 10; x++) {

                        // 3rd position from right -> * 100, 2nd -> * 10 ...
                        int xol = 100 * x + 10 * o + l;
                        int lxx = 100 * l + 10 * x + x;
                        int tlt = 100 * t + 10 * l + t;

                        if (xol + lxx == tlt) {
                            System.out.printf("l = %d | o = %d | t = %d | x = %d", l, o, t , x);
                            if (
                                    l != o && l != t && l != x &&
                                    o != t && o != x &&
                                    t != x
                            ) {
                                System.out.print(" ************************************"); // mark if the result is different everywhere
                            }
                            System.out.println();
                        }

                    }
                }
            }
        }

    }

/*    public static void main(String[] args) {
        //tag::solution[]
        for (int l = 0; l < 10; l++) {
            for (int o = 0; o < 10; o++) {
                for (int x = 0; x < 10; x++) {
                    for (int t = 0; t < 10; t++) {
                        int xol = 100 * x + 10 * o + l;
                        int lxx = 100 * l + 10 * x + x;
                        int tlt = 100 * t + 10 * l + t;

                        if (xol + lxx == tlt) {
                            if ((l != o) && (l != x) && (l != t) &&
                                    (o != x) && (o != t) && (x != t))
                                System.out.print("All variables are different: ");

                            System.out.printf("l=%d, o=%d, x=%d, t=%d%n", l, o, x, t);
                        }
                    } // end for t
                } // end for x
            } // end for o
        } // end for l
        //end::solution[]
    }*/
}
