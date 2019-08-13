package georggross.cataloges;

public enum RegexCatalog {
    /**
     * Regex matching assignment command.
     */
    INVALID_ASSIGNMENT_COMMAND_REGEX(".*=.*"),
    /**
     * Regex matching assignment command with valid java identitfier.
     * The expression will be checked in the parser.
     */
    VALID_ASSIGNMENT_REGEX("^[\\$_a-zA-Z]+[\\$_\\w]* = .*"),
    /**
     * Regex with group one matching the variable name.
     */
    GET_VARIABLE_NAME_REGEX("(^[\\$_a-zA-Z]+[\\$_\\w]*)(.*)"),
    /**
     * Regex with group two matching the expression.
     */
    GET_EXPRESSION_REGEX(".*(= )(.*)"),
    /**
     * Regex matching the required input format of complex numbers.
     */
    COMPLEX_REGEX("(\\()(-?\\d+)( \\+ )(-?\\d+)(i\\))"),
    /**
     * Regex matching a valid java identifier.
     */
    JAVA_IDENTIFIER_REGEX("^[\\$_a-zA-Z]+[\\$_\\w]*$");

    /**
     * value of variable name group in GET_VARIABLE_NAME_REGEX.
     */
    public static final int VARIABLE_NAME_GROUP = 1;

    /**
     * value of expression group in GET_EXPRESSION.
     */
    public static final int EXPRESSION_GROUP = 2;

    private String regexName;


    /**
     * Creates a new regex.
     *
     * @param regexName - name of the regex to be created
     */
    RegexCatalog(String regexName) {
        this.regexName = regexName;
    }

    /**
     * Returns the regex
     *
     * @return - regex as String
     */
    public String getRegex() {
        return regexName;
    }
}
