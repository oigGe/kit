package georggross.calculations;

import georggross.cataloges.RegexCatalog;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Complex {
    private int a;
    private int b;
    private String complexString;


    public Complex(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Complex(String complexString) {
        this.complexString = complexString;
        setCompex();
    }

    @Override
    public String toString() {
        return "(" + a + " + " + b + "i)";
    }

    private void setCompex() {
        Pattern pattern = Pattern.compile(RegexCatalog.COMPLEX_REGEX);
        Matcher matcher = pattern.matcher(complexString);
        if (matcher.matches()) {
            this.a = Integer.parseInt(matcher.group(2));
            this.b = Integer.parseInt(matcher.group(4));

        }
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
