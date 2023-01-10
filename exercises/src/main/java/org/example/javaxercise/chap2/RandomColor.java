package org.example.javaxercise.chap2;

public class RandomColor {
    public static void main(String[] args) {
        int randomColor = (int) (Math.random() * 3 + 1); // 1 <= X < 4, from 1 (inclusive) to 3 (exclusive)
        String color;

        // if-else (rng < 1./3)
        color = switch (randomColor) {
            case 1 -> "red";
            case 2 -> "green";
            default -> "blue";
        };

        System.out.printf("<circle cx=\"20\" cy=\"20\" r=\"5\" fill=\"%s\" />%n", color);
        System.out.println("random color: " + randomColor);
    }
}
