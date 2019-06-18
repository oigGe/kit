package georggross;

public final class Inspector {

    //    Utility class. Therefore private constructor.
    private Inspector() {
    }

    /**
     * Check if the Serial is of the required form with two letters i the beginning
     * followed only by digits.
     *
     * @param input string containing the serial number.
     * @return boolean, true if two digits in the beginning followed only by numbers.
     */
    public static boolean isValidSerial(String input) {

        for (int i = 0; i < 2; i++) {
            char temp = input.charAt(i);
            if (Character.isDigit(temp)) {
                return false;
            }
        }

        for (int i = 2; i < input.length(); i++) {
            char temp = input.charAt(i);
            if (Character.isLetter(temp)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if the serial number has eleven characters.
     *
     * @param input serial number as String
     * @return boolean, true if input has eleven characters-
     */
    public static boolean hasElevenChars(String input) {
        if (countDigits(input) == 11) {
            return true;
        }
        return false;
    }

    /**
     * Cheeck if the serial number has twelve characters.
     *
     * @param input serial number as String.
     * @return boolean, true if input has twelve characters.
     */
    public static boolean hasTwelveChars(String input) {
        if (countDigits(input) == 12) {
            return true;
        }
        return false;
    }

    // Count digits of String
    private static int countDigits(String input) {
        return input.length();
    }
}
