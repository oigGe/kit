package georggross.calculations;

/**
 * Represents a variable holding a complex number.
 *
 * @author Georg Gross
 * @version 1.0
 */
public class Variable {
    private String name;
    private Complex complex;

    /**
     * Creates a new Variable with variable name and Complex as parameters.
     *
     * @param name    - variable name
     * @param complex - Complex being held by variable
     */
    public Variable(String name, Complex complex) {
        this.name = name;
        this.complex = complex;
    }

    /**
     * Returns the name of the variable.
     *
     * @return - the name as String
     */
    public String getName() {
        return name;
    }


    /**
     * Returns the complex held by the variable.
     *
     * @return - Complex
     */
    public Complex getComplex() {
        return complex;
    }


    /**
     * Assigns complex to variable.
     * checks if complex parameter is null in which case this.complex is not changed
     *
     * @param complex - new Complex to be assigned to variable
     */
    public void setComplex(Complex complex) {
        if (complex != null) {
            this.complex = complex;
        }
    }

    /**
     * Returns the variable as String in required format.
     *
     * @return - variable name and complex as String
     */
    @Override
    public String toString() {
        return name + " = " + complex.toString();
    }
}
