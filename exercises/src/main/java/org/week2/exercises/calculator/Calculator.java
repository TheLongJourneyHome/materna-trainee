package org.week2.exercises.calculator;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.*;


/**
 * <code>Calculator</code> is the application where the user can calculate things, by inputting the values and variables
 * inside the console.
 * <p>
 * This project uses the library and dependencies from <a href="https://www.objecthunter.net/exp4j/">exp4j</a> that was a requirement for this exercise.
 * The calculator accepts a wide range of predefined functions from exp4j and the user also has the ability to create variables here and use them
 * for calculations later, as long the program is running.
 * The user can end the program by inputting <code>"exit"</code> in the console, or the program is throwing an exception.
 *
 * @author Long
 */
public class Calculator {
    // Exercise
    /*
    exp4j
    https://www.objecthunter.net/exp4j/

    Nutze exp4j und realisiere damit einen Taschenrechner auf der Kommandozeile, dass man zum Beispiel schreiben kann:


            > 99
            99
            > 99 + 1
            100
            > x = 1
            1
            > y = 0.2 + 0.3
            0.5
            > 3 * sin(y) - 2 / (x - 2)
            3.438276615812609
            > exit


    Es wird das Ergebnis vom Ausdruck angezeigt. > symbolisiert das Eingabesymbol, es wird Zeile für Zeile eingegeben und mit Return abgeschlossen.*/

    private static Map<String, Double> variables = new HashMap<>();

    // execute the program
    public static void main(String[] args) {
//        variables.put("test",0.1);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }
            // function to handle user input and calculate here
            System.out.println( evaluateExpression(input) );
        }
        scanner.close();
    }


    /**
     * The user input is processed here.
     * At the beginning the <code>String</code> is split so that the variable declaration (if there is any) is not handled during the calculation,
     * otherwise some unexpected result will come out with a variable name that has digits, due to the filtering done
     * to complete this exercise.
     * <p>
     * Example of a faulty result that might occur: test1 = 1 + 1
     * Expected: test1 = 2
     * Result without splitting variable from calculation: test1 = 12
     * Cause: test1 = 1 + 1 => test 1 = 1 + 1 => 1 1 + 1 => 11+1 => 12
     * <p>
     * There is probably a better solution, but this is what I came up with for now.
     * The user input string will have spaces inserted between each number, operator and predefined function, so we can read it and use it for processing later,
     * by separating each of these important arguments for calculation.
     *
     * Regex variables are defined here to spot the numbers, operators, predefined functions and variables and do the filtering.
     * Every variable the user adds, becomes a valid search criteria for the string filtering,
     * so we can include it inside the calculation and not exclude it when filtering for non-valid input for calculation.
     *
     * @param expression the user input that is used by the <code>Expression</code> from exp4j to calculate the user input
     *
     * @return result of type <code>Double</code> from the user input
     * @see #noVarString(String expression)
     * @see #addSpaces(String expression)
     * @see #removeSpaces(String expression)
     */
    public static double evaluateExpression(String expression) {
        // System.out.println(...) for testing and understanding console outputs

//        System.out.println(expression);
        String input = addSpaces( noVarString(expression) ); // add spaces to the string without variable declaration, that will be used for calculation
//        System.out.println(input);
        String output;


        // regex variables to filter out everything that has a valid input for calculation
        ArrayList<String> variableNames = new ArrayList<>();
        for (Map.Entry<String, Double> variable : variables.entrySet()) {
            variableNames.add(variable.getKey());
        }
//        System.out.println(variableNames);

        String[] functions = {"abs", "acos", "asin", "atan", "cbrt", "ceil", "cos", "cosh", "exp", "floor", "log", "log10", "log2", "sin", "sinh", "sqrt", "tan", "tanh", "signum"};
        String[] words = input.split("\\s+");
        StringBuilder sb = new StringBuilder();


        // filter out everything that is not defined in the regex
        for (String word : words) {
            if (variableNames.contains(word) || Arrays.asList(functions).contains(word) || word.matches("[+\\-*/^%().]$") || word.matches("[0-9]+$")) {
                sb.append(word + " ");
            }
        }
        output = sb.toString();
//        System.out.println(output);


        // get variable and replace it with its value
        for (Map.Entry<String, Double> variable : variables.entrySet()) {
            output = output.replaceAll(variable.getKey(), String.valueOf(variable.getValue()));
        }


        output = removeSpaces(output);
//        System.out.println("Original input: " + input);
//        System.out.println("Cleaned output: " + output);


        // the calculation using exp4j
        Expression e = new ExpressionBuilder(output)
                .build();
/*      with variable usage with exp4j
        Expression e = new ExpressionBuilder(output)
                .variables("x", "y")
                .build()
                .setVariable("x", 2.3)
                .setVariable("y", 3.14);*/


        // assign variable with a value, if the user is declaring one
        hasVariable(expression, e.evaluate());
        return e.evaluate();
    }


    /**
     * Separate numbers, operators and predefined functions with a space before and after.
     * <p>
     * At the end all the whitespaces will be removed before adding the final string to the <code>Expression</code> for calculation.
     * Because of the implicit multiplication of exp4j, you can read "3sin(5)" as "3 * sin(5)".
     * If there would be whitespace between 3 and sin(5), so "3 sin(5)", there could be an error. We need to remove what we added before, the whitespace.
     *
     * @param expression the user input that is used by the <code>Expression</code> from exp4j to calculate the user input
     * @return modified expression string that can be handled better for calculation
     */
    private static String addSpaces(String expression) {
        String inputSpaces = expression;
        String[] functions = {"abs", "acos", "asin", "atan", "cbrt", "ceil", "cos", "cosh", "exp", "floor", "log", "log10", "log2", "sin", "sinh", "sqrt", "tan", "tanh", "signum"};
        String functionRegex = "(" + String.join("|", functions) + ")";
        String numberRegex = "\\d+";
        String operatorRegex = "[+\\-*/^%()]";
        String allRegex = numberRegex + "|" + operatorRegex + "|" + functionRegex;
        inputSpaces = inputSpaces.replaceAll("(" + allRegex + ")", " $1 ");
        return inputSpaces;
    }


    /**
     * Removing the whitespaces before calculation
     *
     * @param expression the user input that is used by the <code>Expression</code> from exp4j to calculate the user input
     * @return modified expression string for calculation
     */
    private static String removeSpaces(String expression) { // 3sin(5) -> 3 * sin(5)
        String inputNoSpaces = expression;
        inputNoSpaces = inputNoSpaces.replaceAll("\s+", "");
        return inputNoSpaces;
    }


    /**
     * Check if user input is a variable declaration, by looking for a "=" symbol.
     * If there is none then do nothing.
     * If there is one, then assign a key value pair to the variable <code>Map</code>.
     * But first check if the conditions for a variable declaration match.
     * Variable names must start with a letter or the underscore _ and can only include letters, digits or underscores.
     * <p>
     * <code>"^[a-zA-Z_][a-zA-Z0-9_]*$"</code>
     * This is a check that verifies if the first character of the variable name is a letter or an underscore, and if the entire variable name matches a certain regular expression.
     * If the check is not valid, throw an exception saying that the variable declaration is not valid.
     *
     * @param expression the user input that is used by the <code>Expression</code> from exp4j to calculate the user input
     * @param result the result of the calculation for the values after the "="
     */
    private static void hasVariable(String expression, double result) {
        expression = expression.replaceAll("\\s", "");
//        System.out.println(expression);
        int indexOfEqualSign = expression.indexOf("=");
        if (indexOfEqualSign != -1) {
            String varName = expression.substring(0, indexOfEqualSign).trim();
            if( (varName.matches("^[a-zA-Z_][a-zA-Z0-9_]*$")) ) {
                variables.put(varName, result);
            } else {
                throw new IllegalArgumentException("Invalid variable name: " + varName + ". Variable names must start with a letter or underscore and can only include letters, digits or underscores");
            }
        }
//        System.out.println("Variables: " + variables);
    }


    /**
     * Filters out the variable declaration part of the user input and returns the second half of the string that is
     * relevant for calculation.
     *
     * @param expression the user input that is used by the <code>Expression</code> from exp4j to calculate the user input
     * @return modified expression string for calculation, without the variable declaration part if there is one
     */
    private static String noVarString(String expression) {
        String result = expression;
        int indexOfEqualSign = expression.indexOf("=");
        if (indexOfEqualSign != -1) {
            result = expression.substring(indexOfEqualSign+1).trim();
        }
        return result;
    }

}

