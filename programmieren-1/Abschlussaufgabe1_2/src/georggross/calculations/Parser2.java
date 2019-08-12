package georggross.calculations;

import georggross.cataloges.ErrorCatalog;
import georggross.input.InputChecker;
import georggross.ui.State;

public class Parser2 {

    private final int STARTTING_POSITION = -1;
    private int position;
    private int thisChar;
    private String expression;
    private String errorMessage;
    private Complex solution;

    public Parser2(String expression) {
        this.expression = expression;
        this.position = STARTTING_POSITION;
    }

    public Complex parse() {
        nextChar();
        solution = parseExpression();
        if (position < expression.length()) {
            setErrorMessage(ErrorCatalog.INVALID_EXPRESSION_MESSAGE);
            return null;
        }
        return solution;
    }

    private Complex parseExpression() {
        int operatorPosition;
        Complex complex = parseTerm();
        boolean isParsing = true;
        while (isParsing) {
            //Addition
            if (crawl('+')) {
                operatorPosition = position - 1;
                Complex nextComplex = parseTerm(); //
                if (isStop(complex, nextComplex, operatorPosition)) {
                    return null;
                }
                complex = Addition.doAddition(complex, nextComplex);
            }
            //Subtraction
            else if (crawl('-')) {
                operatorPosition = position - 1;
                Complex nextComplex = parseTerm();
                if (isStop(complex, nextComplex, operatorPosition)) {
                    return null;
                }
                complex = Subtraction.doSubtraction(complex, nextComplex);
            } else {
                isParsing = false;
            }
        }
        return complex;
    }

    private Complex parseTerm() {
        int operatorPosition;
        Complex complex = parseFactor();
        boolean isParsing = true;
        while (isParsing) {
            //Multiplication
            if (crawl('*')) {
                operatorPosition = position - 1;
                Complex nextComplex = parseFactor();
                if (isStop(complex, nextComplex, operatorPosition)) {
                    return null;
                }
                complex = Multiplication.doMultiplication(complex, nextComplex);
            }
            //Division
            else if (crawl('/')) {
                operatorPosition = position - 1;
                Complex y = parseFactor();
                if (isStop(complex, y, operatorPosition)) {
                    return null;
                }
                complex = Division.doDivision(complex, y);
            } else {
                isParsing = false;
            }
        }
        return complex;
    }

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

                setErrorMessage(ErrorCatalog.INVALID_WHITESPACE_MESSAGE);
                return null;
            }
            complex = parseExpression();
            crawl(']');
            if (expression.charAt(position - 2) == ' ') {

                setErrorMessage(ErrorCatalog.INVALID_WHITESPACE_MESSAGE);
                return null;
            }
//            Complex
        } else if (thisChar == '(') {
            while (thisChar != ')') nextChar();
            // To include the closing bracket
            nextChar();
            String complexString = expression.substring(startPos, this.position);
            if (!InputChecker.isValidComplexString(complexString)) {
                setErrorMessage(ErrorCatalog.INVALID_COMPLEX_MESSAGE + complexString);
                return null;
            }
            complex = new Complex(complexString);

        }
//        Variable
        else if (Character.isJavaIdentifierStart(thisChar)) {
            while (Character.isJavaIdentifierPart(thisChar)) nextChar();
            String variableName = expression.substring(startPos, this.position);
            if (State.getInstance().getVariableCatalog().isExistingVariable(variableName)) {
                complex = State.getInstance().getVariableCatalog().getVariable(variableName).getComplex();
            } else {
                setErrorMessage(ErrorCatalog.INVALID_VARIABLE_NAME_IN_EXPRESSION_MESSAGE + variableName);
                complex = null;
            }
        } else {
            return null;
        }


        return complex;
    }

    private void nextChar() {
        if (++position < expression.length()) {
            thisChar = expression.charAt(position);
        } else {
            thisChar = STARTTING_POSITION;
        }
    }

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

    private boolean isStop(Complex complex1, Complex complex2, int thisPosition) {
        boolean cond1 = complex1 == null;
        boolean cond2 = complex2 == null;
        boolean cond3 = !isCorrectWhiteSPace(thisPosition);
        if (!cond3) {
            errorMessage = ErrorCatalog.INVALID_WHITESPACE_MESSAGE;
        }
        return cond1 || cond2 || cond3;
    }

    private boolean isNextChar(int thisChar, int thisPosition) {
        if (thisPosition >= 0) {
            return thisChar == expression.charAt(thisPosition + 1);
        }
        return false;
    }

    private boolean isPrevChar(int thisChar, int thisPosition) {
        if (thisPosition - 1 >= 0) {
            return thisChar == expression.charAt(thisPosition - 1);
        }
        return false;
    }

    private boolean isCorrectWhiteSPace(int thisPosition) {
        int whiteSpace = ' ';
        return isPrevChar(whiteSpace, thisPosition) && isNextChar(whiteSpace, thisPosition);
    }

    public boolean hasErrorMessage() {
        return errorMessage != null;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    private void setErrorMessage(String errorMessage){
        if (this.errorMessage == null){
            this.errorMessage = errorMessage;
        }
    }
}

