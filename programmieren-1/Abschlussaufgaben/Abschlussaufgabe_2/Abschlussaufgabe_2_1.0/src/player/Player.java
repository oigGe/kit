package player;

import grid.Position;
import output.ErrorMessage;
import output.OutputMessages;
import stones.Stone;

import java.util.List;

public class Player {
    private String name;
    private List<Stone> hand;
    private List<Stone> board;

    public Player(String name, List<Stone> hand) {
        this.name = name;
        this.hand = hand;
    }


    public String playStoneFromHand(Stone stone, Position position) {
        Stone thisStone = getStoneFromHand(stone);
        if (thisStone == null) {
            return ErrorMessage.STONE_NOT_IN_HAND_ERROR.getErrorMessage();
        }
        String error = thisStone.playStoneFromHand(position);
        if (error != null){
            return error;
        }
        hand.remove(thisStone);
        board.add(thisStone);
        return OutputMessages.OK_MESSAGE.getOutput();
    }

    public String moveStone(Stone stone, Position position) {
       String error = stone.move(position);
       if (error != null){
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
}
