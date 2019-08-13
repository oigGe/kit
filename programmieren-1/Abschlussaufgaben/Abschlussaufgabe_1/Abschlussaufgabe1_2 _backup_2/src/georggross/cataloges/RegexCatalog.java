package georggross.cataloges;

public class RegexCatalog {
    public static final String INVALID_ASSIGNMENT_COMMAND_REGEX = ".*=.*";

    public static final String VALID_ASSIGNMENT_REGEX = "^[\\$_a-zA-Z]+[\\$_\\w]* = .*";

    public static final String GET_VARIABLE_NAME_REGEX = "(^[\\$_a-zA-Z]+[\\$_\\w]*)(.*)";

    public static final String GET_EXPRESSION_REGEX = ".*(= )(.*)";

    public static final String COMPLEX_REGEX = "(\\()(-?\\d+)( \\+ )(-?\\d+)(i\\))";

    public static final String JAVA_IDENTIFIER_REGEX = "^[\\$_a-zA-Z]+[\\$_\\w]*$";

    public static final int VARIABLE_NAME_GROUP = 1;

    public static final int EXPRESSION_GROUP = 2;




}
