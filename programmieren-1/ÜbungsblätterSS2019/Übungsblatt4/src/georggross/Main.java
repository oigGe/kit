package georggross;

import edu.kit.informatik.Terminal;

public class Main {

    private static boolean isRunning = true;

    public static void main(String[] args) {

        if (isCorrectCommandlineArgument(args)) {
            App app = new App(Integer.parseInt(args[1]), isTorus(args));

            while (isRunning) {
                String input = Terminal.readLine();


            }
        } else {
            Terminal.printError("invalid commandline argument");
            isRunning = false;
        }


    }

    private static void playerTurn(Player player) {

        String input = Terminal.readLine();
        rollPhase(input);
//        movePhase(input);

    }

    private static boolean rollPhase(String input){
       return false;
    }

    private boolean correctInput(String input){
return true;
    }

    private static boolean isCorrectCommandlineArgument(String[] args) {
        boolean firstArg = args[0].equals("standard") || args[0].equals("torus");
        boolean secondArg = args[1].equals("5") || args[1].equals("7");
        boolean correctSize = args.length == 2;
        if (firstArg && secondArg && correctSize) {
            return true;
        }
        return false;
    }

    private static boolean isTorus(String[] args) {
        if (args[0].equals("standard")) {
            return true;
        }
        return false;
    }
}
