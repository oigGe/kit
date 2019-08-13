package georggross.ui;

import georggross.calculations.*;
import georggross.cataloges.ErrorCatalog;
import georggross.tests.MyStringBuilder;
import georggross.tests.TestStrings;
import org.junit.Test;

public class AppTest {

    @Test
    public void processInput() {
//        runTest(TestStrings.test4);
//      runTest(TestStrings.test1);
        runTest(TestStrings.test5);

    }


    private void runTest(String[] testArray) {
        for (int i = 0; i < testArray.length; i++) {
            System.out.println("> " + testArray[i]);
            System.out.println(App.processInput(testArray[i]));
            System.out.println("");
        }
    }

    private void calcTest(String operator) {


        boolean isCorrect = true;
        int couter = 0;
        while (isCorrect && couter <= 100000) {
            couter++;
            System.out.println("Loopcounter: " + couter);
            String randomIntString1 = MyStringBuilder.getRandIntString();
            String randomIntString2 = MyStringBuilder.getRandIntString();
            String randomIntString3 = MyStringBuilder.getRandIntString();
            String randomIntString4 = MyStringBuilder.getRandIntString();
            int randomInt1 = Integer.parseInt(randomIntString1);
            int randomInt2 = Integer.parseInt(randomIntString2);
            int randomInt3 = Integer.parseInt(randomIntString3);
            int randomInt4 = Integer.parseInt(randomIntString4);

            Complex complex1 = new Complex(randomInt1, randomInt2);
            System.out.println("complex1: " + complex1.toString());
            Complex complex2 = new Complex(randomInt3, randomInt4);
            System.out.println("complex2: " + complex2.toString());

            String input = "a = " + MyStringBuilder.buildComplex(randomInt1, randomInt2) + " " + operator + " " + MyStringBuilder.buildComplex(randomInt3, randomInt4);

            String AppoutPut = App.processInput(input);

            String calcString;

            if (operator.equals("+")) {
                calcString = "a = " + Addition.doAddition(complex1, complex2).toString();
            } else if (operator.equals("-")) {
                calcString = "a = " + Subtraction.doSubtraction(complex1, complex2).toString();
            } else if (operator.equals("*")) {
                calcString = "a = " + Multiplication.doMultiplication(complex1, complex2).toString();
            } else if (operator.equals("/")) {
                try {

                    calcString = "a = " + Division.doDivision(complex1, complex2).toString();
                } catch (NullPointerException e) {
                    calcString = ErrorCatalog.INVALID_EXPRESSION_MESSAGE;
                }
            } else {
                calcString = "ficki";
            }

            System.out.println("App Output: " + AppoutPut);
            System.out.println("Calc Output: " + calcString);
            System.out.println("");
            System.out.println("");
            System.out.println("");

            if (!AppoutPut.equals(calcString)) {
                isCorrect = false;
                System.out.println("input: " + input);
                System.out.println("AppOutPut: " + input);
                System.out.println("additionSting: " + input);
            }


        }
    }

}