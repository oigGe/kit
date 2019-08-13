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
            String input = Terminal.readLine();
            if (InputChecker.isQuitCommand(input)) {
                processQuitCommand();
                break;
            } else if (InputChecker.isValidAssignementCommand(input)) {
                Terminal.printLine(processAssignmentCommand(input));
            } else if (InputChecker.isInvalidAssignmentCommand(input)) {
                Terminal.printLine(ErrorCatalog.INVALID_ASSIGNMENT_COMMAND);
            } else if (InputChecker.isVariableCommand(input)) {
                Terminal.printLine(processVariableCommand(input));
            } else {
                Terminal.printError(ErrorCatalog.INVALID_INPUT_MESSAGE);
            }
        }
    }


    private static String processAssignmentCommand(String assignmentString) {
        String expressionString = InputChecker.getExpressionString(assignmentString);
        if (!InputChecker.isValidExpressionString(expressionString)) {
            return ErrorCatalog.INVALID_EXPRESSION_MESSAGE;
        }
        String variableName = InputChecker.getVariableName(assignmentString);
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
}
