package georggross.calculations;

import georggross.cataloges.ErrorCatalog;
import georggross.input.InputChecker;
import georggross.ui.State;

/**
 * Represents a pareser to interpret expressions
 *
 * @author Georg Gross
 * @version 1.0
 */
public class Parser {

    private static final int STARTTING_POSITION = -1;
    private int position;
    private int thisChar;
    private String expression;
    private String errorMessage;
    private Complex solution;

    /**
     * Creates a new Parser with a String representing an expression.
     *
     * @param expression - expression as String
     */
    public Parser(String expression) {
        this.expression = expression;
        this.position = STARTTING_POSITION;
    }

    /**
     * Parses the expression.
     * Returns the solution.
     *
     * @return - the solution of the expression as Complex.
     */
    public Complex parse() {
        nextChar();
        solution = parseAdditionAndSubtraction();
        if (position < expression.length()) {
            setErrorMessage(ErrorCatalog.INVALID_EXPRESSION_MESSAGE.getErrorMessage());
            return null;
        }
        return solution;
    }


    /**
     * Crawls over expression and checks for Addition and Subtraction.
     *
     * @return - returns solution as Complex.
     */
    private Complex parseAdditionAndSubtraction() {
        int operatorPosition;
        Complex complex = parseMultiplicationAndDivision();
        boolean isParsing = true;
        while (isParsing) {
            //Addition
            if (crawl('+')) {
                operatorPosition = position - 1;
                Complex nextComplex = parseMultiplicationAndDivision();
                Computable addition = new Addition();
                complex = computeThis(complex, nextComplex, addition, operatorPosition);
                if (complex == null) {
                    return null;
                }
            }
            //Subtraction
            else if (crawl('-')) {
                operatorPosition = position - 1;
                Complex nextComplex = parseMultiplicationAndDivision();
                Computable subtraction = new Subtraction();
                complex = computeThis(complex, nextComplex, subtraction, operatorPosition);
                if (complex == null) {
                    return null;
                }
            } else {
                isParsing = false;
            }
        }
        return complex;
    }

    /**
     * Crawls over exoression and checcks for Multiplication and Division.
     *
     * @return - returns solution as Complex.
     */
    private Complex parseMultiplicationAndDivision() {
        int operatorPosition;
        Complex complex = parseFactor();
        boolean isParsing = true;
        while (isParsing) {
            //Multiplication
            if (crawl('*')) {
                operatorPosition = position - 1;
                Complex nextComplex = parseFactor();
                Computable multiplication = new Multiplication();
                complex = computeThis(complex, nextComplex, multiplication, operatorPosition);
                if (complex == null) {
                    return null;
                }
            }
            //Division
            else if (crawl('/')) {
                operatorPosition = position - 1;
                Complex nextComplex = parseFactor();
                Computable division = new Division();
                complex = computeThis(complex, nextComplex, division, operatorPosition);
                if (complex == null) {
                    return null;
                }
            } else {
                isParsing = false;
            }
        }
        return complex;
    }

    /**
     * Crawls over expression and checks for bracktes and +,- signs.
     * Interprets substrings of expression as Complex and checks for the right input format.
     * Returns null if Complex has invalid input format.
     * Interprets substring of expression as identifiers.
     * Returns null if identifier is not correct java identifier or has not yet been declared as variable.
     *
     * @return - result as Complex or null in case of Error.
     */
    private Complex parseFactor() {
        // Plus sign
        if (crawl('+')) {
            return parseFactor();
        }
//        Minus sign
        if (crawl('-')) {
            return parseFactor();
        }
        Complex complex;

        int startPos = this.position;
//        Brackets
        if (crawl('[')) {
            if (thisChar == ' ') {
                setErrorMessage(ErrorCatalog.INVALID_WHITESPACE_MESSAGE.getErrorMessage());
                return null;
            }
            complex = parseAdditionAndSubtraction();
            crawl(']');
            if (expression.charAt(position - 2) == ' ') {
                setErrorMessage(ErrorCatalog.INVALID_WHITESPACE_MESSAGE.getErrorMessage());
                return null;
            }
//            Complex
        } else if (thisChar == '(') {
            while (thisChar != ')') nextChar();
            // To include the closing bracket
            nextChar();
            String complexString = expression.substring(startPos, this.position);
            if (!InputChecker.isValidComplexString(complexString)) {
                setErrorMessage(ErrorCatalog.INVALID_COMPLEX_MESSAGE.getErrorMessage() + complexString);
                return null;
            }
            complex = new Complex(complexString);

        }
//        Variable
        else if (Character.isJavaIdentifierStart(thisChar)) {
            while (Character.isJavaIdentifierPart(thisChar)) {
                nextChar();
            }
            String variableName = expression.substring(startPos, this.position);
            if (State.getInstance().getVariableCatalog().isExistingVariable(variableName)) {
                complex = State.getInstance().getVariableCatalog().getVariable(variableName).getComplex();
            } else {
                setErrorMessage(ErrorCatalog.INVALID_VARIABLE_NAME_IN_EXPRESSION_MESSAGE.getErrorMessage() + variableName);
                return null;
            }
        } else {
            return null;
        }


        return complex;
    }

    //    sets next position and thisChar
    private void nextChar() {
        if (++position < expression.length()) {
            thisChar = expression.charAt(position);
        } else {
            thisChar = STARTTING_POSITION;
        }
    }

    //    checks forr whitespaces and ignores them.
//    compares char values and returns true if parameter value equals the next char.
    private boolean crawl(int nextChar) {
        while (thisChar == ' ') {
            nextChar();
        }
        if (thisChar == nextChar) {
            nextChar();
            return true;
        }
        return false;
    }

    // checks if a ending condition for the parsing process has been met.
//    sets an error message if incorrect whitespace was found.
    private boolean isStop(Complex complex1, Complex complex2, int thisPosition) {
        boolean cond1 = complex1 == null;
        boolean cond2 = complex2 == null;
        boolean cond3 = !isCorrectWhiteSPace(thisPosition);
        if (cond3) {
            errorMessage = ErrorCatalog.INVALID_WHITESPACE_MESSAGE.getErrorMessage();
        }
        return cond1 || cond2 || cond3;

    }

    //    checks if next char in expression is of certain char value.
    private boolean isNextChar(int thisChar, int thisPosition) {
        if (thisPosition >= 0) {
            return thisChar == expression.charAt(thisPosition + 1);
        }
        return false;
    }

    //    checks if previous char in expression is of certain char value.
    private boolean isPrevChar(int thisChar, int thisPosition) {
        if (thisPosition - 1 >= 0) {
            return thisChar == expression.charAt(thisPosition - 1);
        }
        return false;
    }

    //    checks for correct whitespaces surrounding operators.
    private boolean isCorrectWhiteSPace(int thisPosition) {
        int whiteSpace = ' ';
        return isPrevChar(whiteSpace, thisPosition) && isNextChar(whiteSpace, thisPosition);
    }


    /**
     * Checks if error message has been assigned while parsing.
     *
     * @return - boolean if error message has been asigned.
     */
    public boolean hasErrorMessage() {
        return errorMessage != null;
    }

    /**
     * Returns the error message.
     *
     * @return - error message as String
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    // checks if error message has been assigned yet.
//    if false sets error message.
    private void setErrorMessage(String errorMessage) {
        if (this.errorMessage == null) {
            this.errorMessage = errorMessage;
        }
    }

    //    computes the opeartion assigned by computable.
//    returns null if ending conditions for parsing have been met.
//    returns the result of the operation.
    private Complex computeThis(Complex complex, Complex nextComplex, Computable computable, int operatorPosition) {
        if (isStop(complex, nextComplex, operatorPosition)) {
            return null;
        }
        computable.setComplex(complex, nextComplex);

        return computable.compute();
    }
}

