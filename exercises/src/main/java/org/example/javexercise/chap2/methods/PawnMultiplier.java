package org.example.javexercise.chap2.methods;

// methods
// recursion / Rekursion
public class PawnMultiplier {
    // only +, +, /2, *2
    // Produkt = Multiplikation von Faktoren
    // Produkt = Multiplikator * Multiplikant
    // a * b = (a/2) x (2*b)
    // Multiplikator = 1? Dann haben wir das Ergebnis erreicht
    // (a - 1) × b + b (ungerade Zahlen)

    // Rekursion für die Methode / Algorithmus verwenden
        /*Die Summe 6 + 12 + 48 ergibt 66, und das ist 22 × 3. Verschachtelt geschrieben:
        22 × 3 = 11 × 6 = (10 × 6) + 6 = ((4 × 12) + 12) + 6 = ((48) + 12) + 6 = 66.*/

    public static void main(String[] args) {

//        System.out.println(multiply(8, 7));
//        System.out.println(multiply(11, 6));
        System.out.println(multiply(65, 17));
    }

    static long multiply(long n1, long n2) {
//        long result = n2;
        long rest = 0;

        // as long this is not 1, if 1 then return result (which is n2)
        if (n1 > 1) {
            if (n1 % 2 == 0 ) { // even
                System.out.printf("Multiplikator: %d | Multiplikant: %d%n", n1, n2);
                return multiply(n1 / 2, n2 * 2);
            } else { // uneven
                n1 -= 1;
                rest += n2;
                System.out.printf("Multiplikator: %d | Multiplikant: %d%n", n1, n2);
                System.out.println("Rest to add later: " + rest); // rest will be added with the returned result
                return multiply(n1 / 2, n2 * 2) + rest;
            }
            /*else {
                return result;
            }*/
        }
/*
        if (n1 % 2 == 0) {
            for (long first = n1, second = n2; first > 0; first /= 2, second *= 2) {
                System.out.printf("Multiplikator: %d | Multiplikant: %d%n", first, second);
                result = second;
            }
        } else {
            n1 -= 1;
            for (long first = n1, second = n2; first > 0; first /= 2, second *= 2) {
                System.out.printf("Multiplikator: %d | Multiplikant: %d%n", first, second);
                result = second;
            }
            result += n2;
        }
*/
/*        if (n1 % 2 == 0) {

        }*/
/*        else {
            n1 -= 1;
            for (long first = n1, second = n2; first > 0; first /= 2, second *= 2) {
                System.out.printf("Multiplikator: %d | Multiplikant: %d%n", first, second);
                result = second;
            }
            result += n2;
        }*/
        // in the end, once n1 is 1, print 1 and the result
        System.out.printf("Multiplikator: %d | Multiplikant: %d%n", n1, n2);
//        return result;
        return n2;
    }
}
