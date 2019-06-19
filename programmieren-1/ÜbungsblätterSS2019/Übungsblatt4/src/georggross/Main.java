package georggross;

import edu.kit.informatik.Terminal;

public class Main {

    private static boolean isRunning = true;

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

    private static boolean isTorus(String[] args) {
        if (args[0].equals("torus")) {
            return true;
        }
        return false;
    }
}
