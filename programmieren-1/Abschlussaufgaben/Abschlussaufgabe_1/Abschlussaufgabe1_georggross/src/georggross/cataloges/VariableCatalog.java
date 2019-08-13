package georggross.cataloges;

import georggross.calculations.Variable;

import java.util.LinkedList;


/**
 * Represents a collection of declared variables
 *
 * @author Georg Gross
 * @version 1.0
 */
public class VariableCatalog {
    private LinkedList<Variable> variables;

    /**
     * Cretes a new List of variables
     */
    public VariableCatalog() {
        variables = new LinkedList<>();
    }


    /**
     * Adds a variable to the list.
     *
     * @param newVariable - variable to be added to the list
     */
    public void addVariable(Variable newVariable) {
        variables.add(newVariable);
    }

    /**
     * Returns an existing variable with parameter as name.
     *
     * @param name - name of variable in question
     * @return - variable in question
     */
    public Variable getVariable(String name) {
        for (Variable thisVariable : variables) {
            if (thisVariable.getName().equals(name)) {
                return thisVariable;
            }
        }
        // returns null if no match
        return null;
    }

    /**
     * Checks if variable with parameter name has been declared.
     *
     * @param name - name in question
     * @return - true if variable has been declared
     */
    public boolean isExistingVariable(String name) {
        for (Variable thisVariable : variables) {
            if (thisVariable.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
