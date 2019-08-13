package georggross.calculations;

import georggross.cataloges.RegexCatalog;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a complex number.
 *
 * @author Georg Gross
 * @version 1.0
 */

public class Complex {
    private int a;
    private int b;
    private String complexString;


    /**
     * Creates a neẃ complex with two int values as parameters
     *
     * @param a - real number.
     * @param b - imaginary number.
     */
    public Complex(int a, int b) {
        this.a = a;
        this.b = b;
    }

    /**
     * Creates a new complex number with a String.
     *
     * @param complexString - String representig a complex number.
     */
    public Complex(String complexString) {
        this.complexString = complexString;
        setCompex();
    }

    @Override
    public String toString() {
        return "(" + a + " + " + b + "i)";
    }

    //    Checks if complexString has correct input format.
//    Extracxts the real and imaginary number values and assigns the to this.a and this.b.
    private void setCompex() {
        Pattern pattern = Pattern.compile(RegexCatalog.COMPLEX_REGEX.getRegex());
        Matcher matcher = pattern.matcher(complexString);
        if (matcher.matches()) {
            this.a = Integer.parseInt(matcher.group(2));
            this.b = Integer.parseInt(matcher.group(4));

        }
    }

    /**
     * Returns the real number value.
     *
     * @return - real number value.
     */
    public int getA() {
        return a;
    }

    /**
     * Returns the imaginary number value.
     *
     * @return - imaginary number value.
     */
    public int getB() {
        return b;
    }
}
