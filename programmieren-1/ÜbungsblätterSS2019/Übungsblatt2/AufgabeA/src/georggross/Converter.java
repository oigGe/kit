package georggross;

import edu.kit.informatik.Terminal;

/**
 * Converter converts the rgb value to cmyk
 */
public final class Converter {
    // Utility class. Therefore private constructor.
    private Converter() {

    }


    // calculate the values for C,M,Y.
    private static double calcCMY(int rgbValue, double w) {
        return (w - (rgbValue / 255.0)) / w;
    }

    // calculate the key value.
    private static double calcKey(double w) {
        return 1 - w;
    }


    //      calcualte the w value.
    private static double calcW(int r, int g, int b) {
        int[] rgbArray = {r, g, b};
        double max = r;
        for (int i = 0; i < rgbArray.length; i++) {
            if (rgbArray[i] > max) {
                max = rgbArray[i];
            }
        }
        return max / 255.0;
    }


    //      round the output values.
    private static double round(double value) {
        double tempDouble = Math.pow(10, 4);
        return Math.round(value * tempDouble) / tempDouble;
    }

    /**
     * read the rgb values from the input String by splitting it.
     * calculate the necessary CMYK values.
     * check if values are valid with the isValidRgb method.
     * if the input is of invalid type print error message.
     *
     * @param input String from user input
     */
    public static void convert(String input) {
        int r = 0;
        int g = 0;
        int b = 0;
        String inputParts[] = input.split(" ");
        String values[] = inputParts[1].split(";");
        try {
            r = Integer.parseInt(values[0]);
            g = Integer.parseInt(values[1]);
            b = Integer.parseInt(values[2]);
            if (isValidRgb(r) && isValidRgb(g) && isValidRgb(b)) {
                double w = calcW(r, g, b);
                double cyan = round(calcCMY(r, w));
                double magenta = round(calcCMY(g, w));
                double yellow = round(calcCMY(b, w));
                double key = round(calcKey(w));

                if (w == 0) {
                    cyan = 0;
                    magenta = 0;
                    yellow = 0;
                    key = 1;
                }
                Terminal.printLine(formatedValue(cyan) + ";" + formatedValue(yellow) + ";"
                        + formatedValue(magenta) + ";" + formatedValue(key));
            } else {
                Terminal.printLine("Error, incorrect rgb Value.");
            }
        } catch (NumberFormatException e) {
            Terminal.printLine("Error, not a valid number.");
        }

    }


//      check if the rgb values are valid.

    private static boolean isValidRgb(int rgbValue) {
        if (rgbValue >= 0 && rgbValue <= 255) {
            return true;
        }
        return false;
    }


//      format the output to the required form

    private static String formatedValue(double value) {
        return String.format("%.4f", value);
    }
}
