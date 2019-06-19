package georggross;

/**
 * Formates user input and parses it.
 *
 * @author Georg Gross
 * @version 1.0
 */
public class InputFormat {

    /**
     * Returns the start values from user input.
     *
     * @param input  - User input.
     * @param player - Which user.
     * @return - Array of stone values.
     */
    public static int[] playerStartValues(String input, int player) {
        String[] startValuesParts = getStartValueParts(input);
        String[] playerAStartValuesString = startValuesParts[player].split(",");
        return toIntArray(playerAStartValuesString);
    }

    //    Splits user input to get the stone values from start command
    private static String[] getStartValueParts(String input) {
        String[] inputParts = input.split(" ");
        return inputParts[1].split(";");
    }

    //    Parses a String array to an int array
    private static int[] toIntArray(String[] input) {
        int[] playerStartValues = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            playerStartValues[i] = Integer.parseInt(input[i]);
        }
        return playerStartValues;
    }

    /**
     * Returns an array with coordinates from print-cell command.
     *
     * @param input - User input.
     * @return - Array with coordinates.
     */
    public static int[] getCellCoordinates(String input) {
        String[] inputParts = input.split(" ");
        String[] coordinateParts = inputParts[1].split(";");
        return toIntArray(coordinateParts);
    }

    /**
     * Returns the roll value frome roll command.
     *
     * @param input - User input.
     * @return - Int value of roll command.
     */
    public static int getRoll(String input) {
        String[] inputParts = input.split(" ");
        return Integer.parseInt(inputParts[1]);
    }

    /**
     * Returns stone value of the stone specified in the move command.
     *
     * @param input - User input.
     * @return - Int value of stone.
     */
    public static int getStoneToMove(String input) {
        String[] inputParts = input.split(" ");
        String[] valuesParts = inputParts[1].split(",");
        return Integer.parseInt(valuesParts[0]);
    }

    /**
     * Returns the destination coordinates of stone moved by the move command.
     *
     * @param input - User input.
     * @return - Array with coordinates.
     */
    public static int[] getStoneMoveCoordinates(String input) {
        String[] inputParts = input.split(" ");
        String[] valuesParts = inputParts[1].split(",");
        String[] coordinateParts = valuesParts[1].split(";");
        return toIntArray(coordinateParts);
    }

    /**
     * Adjusts a number correspondant to th board size in torus mode.
     *
     * @param number - Number to be adjusted.
     * @param app    - Program state.
     * @return - Adjusted number.
     */
    public static int adjustNumber(int number, App app) {
        int mod = app.getSize();
        int adjustedNumber = number;
        if (number < 0) {
            adjustedNumber = (mod + (number % mod)) % mod;
        } else {
            adjustedNumber %= mod;
        }
        return adjustedNumber;
    }
}


