package org.example.javaxercise.chap2;

public class SvgCircleWithRandomRadius {
    public static void main(String[] args) {
        double rnd = Math.random(); // Math.random() = (0.0 ... 1.0)

        int x = 100, y = 110;
        double r = (rnd * 10) + 10; // 10 <= r < 20

        System.out.printf("<svg height=\"400\" width=\"1000\">%n" +
                "   <circle cx=\"%d\" cy=\"%d\" r=\"%s\" />%n" +
                "</svg>%n", x, y, r);
        System.out.println();
    }
}
