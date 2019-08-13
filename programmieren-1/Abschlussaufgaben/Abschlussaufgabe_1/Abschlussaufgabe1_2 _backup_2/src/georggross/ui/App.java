package georggross.ui;

import edu.kit.informatik.Terminal;
import georggross.calculations.Complex;
import georggross.calculations.Parser;
import georggross.calculations.Variable;
import georggross.cataloges.ErrorCatalog;
import georggross.input.InputChecker;

public class App {

    private static boolean isRunning = true;


    public static void run() {

        while (isRunning) {
            String output = processInput(getInput());
            if (output == null){
                break;
            }
        }
    }


    public static String processInput(String input) {

        if (InputChecker.isQuitCommand(input)) {
            processQuitCommand();
            return null;
        } else if (InputChecker.isValidAssignementCommand(input)) {
            return processAssignmentCommand(input);
        } else if (InputChecker.isInvalidAssignmentCommand(input)) {
            return ErrorCatalog.INVALID_ASSIGNMENT_COMMAND;
        } else if (InputChecker.isVariableCommand(input)) {
            return processVariableCommand(input);
        } else {
            return ErrorCatalog.INVALID_INPUT_MESSAGE;
        }
    }


    private static String processAssignmentCommand(String assignmentString) {
        String expressionString = InputChecker.getExpressionString(assignmentString);
        String expressionError = InputChecker.isValidExpressionString(expressionString);
        if (expressionError != null) {
            return expressionError;
        }
        String variableName = InputChecker.getVariableName(assignmentString);
        if (variableName == null){
            return ErrorCatalog.INVALID_VARIABLE_NAME_MESSAGE;
        }
        if (!InputChecker.isValidVariableName(variableName)) {
            return ErrorCatalog.INVALID_VARIABLE_NAME_MESSAGE;
        }

        Variable thisVariable;
        Complex thisComplex = Parser.eval(expressionString);
        if (thisComplex == null) {
            return ErrorCatalog.INVALID_EXPRESSION_MESSAGE;
        }

        if (!georggross.ui.State.getInstance().getVariableCatalog().isExistingVariable(variableName)) {
            thisVariable = new Variable(variableName, thisComplex);
            State.getInstance().getVariableCatalog().addVariable(thisVariable);
            return thisVariable.toString();
        }
        thisVariable = State.getInstance().getVariableCatalog().getVariable(variableName);
        thisVariable.setComplex(thisComplex);
        return thisVariable.toString();
    }

    private static String processVariableCommand(String variableName) {

        if (State.getInstance().getVariableCatalog().isExistingVariable(variableName)) {
            return State.getInstance().getVariableCatalog().getVariable(variableName).toString();
        }
        return ErrorCatalog.NOT_EXISTING_VARIABLE_MESSAGE;
    }

    private static void processQuitCommand() {
        isRunning = false;
    }

    //    NEEDS TO BE TERMINAL CLASS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private static String getInput() {
        return Terminal.readLine();
    }
}