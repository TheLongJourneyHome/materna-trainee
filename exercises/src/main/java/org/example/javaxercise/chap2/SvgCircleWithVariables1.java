package org.example.javaxercise.chap2;

public class SvgCircleWithVariables1 {
    public static void main(String[] args) {
        int x = 100, y = 110;
        double r = 20.5;

        System.out.println("<svg height=\"400\" width=\"1000\">");
        System.out.println("    <circle cx=\"" + x + "\" cy=\"" + y + "\" r=\"" + r + "\" />");
        System.out.println("</svg>");
        System.out.println();

        x = 10;
        y = x;
        r = 2.686;

        System.out.printf("""
                <svg height="400" width="1000">
                    <circle cx="%d" cy="%d" r="%f" />
                </svg>
                """, x, y, r);
        System.out.println();

        x = y = 21;
        r = 3.14159265;
        // if the floating point number is too large, use %s (string)
        System.out.printf("<svg height=\"400\" width=\"1000\">%n" +
                "   <circle cx=\"%d\" cy=\"%d\" r=\"%s\" />%n" +
                "</svg>%n", x, y, r);
        System.out.println();
    }
}
