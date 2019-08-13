package georggross.cataloges;

import georggross.calculations.Variable;

import java.util.LinkedList;



public class VariableCatalog {
    private LinkedList<Variable> variables;

    public VariableCatalog() {
        variables = new LinkedList<>();
    }


    public void addVariable(Variable newVariable) {
        variables.add(newVariable);
    }

    public Variable getVariable(String name) {
        for (Variable thisVariable : variables) {
            if (thisVariable.getName().equals(name)) {
                return thisVariable;
            }
        }
        // returns null if no match
        return null;
    }

    public boolean isExistingVariable(String name) {
        for (Variable thisVariable : variables) {
            if (thisVariable.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
