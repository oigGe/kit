package georggross;

import edu.kit.informatik.Terminal;

public class Main {
    /**
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        while (true) {
            String input = Terminal.readLine();
            String[] inputParts = input.split(" ");
            if (inputParts[0].equals("check-narcissistic-number")) {
                check(inputParts[1]);
            } else if (inputParts[0].equals("quit")) {
                break;
            } else {
                Terminal.printLine("Error, invalid command");
            }
        }

    }

    //    Handles the check-narcissistic-number command.
//    Tries to parse the required values from input String.
//    Checks if the values are positive.
//    Checks if the base is within the required interval.
//    Checks if value has the required amount of digits.
//    Calls isWithinBase() to check if value is within the required set defined by base.
//    Calls isNarcissistic() and prints the result as boolean.
    private static void check(String input) {
        String[] inputValues = input.split(";");
        try {
            int value = Integer.parseInt(inputValues[0]);
            int base = Integer.parseInt(inputValues[1]);
            int points = NarcissisticNumberChecker.pointCounter(value);

            if (value >= 0 && base >= 0) {
                if (base <= 10) {
                    if (points < 2 || points > 8) {
                        Terminal.printLine("Error, valid value must have at least 2, up to 8 digits.");
                    } else if (NarcissisticNumberChecker.isWithinBase(value, base)) {
                        Terminal.printLine(NarcissisticNumberChecker.isNarcisstic(value, base));
                    } else {
                        Terminal.printLine("Error, value is not within the requested numeral system.");

                    }
                } else {
                    Terminal.printLine("Error, base number is not element of [2,10] ");
                }
            } else {
                Terminal.printLine("Error, input values are not natural numbers.");
            }
        } catch (NumberFormatException e) {
            Terminal.printLine("Error, input is not of the required norm.");
        }


    }

}
