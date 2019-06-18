package georggross;

import edu.kit.informatik.Terminal;

public class Main {
    /**
     * @param args command line arguments
     */
    public static void main(String[] args) {


        while (true) {
            String input = Terminal.readLine();
            String[] inputParts = input.split(" ");

            if (inputParts[0].equals("digitsum")) {
                processDigitSum(inputParts[1]);
            } else if (inputParts[0].equals("checksum")) {
                processCheckSum(inputParts[1]);
            } else if (inputParts[0].equals("isValid")) {
                processIsValid(inputParts[1]);
            } else if (input.equals("quit")) {
                break;
            } else {
                Terminal.printLine("Error, invalid input");
            }
        }
    }

    // Handle the input in case of digitsum.
    // Check if the serial number lenght is correct.
    // Check if the letters and digits are in correct order.
    private static void processDigitSum(String input) {
        if (Inspector.hasElevenChars(input)) {
            if (Inspector.isValidSerial(input)) {
                Terminal.printLine(SumCalculator.calcDigitSum(input));
            } else {
                printCharacterError();
            }
        } else {
            printSerialError();
        }
    }

    // Handle the input in case of checksum.
    // Check if the serial number lenght is correct.
    // Check if the letters and digits are in correct order.
    private static void processCheckSum(String input) {
        if (Inspector.hasElevenChars(input)) {
            if (Inspector.isValidSerial(input)) {
                Terminal.printLine(SumCalculator.calcCheckSum(input));
            } else {
                printCharacterError();
            }
        } else {
            printSerialError();
        }
    }

    // Handle the input in case of isValid.
    // Check if the serial number lenght is correct.
    // Check if the letters and digits are in correct order.
    private static void processIsValid(String input) {
        if (Inspector.hasTwelveChars(input)) {
            if (Inspector.isValidSerial(input)) {
                Terminal.printLine(SumCalculator.isValid(input));
            } else {
                printCharacterError();
            }
        } else {
            printSerialError();
        }
    }

    // Print Error messages.
    private static void printSerialError() {
        Terminal.printLine("Error, serial number length incorrect");
    }

    private static void printCharacterError() {
        Terminal.printLine("Error, serial number characters incorrect");
    }
}
