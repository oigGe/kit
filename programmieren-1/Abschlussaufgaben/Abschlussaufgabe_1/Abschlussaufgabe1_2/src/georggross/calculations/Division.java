package georggross.calculations;

/**
 * Represents a division performed on two complex numbers.
 *
 * @author Georg Gross
 * @version 1.0
 */
public class Division implements Computable {

    private Complex complex1;
    private Complex complex2;

    /**
     * Creates a Division without parameters
     */
    public Division() {

    }

    @Override
    public void setComplex(Complex complex1, Complex complex2) {
        this.complex1 = complex1;
        this.complex2 = complex2;
    }

    @Override
    public Complex compute() {
        try {
            return new Complex((((complex1.getA() * complex2.getA())
                    + (complex1.getB() * complex2.getB())) / (((int) (Math.pow(complex2.getA(), 2)))
                    + (int) (Math.pow(complex2.getB(), 2)))),
                    (((complex1.getB() * complex2.getA()) - (complex1.getA() * complex2.getB()))
                            / (((int) (Math.pow(complex2.getA(), 2))) + ((int) Math.pow(complex2.getB(), 2)))));
        } catch (ArithmeticException e) {
            return null;
        }
    }
}
