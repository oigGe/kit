package georggross.cataloges;

public class JavaKeywordCatalog {
   // quit is not a java keyword but is included here anyway
    private static final String KEYWORDS[] = {
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
            "while","quit"
    };

    public static boolean isKeyword(String input) {
        for (String keyword : KEYWORDS) {
            if (keyword.equals(input)) {
                return true;
            }
        }
        return false;
    }
}
