package georggross.calculations;

/**
 * Represents a subtraction of complex numbers.
 * @author Georg Gross
 * @version 1.0
 */
public class Subtraction implements Computable {

    private Complex complex1;
    private Complex complex2;


    /**
     * Creates a subtraction without parameters
     */
    public Subtraction() {
    }

    @Override
    public void setComplex(Complex complex1, Complex complex2) {
        this.complex1 = complex1;
        this.complex2 = complex2;
    }

    @Override
    public Complex compute() {
        return new Complex(complex1.getA() - complex2.getA(), complex1.getB() - complex2.getB());
    }


}
