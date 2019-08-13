package georggross.cataloges;

/**
 * Holds all java keywords and checks if parameter is java keyword.
 *
 * @author Georg Gross
 * @version 1.0
 */
public final class JavaKeywordCatalog {
    /**
     * Contains all java keywords.
     * "quit" is not a java keyword but is included here anyway.
     */
    public static final String KEYWORDS[] = {
        "abstract", "assert", "boolean", "break", "byte", "case",
        "catch", "char", "class", "const", "continue",
        "default", "do", "double", "else", "extends",
        "false", "final", "finally", "float", "for",
        "goto", "if", "implements", "import", "instanceof",
        "int", "interface", "long", "native", "new",
        "null", "package", "private", "protected", "public",
        "return", "short", "static", "strictfp", "super",
        "switch", "synchronized", "this", "throw", "throws",
        "transient", "true", "try", "void", "volatile",
        "while", "quit"
    };

    /**
     * Checks if parameter String input is a java keyword.
     *
     * @param input - String to be checked
     * @return - true if String is java keyword
     */
    public static boolean isKeyword(String input) {
        for (String keyword : KEYWORDS) {
            if (keyword.equals(input)) {
                return true;
            }
        }
        return false;
    }
}
