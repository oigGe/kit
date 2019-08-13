package georggross.ui;

import edu.kit.informatik.Terminal;
import georggross.calculations.Complex;
import georggross.calculations.Parser;
import georggross.calculations.Variable;
import georggross.cataloges.ErrorCatalog;
import georggross.input.InputChecker;

/**
 * Represents the ui.
 * Accepts user input and prints output.
 *
 * @author Georg Gross
 * @version 1.0
 */
public class App {

    private static boolean isRunning = true;


    /**
     * Starts up the application.
     * Contains the main loop
     * breaks if quit is entered.
     */
    public static void run() {

        while (isRunning) {
            String output = processInput(getInput());
            if (isRunning) {
                Terminal.printLine(output);
            }
            if (output == null) {
                break;
            }
        }
    }


    /**
     * Looks for valid command is user input and passes it on to relevant methods
     *
     * @param input - user input
     * @return - result of the user input. Error message if user input was not valid
     */
    public static String processInput(String input) {

        if (InputChecker.isQuitCommand(input)) {
            processQuitCommand();
            return null;
        } else if (InputChecker.isValidAssignementCommand(input)) {
            return processAssignmentCommand(input);
        } else if (InputChecker.isInvalidAssignmentCommand(input)) {
            return ErrorCatalog.INVALID_ASSIGNMENT_COMMAND.getErrorMessage();
        } else if (InputChecker.isVariableCommand(input)) {
            return processVariableCommand(input);
        } else {
            return ErrorCatalog.INVALID_INPUT_MESSAGE.getErrorMessage();
        }
    }


    /**
     * Processes an assignment input
     * Checks if the Expression is valid.
     * If it is valid and the variable has not yet declared it creates a new variable with the
     * result of the expression as value.
     * If the variable already exists, its value is reassigned.
     * In both cases a string with variable name and variable value is returned.
     * If the expression is invalid an error message is returned.
     *
     * @param assignmentString - assignment input from user
     * @return - variable string or error message
     */
    private static String processAssignmentCommand(String assignmentString) {
        String expressionString = InputChecker.getExpressionString(assignmentString);
        String expressionError = InputChecker.getExpressionError(expressionString);
        if (expressionError != null) {
            return expressionError;
        }
        String variableName = InputChecker.getVariableName(assignmentString);
        if (variableName == null) {
            return ErrorCatalog.INVALID_VARIABLE_NAME_MESSAGE.getErrorMessage();
        }
        if (!InputChecker.isValidVariableName(variableName)) {
            return ErrorCatalog.INVALID_VARIABLE_NAME_MESSAGE.getErrorMessage();
        }

        Variable thisVariable;
        Parser parser = new Parser(expressionString);
        Complex thisComplex = parser.parse();
        if (thisComplex == null && parser.hasErrorMessage()) {
            return parser.getErrorMessage();
        }
        if (thisComplex == null) {
            return ErrorCatalog.INVALID_EXPRESSION_MESSAGE.getErrorMessage();
        }

        if (!State.getInstance().getVariableCatalog().isExistingVariable(variableName)) {
            thisVariable = new Variable(variableName, thisComplex);
            State.getInstance().getVariableCatalog().addVariable(thisVariable);
            return thisVariable.toString();
        }
        thisVariable = State.getInstance().getVariableCatalog().getVariable(variableName);
        thisVariable.setComplex(thisComplex);
        return thisVariable.toString();
    }

    /**
     * Checks if the variable has been initiated.
     * In this case a String with the variable name and value is returned.
     * If the variable has not yet been initialized an error message is returned.
     *
     * @param variableName - user input of variable name
     * @return - varaible to String or error message
     */
    private static String processVariableCommand(String variableName) {

        if (State.getInstance().getVariableCatalog().isExistingVariable(variableName)) {
            return State.getInstance().getVariableCatalog().getVariable(variableName).toString();
        }
        return ErrorCatalog.NOT_EXISTING_VARIABLE_MESSAGE.getErrorMessage();
    }

    private static void processQuitCommand() {
        isRunning = false;
    }

    private static String getInput() {
        return Terminal.readLine();
    }
}