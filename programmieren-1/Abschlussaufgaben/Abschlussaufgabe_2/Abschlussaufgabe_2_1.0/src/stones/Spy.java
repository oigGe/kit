package stones;

import grid.Position;
import output.ErrorMessage;
import output.OutputMessages;
import player.Player;

public class Spy extends Stone {

    public Spy(String name, Player player) {
        super(name, player);
    }

    @Override
    public void updateMoveOptions() {
        Position[] moveOptions = new Position[6];
        for (int i = 0; i <= 5; i++) {
            Position thisEdge = super.getPosition().getEdge(i);
            if (!thisEdge.hasStone()) {
                continue;
            }
            while (hasNextEdgeStone(thisEdge, i)) {
                thisEdge = thisEdge.getEdge(i);
            }
            moveOptions[i] = thisEdge;
        }
        super.setMoveOptions(moveOptions);
    }


    @Override
    public String move(Position destination) {
        if (super.breaksConnection()) {
            return ErrorMessage.CONNECTION_BREAK_ERROR.getErrorMessage();
        }
        if (super.isBlockedByAgent()) {
            return ErrorMessage.IS_BLOCKED_BY_AGENT_ERROR.getErrorMessage();
        }

        super.updateMoveOptions();
        Position[] moveOptions = super.getMoveOptions();
        Position position = super.getPosition();
        for (int i = 0; i < moveOptions.length; i++) {
            if (moveOptions[i].equals(destination)) {
                position.removeStone(this);
                position = destination;
                position.addStone(this);
                return OutputMessages.OK_MESSAGE.getOutput();
            }
        }
        return ErrorMessage.NOT_A_VALID_MOVE_OPTION_ERROR.getErrorMessage();
    }


    private boolean hasNextEdgeStone(Position currentPos, int edgeNumber) {
        return currentPos.getEdge(edgeNumber).hasStone();
    }
}
