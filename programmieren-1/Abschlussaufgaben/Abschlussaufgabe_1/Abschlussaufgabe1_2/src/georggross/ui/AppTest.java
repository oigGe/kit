package georggross.ui;

import georggross.tests.TestStrings;
import org.junit.Test;

public class AppTest {

    @Test
    public void processInput() {
//        runTest(TestStrings.test1);
//      runTest(TestStrings.test1);
        runTest(TestStrings.ilias);

    }


    private void runTest(String[] testArray) {
        for (int i = 0; i < testArray.length; i++) {
            System.out.println("> " + testArray[i]);
            System.out.println(App.processInput(testArray[i]));
            System.out.println("");
        }
    }

}