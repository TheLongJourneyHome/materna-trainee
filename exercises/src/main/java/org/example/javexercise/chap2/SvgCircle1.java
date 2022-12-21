package org.example.javexercise.chap2;

public class SvgCircle1 {
    public static void main(String[] args) {
//        <svg height='400' width='1000'><circle cx='100' cy='100' r='50' /></svg>
        System.out.printf("""
                <svg height='400' width='1000'><circle cx='100' cy='100' r='50' /></svg>
                """);
        System.out.println("<svg height='400' width='1000'><circle cx='100' cy='100' r='50' /></svg>");
        System.out.print("<svg height='400' width='1000'><circle cx='100' cy='100' r='50' /></svg>\n");
        System.out.printf("<svg height='400' width='1000'><circle cx='100' cy='100' r='50' /></svg>%n");
        System.out.println("Test");
        System.out.println();

        System.out.println("<svg height='400' width='1000'>");
        System.out.println("    <circle cx='100' cy='100' r='50' />");
        System.out.println("</svg>");
        System.out.println();

        System.out.printf("""
                <svg height='400' width='1000'>
                    <circle cx='100' cy='100' r='50' />
                </svg>
                """);
        System.out.println();

        System.out.printf("<svg height='400' width='1000'>%n" +
                "   <circle cx='100' cy='100' r='50' />%n" +
                "</svg>%n");
        System.out.println();
        System.out.print("\n");

        // replace ' with "
        System.out.println("<svg height=\"400\" width=\"1000\">");
        System.out.println("    <circle cx=\"100\" cy=\"100\" r=\"50\" />");
        System.out.println("</svg>");
        System.out.println();

        System.out.printf("""
                <svg height="400" width="1000">
                    <circle cx="100" cy="100" r="50" />
                </svg>
                """);
        System.out.println();

        System.out.printf("<svg height=\"400\" width=\"1000\">%n" +
                "   <circle cx=\"100\" cy=\"100\" r=\"50\" />%n" +
                "</svg>%n");
        System.out.println();
    }
}
