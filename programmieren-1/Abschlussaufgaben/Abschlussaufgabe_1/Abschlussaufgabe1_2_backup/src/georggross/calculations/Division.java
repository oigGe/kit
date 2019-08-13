package georggross.calculations;

public class Division {

    public static Complex doDivision(Complex complex1, Complex complex2) {

        try {
            return new Complex((((complex1.getA() * complex2.getA()) + (complex1.getB() * complex2.getB())) / (((int) (Math.pow(complex2.getA(), 2))) + (int) (Math.pow(complex2.getB(), 2)))),
                    (((complex1.getB() * complex2.getA()) - (complex1.getA() * complex2.getB())) / (((int) (Math.pow(complex2.getA(), 2))) + ((int) Math.pow(complex2.getB(), 2)))));
        } catch (ArithmeticException e) {
            return null;
        }
    }
}
