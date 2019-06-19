package georggross;

public class InputFormat {

    public static int[] playerStartValues(String input, int player) {
        String[] startValuesParts = getStartValueParts(input);
        String[] playerAStartValuesString = startValuesParts[player].split(",");
        return toIntArray(playerAStartValuesString);
    }

    private static String[] getStartValueParts(String input) {
        String[] inputParts = input.split(" ");
        return inputParts[1].split(";");
    }

    private static int[] toIntArray(String[] input) {
        int[] playerStartValues = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            playerStartValues[i] = Integer.parseInt(input[i]);
        }
        return playerStartValues;
    }

    public static int[] getCellCoordinates(String input) {
        String[] inputParts = input.split(" ");
        String[] coordinateParts = inputParts[1].split(";");
        return toIntArray(coordinateParts);
    }

    public static int getRoll(String input) {
        String[] inputParts = input.split(" ");
        return Integer.parseInt(inputParts[1]);
    }

    public static int getStoneToMove(String input) {
        String[] inputParts = input.split(" ");
        String[] valuesParts = inputParts[1].split(",");
        return Integer.parseInt(valuesParts[0]);
    }

    public static int[] getStoneMoveCoordinates(String input) {
        String[] inputParts = input.split(" ");
        String[] valuesParts = inputParts[1].split(",");
        String[] coordinateParts = valuesParts[1].split(";");
        return toIntArray(coordinateParts);
    }

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


