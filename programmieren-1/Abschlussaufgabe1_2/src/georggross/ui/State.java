package georggross.ui;

import georggross.cataloges.VariableCatalog;

public class State {
    private static State instance;
    private VariableCatalog variableCatalog;

    private State() {
        this.variableCatalog = new VariableCatalog();
    }

    public static State getInstance() {
        if (State.instance == null) {
            State.instance = new State();
        }
        return State.instance;
    }

    public VariableCatalog getVariableCatalog() {
        return variableCatalog;
    }
}
