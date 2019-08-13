package georggross.Grammar;

public class Literal implements ITermPart {
   private Variable variable;
   private Complex complex;

    public Literal(Variable variable) {
        this.variable = variable;
    }

    public Literal(Complex complex) {
        this.complex = complex;
    }
}
