package georggross;

import edu.kit.informatik.Terminal;

/**
 * Course handles the Player turns and which commands are allowed during the course of the game.
 *
 * @author Georg Gross
 * @version 1.0
 */
public class Course {
    private static boolean isRunning = true;


    /**
     * Looks for initial input of the order in which stones will be placed on the  board.
     *
     * @param app - The program state.
     * @return - True if start was successful, false if quit was entered.
     */
    public static boolean start(App app) {
        boolean hasStarted = false;
        while (!hasStarted) {
            String input = Terminal.readLine();
            if (FormatChecker.isStart(app.getSize(), input)) {
                int[] playerAPositions = InputFormat.playerStartValues(input, 0);
                int[] playerBPositions = InputFormat.playerStartValues(input, 1);
                app.start(playerAPositions, playerBPositions);
                hasStarted = true;
                return true;
            } else if (FormatChecker.isPrint(input)) {
                app.getBoard().printBoard();
            } else if (FormatChecker.isPrintCell(app.getSize(), input, app.getIsTorus())) {
                int[] coordinates = InputFormat.getCellCoordinates(input);
                app.getBoard().printCell(coordinates[0], coordinates[1]);
            } else if (FormatChecker.isQuit(input)) {
                return false;
            } else {
                Terminal.printError("invalid input");
            }
        }
        return true;
    }

    /**
     * Alternates the turns from one player to the other. Checks for a winner.
     *
     * @param app - The program state.
     * @return - Returns true if game has a winner and false if program should be quit.
     */
    public static boolean turns(App app) {
        boolean gameOver = false;
        initiateTurns(app);
        while (!gameOver) {
            if (!isRunning) {
                return false;
            }
            if (app.getPlayerA().isTurn()) {
                turn(app, app.getPlayerA());
                if (isGameOver(app)) {
                    printWinner(app);
                    return true;
                }
                switchTurns(app);
            } else {
                turn(app, app.getPlayerB());
                if (isGameOver(app)) {
                    printWinner(app);
                    return true;
                }
                switchTurns(app);
            }
        }
        return false;
    }

    /**
     * Determines which commands are still usable after a game was won.
     *
     * @param app - The programm status.
     * @return returns false if program should be quit.
     */
    public static boolean after(App app) {
        boolean isAfter = true;
        while (isAfter) {
            if (!isRunning) {
                break;
            }
            String input = Terminal.readLine();
            if (FormatChecker.isQuit(input)) {
                isRunning = false;
                return false;
            } else if (FormatChecker.isPrintCell(app.getSize(), input, app.getIsTorus())) {
                printCell(app, input);
            } else if (FormatChecker.isPrint(input)) {
                app.getBoard().printBoard();
            } else {
                Terminal.printError("invalid command.");
            }
        }
        return true;
    }

    //divides a players turn into different stages
    private static void turn(App app, Player player) {
        int roll = rollPhase(app, player);
        movePhase(app, player, roll);
    }

//    Looks for the roll command as well as other allowed commands while player has not yet rolled.
//    Controls if rolled number is valid.
//    Returns the value a player has rolled.

    private static int rollPhase(App app, Player player) {
        boolean hasRolled = false;
        int roll = -1;
        while (!hasRolled) {
            if (!isRunning) {
                break;
            }
            String input = Terminal.readLine();
            if (FormatChecker.isRoll(app.getSize(), input)) {
                roll = InputFormat.getRoll(input);
                if (FormatChecker.isCorrectRoll(app, roll)) {
                    hasRolled = true;
                } else {
                    Terminal.printError("roll out of bounds.");
                }
            } else if (FormatChecker.isQuit(input)) {
                isRunning = false;
                hasRolled = false;
                break;
            } else if (FormatChecker.isPrintCell(app.getSize(), input, app.getIsTorus())) {
                printCell(app, input);
            } else if (FormatChecker.isPrint(input)) {
                app.getBoard().printBoard();
            } else if (FormatChecker.isToken(input)) {
                player.printToken();
            } else {
                Terminal.printError("invalid command.");
            }
        }
        return roll;
    }

//    Looks for the move command after a player has rolled, as well as other valid commands.

    private static void movePhase(App app, Player player, int roll) {
        boolean isMoving = true;
        while (isMoving) {
            if (!isRunning) {
                break;
            }
            String input = Terminal.readLine();
            if (FormatChecker.isMove(app.getSize(), app.getIsTorus(), input)) {
                int whichStone = InputFormat.getStoneToMove(input);
                int[] coordinates = InputFormat.getStoneMoveCoordinates(input);
                if (player.moveStone(whichStone, roll, coordinates[0], coordinates[1], app)) {
                    if (!isGameOver(app)) {
                        Terminal.printLine("OK");
                    }
                    isMoving = false;
                } else {
                    Terminal.printError("invalid move.");
                }
            } else if (FormatChecker.isPrint(input)) {
                app.getBoard().printBoard();
            } else if (FormatChecker.isPrintCell(app.getSize(), input, app.getIsTorus())) {
                printCell(app, input);
            } else if (FormatChecker.isToken(input)) {
                player.printToken();
            } else if (FormatChecker.isQuit(input)) {
                isRunning = false;
                isMoving = false;
            } else {
                Terminal.printError("invalid command in move Phase");
            }

        }
    }

    //Sets up the initial turn.
    private static void initiateTurns(App app) {
        app.getPlayerA().setTurn(true);
        app.getPlayerB().setTurn(false);
    }

    //    Checks if game is over.
    private static boolean isGameOver(App app) {
        if (app.getPlayerA().hasWon(app) || app.getPlayerB().hasLost()) {
            return true;
        } else if (app.getPlayerB().hasWon(app) || app.getPlayerA().hasLost()) {
            return true;
        }
        return false;
    }

    //Switches turns
    private static void switchTurns(App app) {
        app.getPlayerA().setTurn(!app.getPlayerA().isTurn());
        app.getPlayerB().setTurn(!app.getPlayerB().isTurn());
    }

    //    Prints the winner
    private static void printWinner(App app) {
        if (app.getPlayerA().hasWon(app) || app.getPlayerB().hasLost()) {
            Terminal.printLine("P1 wins");
        } else if (app.getPlayerB().hasWon(app) || app.getPlayerA().hasLost()) {
            Terminal.printLine("P2 wins");
        }
    }

    //    Passes on the print-cell command.
    private static void printCell(App app, String input) {
        int[] coordinates = InputFormat.getCellCoordinates(input);
        app.getBoard().printCell(coordinates[0], coordinates[1]);
    }


}
