package georggross.tests;
import java.util.concurrent.ThreadLocalRandom;

public class MyStringBuilder {
    public static String buildSingleComplexZuweisung(String name, int a, int b) {
        return name + " = " + "(" + a + " + " + b + "i)";
    }


    public static String buildComplex(int a, int b) {
        return "(" + a + " + " + b + "i)";
    }

    public static String buildTwoVariableZuweisung(String a, String b, String c, String operator) {
        return a + " = " + b + " " + operator + " " + c;
    }

    public static String getRandIntString() {
        return Integer.toString(ThreadLocalRandom.current().nextInt(-1000, 1000 + 1));
    }

}
