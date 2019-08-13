package georggross.input;

import georggross.cataloges.ErrorCatalog;
import georggross.cataloges.JavaKeywordCatalog;
import georggross.cataloges.RegexCatalog;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Checks user input
 *
 * @author Georg Gross
 * @version 1.0
 */
public final class InputChecker {

    /**
     * Checks if input is invalid assignment.
     * This will be called if input contains an equal sign.
     *
     * @param input - input in question
     * @return - true if assignemt is of invalid format.
     */
    public static boolean isInvalidAssignmentCommand(String input) {
        if (!input.matches(RegexCatalog.INVALID_ASSIGNMENT_COMMAND_REGEX.getRegex())) {
            return false;
        }
        return true;
    }

    /**
     * Checks if input is a valid Assignment.
     * Does not check the expression content, this will be done in the parser.
     * Checks for whitespaces for and after the equal sign and valid identifier.
     *
     * @param input - assignment in question
     * @return - true if the conditions described above are met
     */
    public static boolean isValidAssignementCommand(String input) {
      boolean matches = input.matches(RegexCatalog.VALID_ASSIGNMENT_REGEX.getRegex());
      boolean correctWhiteSpace = !hasMoreThanOneConsecutiveWhitepace(input);
      return matches && correctWhiteSpace;
    }

    /**
     * Checks if input is variable command
     *
     * @param input - input in question
     * @return - returns if input is valid java identifier
     */
    public static boolean isVariableCommand(String input) {
        return isValidVariableName(input);
    }

    /**
     * Returns the the variable assigned by user input
     *
     * @param assignmentString - user input
     * @return - name of the variable assigned
     */
    public static String getVariableName(String assignmentString) {
        Pattern pattern = Pattern.compile(RegexCatalog.GET_VARIABLE_NAME_REGEX.getRegex());
        Matcher matcher = pattern.matcher(assignmentString);
        if (matcher.matches()) {
            return matcher.group(RegexCatalog.VARIABLE_NAME_GROUP);
        }
        return null;
    }

    /**
     * Checks if variable name is valid java identifier and not a java keyword.
     *
     * @param input - variable name in question
     * @return - true if the conditions decribed above have been met
     */
    public static boolean isValidVariableName(String input) {
        boolean cond1 = input.matches(RegexCatalog.JAVA_IDENTIFIER_REGEX.getRegex());
        boolean cond2 = JavaKeywordCatalog.isKeyword(input);
        return cond1 && !cond2;
    }

    /**
     * Checks for quit command
     *
     * @param input - user input
     * @return - true if input is "quit"
     */
    public static boolean isQuitCommand(String input) {
        if (input.equals("quit")) {
            return true;
        }
        return false;
    }

    /**
     * Checks user input and returns expression as String
     *
     * @param input - user input
     * @return - expression String, null if no match
     */
    public static String getExpressionString(String input) {
        Pattern pattern = Pattern.compile(RegexCatalog.GET_EXPRESSION_REGEX.getRegex());
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return matcher.group(RegexCatalog.EXPRESSION_GROUP);
        }
        return null;

    }

    /**
     * Checks if expression extracted from user input has valid number of brackets.
     * The correct
     *
     * @param input
     * @return
     */
    public static String getExpressionError(String input) {
        boolean cond1 = hasValidBrackets(input);
        boolean cond2 = isLastCharSpace(input);
        boolean cond3 = hasMoreThanOneConsecutiveWhitepace(input);
        if (!cond1) {
            return ErrorCatalog.INVALID_BRACKETS_MESSAGE.getErrorMessage();
        } else if (cond2) {
            return ErrorCatalog.INVALID_WHITESPACE_MESSAGE.getErrorMessage();
        }else if (cond3){
            return ErrorCatalog.INVALID_WHITESPACE_MESSAGE.getErrorMessage();
        }
        return null;
    }

    private static boolean hasMoreThanOneConsecutiveWhitepace(String input) {
        char prevChar = '1';
        boolean condition;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                if (prevChar == ' ') {
                    return true;
                }
            }
            prevChar = input.charAt(i);

        }
        return false;
    }

    private static boolean isLastCharSpace(String input) {
        return input.charAt(input.length() - 1) == ' ';
    }

    public static boolean isValidComplexString(String input) {
        return input.matches(RegexCatalog.COMPLEX_REGEX.getRegex());
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
