package georggross.ui;

import georggross.tests.TestStrings;
import org.junit.Test;

public class App2Test {

    @Test
    public void processInput() {
//        runTest(TestStrings.test1);
//      runTest(TestStrings.test1);
        runTest(TestStrings.test4);

    }


    private void runTest(String[] testArray) {
        for (int i = 0; i < testArray.length; i++) {
            System.out.println("> " + testArray[i]);
            System.out.println(App2.processInput(testArray[i]));
            System.out.println("");
        }
    }

}