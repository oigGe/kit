package georggross;

/**
 * Validator checks user input for commands
 */
public final class Validator {
    // Utility class. Therefore private constructor.
    private Validator() {

    }


    /**
     * divide the input string in parts seperated by " ".
     * check if the input has "convert" in the beginning.
     *
     * @param input String from user input
     * @return boolean. True if input equals "convert " in the beginning.
     */
    public static boolean isValidConvert(String input) {
        String inputParts[] = input.split(" ");
        if (inputParts[0].equals("convert") && inputParts.length == 2 && Validator.isValidpart2(inputParts[1])) {
            return true;
        }
        return false;
    }

    /**
     * check if the input has the required amount of ";"
     *
     * @param input for counting ";"
     * @return true if input has 2 ";". Else false.
     */
    private static boolean isValidpart2(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ';') {
                count++;
            }
        }
        if (count == 2) {
            return true;
        }
        return false;
    }

    /**
     * check if hte input is "quit"
     *
     * @param input String from user
     * @return boolean if input equals "quit"
     */
    public static boolean isValidQuit(String input) {
        return input.equals("quit");
    }

}
