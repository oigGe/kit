package georggross.calculations;

public class Multiplication {
    public static Complex doMultiplication(Complex complex1, Complex complex2){
        return new Complex((complex1.getA()*complex2.getA()) - (complex1.getB()*complex2.getB()),(complex1.getA() * complex2.getB()) + (complex1.getB() * complex2.getA()));
    }

}
