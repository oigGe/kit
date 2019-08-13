package georggross.ui;

import georggross.cataloges.VariableCatalog;

/**
 * Represents the state of the application
 *
 * @author Georg Gross
 * @version 1.0
 */
public final class State {
    private static State instance;
    private VariableCatalog variableCatalog;

    /**
     * Private COnstructor
     */
    private State() {
        this.variableCatalog = new VariableCatalog();
    }

    /**
     * If not yet created: creates a new Instance
     * returns the instance
     *
     * @return - instance of state
     */
    public static State getInstance() {
        if (State.instance == null) {
            State.instance = new State();
        }
        return State.instance;
    }

    /**
     * Returns variable catalog which contains all declared variables
     *
     * @return - variable List
     */
    public VariableCatalog getVariableCatalog() {
        return variableCatalog;
    }
}
