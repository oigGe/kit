package georggross;

public final class NarcissisticNumberChecker {

    //    Utility class. Therefore private constructor.
    private NarcissisticNumberChecker() {
    }

    /**
     * Checks if number of given base is narcissistic.
     * Calculates the number of digits in value.
     * Modulo 10 to get last digit.
     * Potentize last digit with number of digits in value.
     * Divide by ten to get rid of last digit.
     * Call systemConverter() to convert result into number system given by base
     * Compare result with original value.
     *
     * @param value int checked by isWithinBase containing user input to be checked for being narcissistic.
     * @param base  int indicating number system of int value.
     * @return boolean, true if narcissistic.
     */
    public static boolean isNarcisstic(int value, int base) {
        int points = pointCounter(value);

        int temp = value;
        int x;
        int y;
        int result = 0;
        while (temp > 0) {
            x = temp % 10;
            result += Math.pow(x, points);
            temp /= 10;
        }
        result = systemConverter(result, base);
        if (result == value) {
            return true;
        }

        return false;
    }

    /**
     * Calculates number of digits in int.
     *
     * @param value int to be counted.
     * @return int with number of digits in value.
     */
    public static int pointCounter(int value) {
        int count = 0;
        while (value > 0) {
            value /= 10;
            count++;
        }
        return count;
    }

    //    Converts decimal number to numbersystem given by base.
//    Base cannot be greater than 10.
    private static int systemConverter(int value, int base) {
        String result = "";
        int temp;
        while (value > 0) {
            temp = value % base;
            result = temp + result;
            value /= base;
        }
        return Integer.parseInt(result);
    }

    /**
     * Checks if a value is valid within a numeral system given by base.
     *
     * @param value int value to be checked if valid.
     * @param base  int value that defines numeral system.
     * @return boolean, true if the value is element of the numeral system.
     */
    public static boolean isWithinBase(int value, int base) {
        while (value > 0) {
            int temp = value % 10;
            if (temp >= base) {
                return false;
            }
            value /= 10;
        }
        return true;
    }
}
