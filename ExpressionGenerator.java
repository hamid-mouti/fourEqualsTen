package fourEqualsTen;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class ExpressionGenerator {

    public static void main(String[] args) {
        List<String> permutations = new ArrayList<>();

        permutations.add("1(32)4");


        for (String permutation : permutations) {
            generateExpressions(permutation, 0, "", 0);
        }
    }

    public static void generateExpressions(String permutation, int index, String currentExpression, int operatorCount) {
        if (index == permutation.length()) {
            if (isValidExpression(currentExpression, operatorCount)) {
                System.out.println(currentExpression);
            }
            return;
        }

        char currentChar = permutation.charAt(index);

        if (currentChar == '(' || currentChar == ')') {
            // If it's a parenthesis, include it as is
            generateExpressions(permutation, index + 1, currentExpression + currentChar, operatorCount);
        } else {
            if (operatorCount < 3) {
                // Try all four operators if not already reached the limit
                generateExpressions(permutation, index + 1, currentExpression + currentChar + "+", operatorCount + 1);
                generateExpressions(permutation, index + 1, currentExpression + currentChar + "-", operatorCount + 1);
                generateExpressions(permutation, index + 1, currentExpression + currentChar + "*", operatorCount + 1);
                generateExpressions(permutation, index + 1, currentExpression + currentChar + "/", operatorCount + 1);
            }
            // Continue without an operator
            generateExpressions(permutation, index + 1, currentExpression + currentChar, operatorCount);
        }
    }

    public static boolean isValidExpression(String expression, int operatorCount) {
        // Check if expression contains exactly 4 numbers
        String[] tokens = expression.split("[()+\\-*/]");
        int numCount = 0;
        for (String token : tokens) {
            if (!token.isEmpty() && token.matches("\\d+")) {
                numCount++;
            }
        }
        if (numCount != 4) {
            return false;
        }

        // Check for one pair of parentheses
        int openParenCount = 0;
        int closeParenCount = 0;
        for (char c : expression.toCharArray()) {
            if (c == '(') {
                openParenCount++;
            } else if (c == ')') {
                closeParenCount++;
            }
        }
        if (openParenCount != 1 || closeParenCount != 1) {
            return false;
        }

        // Check if there's an operator before a closing parenthesis
        if (expression.contains(")(")) {
            return false;
        }

        // Check if the expression follows the rule about arithmetic signs
        if (expression.matches("^[+\\-*/].*|.*[+\\-*/]$")) {
            return false;
        }

        // Check if there are exactly three operators (excluding parentheses)
        if (operatorCount != 3) {
            return false;
        }

        // Check if the expression inside parentheses contains at least 2 numbers and an operator
        int start = expression.indexOf('(');
        int end = expression.indexOf(')');
        if (end - start < 3) {
            return false;
        }

        return true;
    }
}

