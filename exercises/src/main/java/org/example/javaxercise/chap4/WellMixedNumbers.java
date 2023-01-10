package org.example.javaxercise.chap4;

// Arrays
// extended for-loop
// reusing code
// could optimize the code (the last part of it)
public class WellMixedNumbers {
    public static void main(String[] args) {

/*        howOftenIsOccurring(1, new int[]{ 1, 2, 3, 1, 1 }) würde 3 ergeben.

                howOftenIsOccurring(4, new int[]{ 1, 2, 3, 1, 1 }) würde 0 ergeben.

                areAllValuesTheSame(new int[]{ 1, 1, 1, 1, 1 }) würde true ergeben.

                isFullHouse(new int[]{ 1, 1, 1, 2, 2 }) würde true ergeben.

                isFullHouse(new int[]{ 1, 1, 1, 1, 1 }) würde false ergeben.

                printDiceValues(shuffleDice()) könnte die Ausgabe 2 × ⚁, 2 × ⚃, ⚅ ergeben.*/
        printDiceValues(new int[]{1,3,3,4,1,5,6});
        System.out.println();
        printDiceValues(new int[]{6,4,6,1,5,2,6,3,6,6,6,2,5,3,5,2,1});
        System.out.println();

        System.out.println(howOftenIsOccurring(5, new int[]{6, 4, 6, 1, 5, 2, 6, 3, 6, 6, 6, 2, 5, 3, 5, 2, 1}));
        System.out.println(areAllValuesTheSame(new int[]{6, 4, 6, 1, 5, 2, 6, 3, 6, 6, 6, 2, 5, 3, 5, 2, 1}));
        System.out.println(areAllValuesTheSame(new int[]{7,7,7}));

        System.out.println();
        System.out.println(isFullHouse(new int[]{3,3,2,2,1,1})); // false
        System.out.println(isFullHouse(new int[]{3,3,2,2,1,3})); // true

        System.out.println("**************************************************************");

        int[] dice1 = shuffleDice();
        int[] dice2 = shuffleDice();
        int[] dice3 = shuffleDice();
        int[] dice4 = shuffleDice();
        printDiceValues(dice1);
        printDiceValues(dice2);
        printDiceValues(dice3);
        printDiceValues(dice4);

    }

    public static int[] shuffleDice(){
        int[] diceRolls = new int[5];

        for(int i = 0; i <diceRolls.length; i++) {
            diceRolls[i] = (int) (Math.random() * 6 + 1); // random value between 1 and 6
        }

        return diceRolls;
    }

    // reuse the code... in printDiceValue...
    public static int howOftenIsOccurring(int value, int[] array) {
        int counter = 0;

        for (int diceValue : array) {
            counter = diceValue == value ? counter + 1 : counter;
        }

        System.out.println(counter);
        return counter;
    }

    public static boolean areAllValuesTheSame(int[] values) {
        System.out.println(values.length);
        return howOftenIsOccurring(values[0], values) == values.length;
    }

    public static boolean isFullHouse(int[] values) {
        boolean threePair = false;
        int threePairValue = 0;
        boolean twoPair = false;
        int twoPairValue = 0;

        for (int value : values) {

            if (threePairValue != value) {
                if (howOftenIsOccurring(value, values) >= 3) {
                    threePair = true;
                    threePairValue = value; // next loop check only 2 pair
                }
            }

            // only check once we found 3 pair and we didn't find 2 pair yet
            if (threePair && twoPairValue != value && !twoPair) {
                if (value != threePairValue) { // check for different number that didn't get the 3 pair
                    if (howOftenIsOccurring(value, values) >= 2) {
                        twoPair = true;
                        twoPairValue = value;
                    }
                }
            }
        }
        return threePair && twoPair;
    }


    public static void printDiceValues(int[] points) {
        int one = 0, two = 0, three = 0, four = 0, five = 0, six = 0;
        int[] result = new int[6];
        for (int point : points) {
            switch (point) {
                case 1 -> one++;
                case 2 -> two++;
                case 3 -> three++;
                case 4 -> four++;
                case 5 -> five++;
                case 6 -> six++;
                default -> System.out.println("Dice value must be between 1 and 6!");
            }
        }

        // fix "," problem
        // create result for grouping
        for (int i = 1; i <= 6; i++) {
            switch (i) {
                case 1 -> result[i-1] = one;
                case 2 -> result[i-1] = two;
                case 3 -> result[i-1] = three;
                case 4 -> result[i-1] = four;
                case 5 -> result[i-1] = five;
                default -> result[i-1] = six;
            }
        }

        for (int i = 1; i <= result.length; i++) {
            String dice = switch (i) {
                case 1 -> "⚀";
                case 2 -> "⚁";
                case 3 -> "⚂";
                case 4 -> "⚃";
                case 5 -> "⚄";
                default -> "⚅";
            };
            System.out.printf("%s", result[i-1] == 0 ? "" : (result[i-1] == 1 ? dice : result[i-1] + " x " + dice) ); // dice = cube symbol

            if (i < result.length) {// as long it's not the last item, then print ","
                if (result[i-1] != 0) { // only print it, if the item value is not 0
//                    System.out.print(", ");
                    int counter = 0;
                    for (int j = i; j < result.length; j++) { // check the values of them remaining items inside the string
                        if (result[j] > 0) counter++;
                    }
                    if (counter > 0) {
                        System.out.print(", "); // only when there are still items with values > 0, print the ","
                    }
                }
            }
        }
        System.out.println();
        // first try, but problem with "," placement
/*        // output: 0x -> nothing, 1x -> ⚅, > 1x -> ?x ⚅
        System.out.printf("%s %s %s %s %s %s",
                one == 0 ? "" : (one == 1 ? "⚀," : one + " x ⚀,"),
                two == 0 ? "" : (two == 1 ? "⚁," : two + " x ⚁,"),
                three == 0 ? "" : (three == 1 ? "⚂," : three + " x ⚂,"),
                four == 0 ? "" : (four == 1 ? "⚃," : four + " x ⚃,"),
                five == 0 ? "" : (five == 1 ? "⚄," : five + " x ⚄,"),
                six == 0 ? "" : (six == 1 ? "⚅" : six + " x ⚅")
        );*/

        /*Arrays.sort(points); ???
        System.out.println(Arrays.toString(points));
        for (int point : points) {

        }
        System.out.println();*/
    }
}
