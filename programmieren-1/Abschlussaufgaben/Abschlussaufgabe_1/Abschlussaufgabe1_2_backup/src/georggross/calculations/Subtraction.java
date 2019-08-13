package georggross.calculations;

public class Subtraction {
    public static Complex doSubtraction(Complex complex1, Complex complex2){
        return new Complex(complex1.getA() - complex2.getA(),complex1.getB() - complex2.getB());
    }
}
