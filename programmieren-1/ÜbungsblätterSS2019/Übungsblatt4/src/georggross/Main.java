package georggross;

import edu.kit.informatik.Terminal;

/**
 * Entry point for the programm. It contains tht main method and the command line interactions.
 *
 * @author Georg Gross
 * @version 1.0
 */
public class Main {

    private static boolean isRunning = true;

    /**
     * Main method of the Programm. It parses command line commands.
     * @param args - determines the size of the board and game mode
     */
    public static void main(String[] args) {

        if (!FormatChecker.isCorrectCommandlineArgument(args)) {
            Terminal.printError("invalid command line arguments. ");
            isRunning = false;
        }
        boolean isTorus = isTorus(args);
        int size = Integer.parseInt(args[1]);
        App app = new App(size, isTorus);
        while (isRunning) {
            if (!Course.start(app)) {
                break;
            }

            if (!Course.turns(app)) {
                break;
            }
            if (!Course.after(app)) {
                break;
            }
        }
    }

//   Determines if game mode is torus.
    private static boolean isTorus(String[] args) {
        if (args[0].equals("torus")) {
            return true;
        }
        return false;
    }
}
