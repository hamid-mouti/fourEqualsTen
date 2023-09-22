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

        FileOutputStream fos = null;
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

        numberPermutations.add("12(34)");
        numberPermutations.add("1(234)");
        numberPermutations.add("1(32)4");
        numberPermutations.add("(123)4");


        List<String> operatorPermutations = OperatorPermutations.generateOperatorPermutations();



        try {
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ps.close();

    }

    public List<String> generateExpressions(List<String> operatorPermutations, List<String> numberPermutations)
    {
        List<String> expressions = new ArrayList<>();

    }


}

