package org.example.javexercise.chap4;

// Arrays
// vararg
// variable argument lists
public class SvgVarargPolygon {
    public static void main(String[] args) {
        printSvgPolygon(200, 10, 250, 190, 160, 210);
        printSvgPolygon(); // no argument is ok here, but not in allTrue() exercise
    }

    // error if input of arguments is uneven
    public static void printSvgPolygon(int... args) {
        String result = "<polygon points=\"";
        if (args.length % 2 == 0) {
            // -1 -> second to last argument
            for (int i = 0; i < args.length-1; i += 2) {
                result += args[i];
                result += ",";
                result += args[i + 1];
                result += " ";
            }
            result += "\" />";
            System.out.println(result);
        } else {
            System.out.println("Error number of arguments must be even!");
        }
    }
}
