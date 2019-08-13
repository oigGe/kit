package georggross.calculations;

/**
 * Represents an addition of complex numbers
 *
 * @author Georg Gross
 * @version 1.0
 */
public class Addition implements Computable {

    private Complex complex1;
    private Complex complex2;

    /**
     * Creates an addition without parameters
     */
    public Addition() {
    }

    /**
     * Sets up the complex numbers to perform the addition on.
     *
     * @param complex1 - first summand
     * @param complex2 - seccond summand
     */
    @Override
    public void setComplex(Complex complex1, Complex complex2) {
        this.complex1 = complex1;
        this.complex2 = complex2;
    }

    @Override
    public Complex compute() {
        return new Complex(complex1.getA() + complex2.getA(), complex1.getB() + complex2.getB());
    }


}
