package org.example.javexercise.chap4;

import java.util.Arrays;

// arrays
public class BigProfits {
    public static void main(String[] args) {
        int[] dailyGain = {1000, 2000, 500, 9000, 9010};
        System.out.println(Arrays.toString(dailyGain)); // print array -> 4.6.1 String Representation of an Array
        System.out.println(count5PercentJumps(dailyGain));

        System.out.println();

        int[] example = dailyGains(31);
        System.out.println(Arrays.toString(example));
        System.out.println(count5PercentJumps(example));

        System.out.println((1050*100) / 1000 >= 105);
    }

//    if (i + 1 < profits.length) {
    // int[5] = length 5 = int[0...4]
    // i = 3 -> i+1 = 4 -> ok
    // i = 4 -> i+1 = 5 -> int[4] already last position -> there is no next position // int[5] does not exist, even with array length of 5. we count from 0
    //
    static int count5PercentJumps(int[] profits) {
//        double minIncrease = 1.05; // 5%
        int minIncrease = 105; // *100
        int counter = 0;
        for (int i = 0; i < profits.length; i++) {
            if (i + 1 < profits.length) {
                counter = (((profits[i + 1]*100) / profits[i]) >= minIncrease) ? counter + 1 : counter;
            }
        }

        return counter;
    }

    static int[] dailyGains(int length) {
        int[] dailyGain = new int[length];

        for (int i = 0; i < length; i++) {
            dailyGain[i] = (int) (Math.random() * 10_000);
        }

        return dailyGain;
    }
}
