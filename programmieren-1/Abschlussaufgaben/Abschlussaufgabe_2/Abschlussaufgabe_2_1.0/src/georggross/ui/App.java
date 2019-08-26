package georggross.ui;

import edu.kit.informatik.Terminal;
import grid.Position;
import input.InputChecker;
import output.ErrorMessage;
import output.OutputMessages;
import player.Player;
import stones.Stone;

import java.util.ArrayList;

public class App {

    private static boolean isRunning = true;
    private static boolean hasStarted = false;

    private static Player currentPlayer;

    public static void run() {
        while (isRunning) {
            String input = Terminal.readLine();

            if (InputChecker.isQuitCommand(input)) {
                isRunning = false;
                break;
            }

            if (InputChecker.isStartCommand(input)) {
                Terminal.printLine(executeStartCommand(input));
            }
            if (hasStarted) {

                if (InputChecker.isPlaceCommand(input)) {
                    Terminal.printLine(executePlaceCommand(input));
                }

                if (InputChecker.isMoveCommand(input)) {
                    Terminal.printLine(executeMoveCommand(input));
                }

                if (InputChecker.isPassCommand(input)) {
                    Terminal.printLine(executePassCommand());
                }
                if (InputChecker.isPrintCommand(input)) {
                    executePrintCommand();
                }
            }
        }
    }

    private static void executePrintCommand() {

    }

    private static String executePassCommand() {
        currentPlayer.increaseTurnCounter();
        changeTurn();
        return OutputMessages.OK_MESSAGE.getOutput();
    }

    private static String executeMoveCommand(String input) {
        String output = "";
        Stone thisStone = InputChecker.getStoneFromInput(input);
        Position thisPosition = thisStone.getPosition();
        ArrayList<Position> movePositions = InputChecker.getMovePositions;
        if (InputChecker.isInvalidAmountOfMovePositions) {
            return ErrorMessage.INVALID_AMOUNT_OF_POSITIONS_ERROR.getErrorMessage();
        }
        for (Position position : movePositions) {
            output = currentPlayer.moveStone(thisStone, position);
            if (!output.equals(OutputMessages.OK_MESSAGE.getOutput())) {
                // do this when several positions are entered and one of them is false
                thisStone.setPosition(thisPosition);
                return output;
            }

        }
        if (output.equals(OutputMessages.OK_MESSAGE.getOutput())) {
            currentPlayer.increaseTurnCounter();
            changeTurn();
        }
        return output;
    }


    private static boolean cantMove() {
        return !currentPlayer.hasPlayedMrX();
    }

    private static boolean hasToPlayMrX() {
        // dont know if 4 is correct here. no magic numbers anyway
        return currentPlayer.getTurnCounter() >= 4 && !currentPlayer.hasPlayedMrX();
    }

    private static String executeStartCommand(String input) {
        State.resetState();
        Stone thisStone = InputChecker.getStoneFromInput(input);
        if (thisStone == null) {
            return ErrorMessage.INVALID_STONE_ERROR.getErrorMessage();
        }
        currentPlayer = thisStone.getPlayer();
        String output = currentPlayer.playFirstStone(thisStone);
        if (output.equals(OutputMessages.OK_MESSAGE.getOutput())) {
            currentPlayer.increaseTurnCounter();
            changeTurn();
            hasStarted = true;
        }
        return output;
    }

    private static String executePlaceCommand(String input) {

        Stone thisStone = InputChecker.getStoneFromInput(input);
        if (hasToPlayMrX() && !isMrX(thisStone)) {
            return ErrorMessage.HAS_TO_PLAY_MR_X_ERROR.getErrorMessage();
        }
        if (thisStone == null) {
            return ErrorMessage.INVALID_STONE_ERROR.getErrorMessage();
        }
        //maybe check if it is enemies stone first. But will be checked in playstonefromhand() anyways.
        Position destination = InputChecker.getPositionFromInput(input);
        if (destination == null) {
            return ErrorMessage.INVALID_POSITION_ERROR.getErrorMessage();
        }
        String output = currentPlayer.playStoneFromHand(thisStone, destination);
        if (output.equals(OutputMessages.OK_MESSAGE.getOutput())) {
            if (getWinner() != null) {
                hasStarted = false;
                return OutputMessages.WINNER_MESSAGE.getOutput() + " " + getWinner().getName();
            }
            currentPlayer.increaseTurnCounter();
            changeTurn();
        }
        return output;
    }

    private static boolean isMrX(Stone stone) {
        return currentPlayer.getMrX().equals(stone);
    }


    private static void changeTurn() {
        if (currentPlayer == State.getInstance().getInfrared()) {
            currentPlayer = State.getInstance().getUltraviolet();
        } else {
            currentPlayer = State.getInstance().getInfrared();
        }
    }

    private static Player getOpponent() {
        if (currentPlayer == State.getInstance().getInfrared()) {
            return State.getInstance().getUltraviolet();
        }
        return State.getInstance().getInfrared();
    }

    private static Player getWinner() {
        if (currentPlayer.hasLost()) {
            return getOpponent();
        }
        if (getOpponent().hasLost()) {
            return currentPlayer;
        }
        return null;
    }
}
