package fourEqualsTen;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


public class ExpressionGenerator {

    public static void main(String[] args) {

        String path = "C:/Users/USER/Desktop/JAVA training/fourEqualsTen/";

        FileOutputStream fos;
        try {
            fos = new FileOutputStream(path + "result.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Create a custom PrintStream that writes to the output file
        PrintStream ps = new PrintStream(fos);

        // Redirect stdout to the custom PrintStream
        System.setOut(ps);

        List<String> numberPermutations = new ArrayList<>();

        numberPermutations.add("1(234)");


        List<String> operatorPermutations = OperatorPermutations.generateOperatorPermutations();


        List<String> res = generateExpressions(operatorPermutations,numberPermutations);

        for (String s: res)
            System.out.println(s);


        try {
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ps.close();

    }

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


