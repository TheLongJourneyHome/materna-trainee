package org.example.javexercise.chap2;

// for-loop
public class MathPhenomenonAlwaysEnding {
    public static void main(String[] args) {
        double t = Math.random() * 10;

        while (t > 0) {
            System.out.println(t);
            if (t < 1) {
                t *= 2;
            } else {
                t -= 1;
            }
        }
    }
}
