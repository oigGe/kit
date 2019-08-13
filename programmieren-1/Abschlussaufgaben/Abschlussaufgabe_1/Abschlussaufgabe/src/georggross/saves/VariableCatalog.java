package georggross.saves;

import georggross.Variable;

import java.util.LinkedList;

public class Variables {

    private static Variables instance;
    private LinkedList<Variable> variables;

    private Variables() {
        variables = new LinkedList<>();
    }

    public static Variables getInstance() {
        if (Variables.instance == null) {
            Variables.instance = new Variables();
        }
        return Variables.instance;
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
}
