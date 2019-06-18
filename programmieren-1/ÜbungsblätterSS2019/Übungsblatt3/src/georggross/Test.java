package georggross;

import edu.kit.informatik.Terminal;

public class Test {
    public static void main(String[] args) {

        String string="haalodqwwqdqw";
        isValidText(string);

    }

    private static boolean isValidText(String input) {
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == 10 || currentChar == '\t' || currentChar == 32) {
                Terminal.printError("text: \"" + input + "\" has invalid characters");
                return false;
            }
        }
        return true;
    }
}