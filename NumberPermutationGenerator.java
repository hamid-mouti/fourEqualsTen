package fourEqualsTen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberPermutationGenerator {

    public static List<String> generateValidPermutations(String input) {
        List<String> permutations = generatePermutations(input);
        List<String> validPermutations = new ArrayList<>();

        for (String permutation : permutations) {
            if (isValid(permutation)) {
                validPermutations.add(permutation);
            }
        }

        return validPermutations;
    }

    private static boolean isValid(String permutation) {
        int openParenIndex = permutation.indexOf('(');
        int closeParenIndex = permutation.indexOf(')');

        if (openParenIndex == -1 || closeParenIndex == -1 || openParenIndex >= closeParenIndex) {
            return false;
        }

        String contents = permutation.substring(openParenIndex + 1, closeParenIndex);
        int numCount = 0;

        for (char c : contents.toCharArray()) {
            if (Character.isDigit(c)) {
                numCount++;
            }
        }

        return numCount >= 2 && numCount <= 3;
    }


    public static List<String> generatePermutations(String input) {
        List<String> result = new ArrayList<>();
        char[] chars = input.toCharArray();
        Set<Character> numbers = new HashSet<>();
        int openParenCount = 0;
        int closeParenCount = 0;

        for (char c : chars) {
            if (Character.isDigit(c)) {
                numbers.add(c);
            } else if (c == '(') {
                openParenCount++;
            } else if (c == ')') {
                closeParenCount++;
            }
        }

        // Check for input validity
        if (numbers.size() != 4) {
            System.out.println("Error: Input should contain exactly 4 numbers.");
            return result;
        }
        if (openParenCount != 1 || closeParenCount != 1) {
            System.out.println("Error: Input should contain exactly one pair of parentheses.");
            return result;
        }
        if (openParenCount != closeParenCount) {
            System.out.println("Error: Invalid parentheses (mismatched open and close parentheses).");
            return result;
        }
        if (numbers.size() == 0) {
            System.out.println("Error: Input should contain at least one number.");
            return result;
        }

        generatePermutationsHelper(chars, 0, result);
        return result;
    }

    private static void generatePermutationsHelper(char[] chars, int index, List<String> result) {
        if (index == chars.length) {
            result.add(new String(chars));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            generatePermutationsHelper(chars, index + 1, result);
            swap(chars, index, i);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
