package georggross;

public final class SumCalculator {

    //    Utility class. Therefor a private constructor.
    private SumCalculator() {
    }

    // Convert Character to an integer value.
    private static int letterToInt(char input) {
        input = Character.toUpperCase(input);
        int value = input - 'A' + 1;
        return value;
    }

    /**
     * calculate the cross sum of letters and digits in the serial number.
     * look for letters and converts them to int values using letterToInt().
     *
     * @param input String containing the serial number without check digit.
     * @return int value with cross sum of serial number.
     */
    public static int calcDigitSum(String input) {
        int checkSum = 0;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i))) {
                checkSum += letterToInt(input.charAt(i));
            } else {
                checkSum += input.charAt(i) - '0';
            }
        }
        return checkSum;
    }

    /**
     * calculate the check digit using the cross sum from calcDigitSum().
     *
     * @param input serial number as String without check digit.
     * @return the check digit for the cross sum from input.
     */
    public static int calcCheckSum(String input) {
        int checkSum = calcDigitSum(input);
        checkSum = checkSum % 9;
        checkSum = 7 - checkSum;
        if (checkSum == 0) {
            checkSum = 9;
        } else if (checkSum == -1) {
            checkSum = 8;
        }
        return checkSum;
    }

    /**
     * Calculate the check digit using calcChecksum() and compare it to the check digit in the serial number.
     * Extract the check digit from input.
     * Extract the Serial numbers required to calculate the check digit.
     *
     * @param input serial number as String including check digit.
     * @return boolean, true if the calculated checksum and the given check digit are identical.
     */
    public static boolean isValid(String input) {
        String validationNumber = input.substring(input.length() - 1);
        input = input.substring(0, input.length() - 1);
        if (calcCheckSum(input) == Integer.parseInt(validationNumber)) {
            return true;
        }
        return false;
    }


}
