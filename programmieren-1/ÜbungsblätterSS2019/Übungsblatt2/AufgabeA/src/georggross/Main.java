package georggross;

import edu.kit.informatik.Terminal;

/**
 * Main accepts user input and calls methods to convert rgb to cmyk values
 */
public class Main {
    /**
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        while (true) {
            String input = Terminal.readLine();

            if (Validator.isValidConvert(input)) {
                Converter.convert(input);

            } else if (Validator.isValidQuit(input)) {
                break;
            } else {
                Terminal.printLine("Error, unknown command");
            }
        }
    }

}