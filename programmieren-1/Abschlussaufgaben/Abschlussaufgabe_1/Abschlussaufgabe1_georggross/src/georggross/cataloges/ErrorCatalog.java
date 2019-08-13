package georggross.cataloges;

/**
 * Contains error messages.
 *
 * @author Georg Gross
 * @version 1.0
 */
public enum ErrorCatalog {
    /**
     * Error message for invalid input.
     */
    INVALID_INPUT_MESSAGE("Error, invalid input."),
    /**
     * Error message for invaldi expression.
     */
    INVALID_EXPRESSION_MESSAGE("Error, invalid expression."),
    /**
     * Error message fort invalid variable name
     */
    INVALID_VARIABLE_NAME_MESSAGE("Error, invalid variable name."),
    /**
     * Error message for not declared variable
     */
    NOT_EXISTING_VARIABLE_MESSAGE("Error, variable not declared."),
    /**
     * Error message for invalid assignment.
     */
    INVALID_ASSIGNMENT_COMMAND("Error, invalid assignment."),
    /**
     * Error message for invalid whitespace input.
     */
    INVALID_WHITESPACE_MESSAGE("Error, invalid whitespace input."),
    /**
     * Error message for invalid complex format.
     */
    INVALID_COMPLEX_MESSAGE("Error, invalid complex format: "),
    /**
     * Error message for invalid variable name.
     */
    INVALID_VARIABLE_NAME_IN_EXPRESSION_MESSAGE("Error, variable not declared: "),
    /**
     * Error message for invalid number of brackets.
     */
    INVALID_BRACKETS_MESSAGE("Error, invalid number of brackets.");


    private String errorMessage;

    /**
     * Creates a new error Message.
     *
     * @param errorMessage - error message name
     */
    ErrorCatalog(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Returns error message.
     *
     * @return - error message as String
     */
    public String getErrorMessage() {
        return errorMessage;
    }
}
