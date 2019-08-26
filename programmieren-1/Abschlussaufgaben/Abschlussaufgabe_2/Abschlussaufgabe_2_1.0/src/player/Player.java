package player;

import grid.Position;
import input.InputChecker;
import output.ErrorMessage;
import output.OutputMessages;
import stones.MisterX;
import stones.Stone;

import java.util.List;

public class Player {
    private String colorId;
    private String name;
    private List<Stone> hand;
    private List<Stone> board;
    private int turnCounter;
    private String[] stoneNames;

    public Player(String name, String colorId, String[] stoneNames) {
        this.name = name;
        this.turnCounter = 0;
        this.colorId = colorId;

    }

    public void setHand(List<Stone> hand) {
        this.hand = hand;
    }

    public String playFirstStone(Stone stone) {
        String output = stone.playAsFirstStone();
        if (output.matches(OutputMessages.OK_MESSAGE.getOutput())) {
            hand.remove(stone);
            board.add(stone);
        }
        return output;
    }

    public String playStoneFromHand(Stone stone, Position position) {
        Stone thisStone = getStoneFromHand(stone);
        if (thisStone == null) {
            return ErrorMessage.STONE_NOT_IN_HAND_ERROR.getErrorMessage();
        }
        String error = thisStone.playStoneFromHand(position);
        if (error != null) {
            return error;
        }
        hand.remove(thisStone);
        board.add(thisStone);
        return OutputMessages.OK_MESSAGE.getOutput();
    }

    public String moveStone(Stone stone, Position position) {
        String error = stone.move(position);
        if (error != null) {
            return error;
        }
        return OutputMessages.OK_MESSAGE.getOutput();
    }


    private Stone getStoneFromHand(Stone stone) {
        for (Stone thisStone : hand) {
            if (thisStone.equals(stone)) {
                return thisStone;
            }
        }
        return null;
    }

    public void increaseTurnCounter() {
        this.turnCounter++;
    }

    public List<Stone> getHand() {
        return hand;
    }

    public boolean hasPlayedMrX() {
        for (Stone stone : hand) {
            if (stone.getName().matches(InputChecker.MR_X_REGEX)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasLost() {
        if (!hasPlayedMrX()) {
            return false;
        }
        MisterX mrX = (MisterX) getMrX();
        return mrX.isSurrounded();
    }

    public int getTurnCounter() {
        return turnCounter;
    }

    public Stone getMrX() {
        for (Stone stone : hand) {
            if (stone.getName().matches(InputChecker.MR_X_REGEX)) {
                return stone;
            }
        }
        return null;
    }

    public String getStonesString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < stoneNames.length; i++) {
//            maybe check for null. dont know what it appends.
            String stoneString = getStoneStringFromBoard(stoneNames[i]);
            if (stoneString != null) {
                output.append(getStoneStringFromBoard(stoneNames[i]));
                output.append("\n");
            }
        }
        return output.toString();
    }

    private String getStoneStringFromBoard(String stoneName) {
        for (Stone stone : board) {
            if (stoneName.equals(stone.getName())) {
                return stone.toString();
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
}
