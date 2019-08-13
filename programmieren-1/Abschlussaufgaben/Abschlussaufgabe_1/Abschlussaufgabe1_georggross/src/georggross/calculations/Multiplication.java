package georggross.calculations;

/**
 * Represents a multiplication of complex number.
 *
 * @author Georg Gross
 * @version 1.0
 */
public class Multiplication implements Computable {

    private Complex complex1;
    private Complex complex2;


    /**
     * Creates a multiplication without any characters
     */
    public Multiplication() {
    }

    @Override
    public void setComplex(Complex complex1, Complex complex2) {
        this.complex1 = complex1;
        this.complex2 = complex2;
    }

    @Override
    public Complex compute() {
        return new Complex((complex1.getA() * complex2.getA()) - (complex1.getB() * complex2.getB()),
                (complex1.getA() * complex2.getB()) + (complex1.getB() * complex2.getA()));
    }


}
