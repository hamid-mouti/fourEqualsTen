package fourEqualsTen;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


public class ExpressionGenerator {

    public static List<String> generateExpressions(List<String> operatorPermutations, List<String> numberPermutations) {
        List<String> expressions = new ArrayList<>();

        for (String permutationNum : numberPermutations)
        {
            for(String ops : operatorPermutations )
            {
                expressions.add(generateExpressionsHelper(ops,permutationNum));
            }
        }
        return expressions;

    }


    public static String generateExpressionsHelper(String operatorPermutation, String numberPermutations) {

        //1(23)4
        StringBuilder res = new StringBuilder();
        StringBuilder ops = new StringBuilder(operatorPermutation);
        for (int i =0; i<numberPermutations.length();i++)
        {
            char c =numberPermutations.charAt(i);
            // Check conditions for appending the character
            if ((Character.isDigit(c) && (i != numberPermutations.length() -1 && (Character.isDigit(numberPermutations.charAt(i + 1)) ||
                    numberPermutations.charAt(i + 1) == '(' ) ) ) || c == ')' && i != numberPermutations.length() -1) {

                res.append(c);
                res.append(ops.charAt(0));
                ops.deleteCharAt(0);
                continue;
            }
            res.append(c);
        }

        return res.toString();
    }
}


