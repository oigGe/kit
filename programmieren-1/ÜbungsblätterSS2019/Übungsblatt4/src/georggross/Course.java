package georggross;

import edu.kit.informatik.Terminal;

public class Course {
    private static boolean isRunning = true;


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
            }
        }
        return true;
    }

    private static void turn(App app, Player player) {
        int roll = rollPhase(app, player);
        movePhase(app, player, roll);
    }

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
                hasRolled = true;
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
                Terminal.printError("invalid command");
            }
        }
        return roll;
    }

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
                    Terminal.printError("invalid move input.");
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

    private static void initiateTurns(App app) {
        app.getPlayerA().setTurn(true);
        app.getPlayerB().setTurn(false);
    }

    private static boolean isGameOver(App app) {
        if (app.getPlayerA().hasWon(app.getBoard()) || app.getPlayerB().hasLost()) {
            return true;
        } else if (app.getPlayerB().hasWon(app.getBoard()) || app.getPlayerA().hasLost()) {
            return true;
        }
        return false;
    }

    private static void switchTurns(App app) {
        app.getPlayerA().setTurn(!app.getPlayerA().isTurn());
        app.getPlayerB().setTurn(!app.getPlayerB().isTurn());
    }

    private static void printWinner(App app) {
        if (app.getPlayerA().hasWon(app.getBoard()) || app.getPlayerB().hasLost()) {
            Terminal.printLine("P1 wins");
        } else if (app.getPlayerB().hasWon(app.getBoard()) || app.getPlayerA().hasLost()) {
            Terminal.printLine("P2 wins");
        }
    }

    private static void printCell(App app, String input) {
        int[] coordinates = InputFormat.getCellCoordinates(input);
        app.getBoard().printCell(coordinates[0], coordinates[1]);
    }


}
