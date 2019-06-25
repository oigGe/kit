package Georg;

import java.util.ArrayList;

public class Clause {
    ArrayList<Literal> literals;
    int minimumLiteralValue;

    public Clause(ArrayList<Literal> literals) {
        this.literals = literals;
        minimumLiteralValue = identifyMinimumLiteralValue();
    }

    private int identifyMinimumLiteralValue() {
        int minimum = Integer.MAX_VALUE;
        for (Literal literal : literals) {
            int thisValue = literal.getLiteralValue();
            if (thisValue < minimum) {
                minimum = thisValue;
            }
        }
        return minimum;
    }
}
