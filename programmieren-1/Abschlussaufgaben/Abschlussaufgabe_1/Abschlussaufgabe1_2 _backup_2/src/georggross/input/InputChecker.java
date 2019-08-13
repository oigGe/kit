package georggross.input;

import georggross.cataloges.ErrorCatalog;
import georggross.cataloges.JavaKeywordCatalog;
import georggross.cataloges.RegexCatalog;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputChecker {

    public static boolean isInvalidAssignmentCommand(String input) {
        //can be simplified
        if (!input.matches(RegexCatalog.INVALID_ASSIGNMENT_COMMAND_REGEX)) {
            return false;
        }
        return true;
    }

    public static boolean isValidAssignementCommand(String input) {
        return input.matches(RegexCatalog.VALID_ASSIGNMENT_REGEX);
    }

    public static boolean isVariableCommand(String input) {
        return isValidVariableName(input);
    }

    public static String getVariableName(String assignmentString) {
        Pattern pattern = Pattern.compile(RegexCatalog.GET_VARIABLE_NAME_REGEX);
        Matcher matcher = pattern.matcher(assignmentString);
        if (matcher.matches()) {
            return matcher.group(RegexCatalog.VARIABLE_NAME_GROUP);
        }
        return null;
    }

    public static boolean isValidVariableName(String input) {
        boolean cond1 = input.matches(RegexCatalog.JAVA_IDENTIFIER_REGEX);
        boolean cond2 = JavaKeywordCatalog.isKeyword(input);
        return cond1 && !cond2;
    }

    public static boolean isQuitCommand(String input) {
        if (input.equals("quit")) {
            return true;
        }
        return false;
    }

    public static String getExpressionString(String input) {
        Pattern pattern = Pattern.compile(RegexCatalog.GET_EXPRESSION_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return matcher.group(RegexCatalog.EXPRESSION_GROUP);
        }
        return null;

    }

    public static String isValidExpressionString(String input) {
        boolean cond1 = hasValidBrackets(input);
        boolean cond2 = isLastCharSpace(input);
        if (!cond1) {
            return ErrorCatalog.INVALID_BRACKETS_MESSAGE;
        } else if (cond2) {
//            TEEEEEEEEEEEEEEEEEEEEEEEEEEEEEST
            System.out.println("this was called");
            return ErrorCatalog.INVALID_WHITESPACE_MESSAGE;
        }
        return null;
    }

    private static boolean isLastCharSpace(String input) {
        return input.charAt(input.length() - 1) == ' ';
    }

    public static boolean isValidComplexString(String input) {
        return input.matches(RegexCatalog.COMPLEX_REGEX);
    }


    private static boolean hasValidBrackets(String input) {
        boolean validBrackets = countCharOccurence('(', input) == countCharOccurence(')', input);
        boolean validSquareBRackets = countCharOccurence('[', input) == countCharOccurence(']', input);
        return validBrackets && validSquareBRackets;

    }

    private static int countCharOccurence(char thisChar, String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == thisChar) {
                count++;
            }
        }
        return count;
    }
}
