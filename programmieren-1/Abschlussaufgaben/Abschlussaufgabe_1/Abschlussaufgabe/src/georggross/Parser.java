package georggross;

import georggross.calculations.Addition;
import georggross.calculations.Division;
import georggross.calculations.Multipliction;
import georggross.calculations.Subtraction;
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

            Complex parse() {
                nextChar();
                Complex x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Error, Unexpected: " + (char) ch);
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
                        x = Addition.doAddition(x, y);
                    } else if (eat('-')) {
                        Complex y = parseTerm(); // subtraction
                        x = Subtraction.doSubtraction(x, y);
                    } else return x;
                }
            }

            Complex parseTerm() {
                Complex x = parseFactor();
                for (; ; ) {
                    if (eat('*')) {
                        Complex y = parseFactor(); // multiplication
                        x = Multipliction.doMultiplication(x, y);
                    } else if (eat('/')) {
                        Complex y = parseFactor(); // division
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
                    x = parseExpression();
                    eat(']');
                } else if (ch == '(') { // numbers
                    while (ch != ')') nextChar();
                    // To include the closing bracket
                    nextChar();
                    String complexString = str.substring(startPos, this.pos);
                    x = new Complex(complexString);


                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String variableName = str.substring(startPos, this.pos);

                    x = State.getInstance().getVariableCatalog().getVariable(variableName).getComplex();
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }


                return x;
            }
        }.parse();
    }


}
