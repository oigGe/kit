package georggross.calculations;

import georggross.input.InputChecker;
import georggross.ui.State;

public class Parser {

    public static Complex eval(final String str) {
        return new Object() {
            int pos = -1;
            int ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            boolean isNextChar(int thisChar) {
                return thisChar == str.charAt(pos + 1);
            }

            boolean isPrevChar(int thisChar) {
                return thisChar == str.charAt(pos - 1);
            }

            boolean isCorrectWhiteSPace() {
                int whiteSpace = ' ';
                return isPrevChar(whiteSpace) && isNextChar(whiteSpace);
            }

            Complex parse() {
                nextChar();
                Complex x = parseExpression();
                if (pos < str.length()) {
                    return null;
                }
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            Complex parseExpression() {
                Complex x = parseTerm();
                for (; ; ) {
                    if (eat('+')) {
                        Complex y = parseTerm(); // addition
                        if (x == null || y == null || !isCorrectWhiteSPace()) {
                            return null;
                        }
                        x = Addition.doAddition(x, y);
                    } else if (eat('-')) {
                        Complex y = parseTerm(); // subtraction
                        if (x == null || y == null || !isCorrectWhiteSPace()) {
                            return null;
                        }
                        x = Subtraction.doSubtraction(x, y);
                    } else return x;
                }
            }

            Complex parseTerm() {
                Complex x = parseFactor();
                for (; ; ) {
                    if (eat('*')) {
                        Complex y = parseFactor(); // multiplication
                        if (x == null || y == null || !isCorrectWhiteSPace()) {
                            return null;
                        }
                        x = Multiplication.doMultiplication(x, y);
                    } else if (eat('/')) {
                        Complex y = parseFactor(); // division
                        if (x == null || y == null || !isCorrectWhiteSPace()) {
                            return null;
                        }
                        x = Division.doDivision(x, y);
                    } else return x;
                }
            }

            Complex parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return parseFactor(); // unary minus

                Complex x;
                int startPos = this.pos;
                if (eat('[')) { // parentheses
                    if (ch == ' ') {
                        return null;
                    }
                    x = parseExpression();
                    eat(']');
                    if (str.charAt(pos - 2) == ' ') {
                        return null;
                    }
                } else if (ch == '(') { // numbers
                    while (ch != ')') nextChar();
                    // To include the closing bracket
                    nextChar();
                    String complexString = str.substring(startPos, this.pos);
                    //check for correct complex regex here!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                    if (!InputChecker.isValidComplexString(complexString)) {
                        return null;
                    }
                    x = new Complex(complexString);

                } else if (Character.isJavaIdentifierStart(ch)) { // variable
                    while (Character.isJavaIdentifierPart(ch)) nextChar();
                    String variableName = str.substring(startPos, this.pos);
                    if (State.getInstance().getVariableCatalog().isExistingVariable(variableName)) {
                        x = State.getInstance().getVariableCatalog().getVariable(variableName).getComplex();
                    } else {
                        x = null;
                    }
                } else {
                    return null;
                }


                return x;
            }
        }.parse();
    }
}
