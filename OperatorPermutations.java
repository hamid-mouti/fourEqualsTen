package fourEqualsTen;

import java.util.ArrayList;
import java.util.List;

public class OperatorPermutations {
    public static List<String> generateOperatorPermutations() {
        char[] operators = {'+', '-', '*', '/'};
        List<String> permutations = new ArrayList<>();

        for (int i = 0; i < operators.length; i++) {
            for (int j = 0; j < operators.length; j++) {
                for (int k = 0; k < operators.length; k++) {
                    StringBuilder permutationBuilder = new StringBuilder();
                    permutationBuilder.append(operators[i]);
                    permutationBuilder.append(operators[j]);
                    permutationBuilder.append(operators[k]);
                    permutations.add(permutationBuilder.toString());
                }
            }
        }

        return permutations;
    }
}


