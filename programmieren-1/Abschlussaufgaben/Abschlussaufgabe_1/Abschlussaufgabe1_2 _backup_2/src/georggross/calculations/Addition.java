package georggross.calculations;

public class Addition {
    public static Complex doAddition(Complex complex1, Complex complex2){
        return new Complex(complex1.getA() + complex2.getA(),complex1.getB() + complex2.getB());
    }
}
