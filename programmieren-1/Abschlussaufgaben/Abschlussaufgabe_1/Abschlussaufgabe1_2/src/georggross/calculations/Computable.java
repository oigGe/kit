package georggross.calculations;

/**
 * Represents a mathemattical operation performed on two complex numbers.
 *
 * @author georg gross
 * @version 1.0
 */
public interface Computable {
    /**
     * Sets up the two complexes the operation shouldbe performed on.
     *
     * @param complex1 - first complex
     * @param complex2 - second complex
     */
    void setComplex(Complex complex1, Complex complex2);

    /**
     * Performes the operation in question.
     * Returns the result of the operation.
     *
     * @return - the result of the operation as complex.
     */
    Complex compute();
}
