package georggross.calculations;

public class Variable {
    private String name;
    private Complex complex;

    public Variable(String name, Complex complex) {
        this.name = name;
        this.complex = complex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Complex getComplex() {
        return complex;
    }

    public void setComplex(Complex complex) {
        if (complex != null) {
            this.complex = complex;
        }
    }

    @Override
    public String toString() {
        return name + " = " + complex.toString();
    }
}
