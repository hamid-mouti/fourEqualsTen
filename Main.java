package fourEqualsTen;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.print("Enter 4 numbers followed by a set of parentheses.\nExample: '1234()': ");

        // Read a line of text entered by the user
        String input = scanner.nextLine();


        List<String> permutationsNums = NumberPermutationGenerator.generateValidPermutations(input);
        List<String> operatorPermutations = OperatorPermutations.generateOperatorPermutations();
        List<String> expressions = ExpressionGenerator.generateExpressions(operatorPermutations, permutationsNums);

        List<String> res = ParseExpression.evaluateExpressionResult(expressions);

        for (String expr : res)
            System.out.println(expr + " = 10");

    }

}
