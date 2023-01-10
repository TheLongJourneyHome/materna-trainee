package org.example.javaxercise.chap6and7;

// static variables and methods
public class Tracer {

    private static boolean tracingIsOn; // = false;

    public static void trace(String string) {
        if (tracingIsOn) {
            System.out.println(string);
        }
    }

    public static void trace(String format, Object... args) {
        System.out.printf(format + "%n", args);
    }

    public static void on() {
        tracingIsOn = true;
    }

    public static void off() {
        tracingIsOn = false;
    }
}
