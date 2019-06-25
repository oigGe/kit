package Georg;

public class Literal {
   private int literalValue;
   private boolean isNegated;

    public Literal(int literalValue, boolean isNegated) {
        this.literalValue = literalValue;
        this.isNegated = isNegated;
    }

    public int getLiteralValue() {
        return literalValue;
    }

    public boolean isNegated() {
        return isNegated;
    }
}
