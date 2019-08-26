package stones;

import grid.Position;
import output.ErrorMessage;
import output.OutputMessages;
import player.Player;

import java.util.ArrayList;

public class Informant extends Stone {

    private ArrayList<Position> visitedPositions;

    public Informant(String name, Player player) {
        super(name, player);
        this.visitedPositions = new ArrayList<>();
    }

    @Override
    public void updateMoveOptions() {
//        there is a bug here. THe stone first has to be removed to check if the neighbour stones have other
        Position[] surroundingPositions = super.getPosition().getEdges();
        Position[] moveOptions = new Position[surroundingPositions.length];
        for (int i = 0; i < surroundingPositions.length; i++) {
//            this should never happen.
            if (surroundingPositions[i] == null) {
                continue;
            }
            //            can only move there if there is another edge except the stone itself
            if (surroundingPositions[i].getSurroundingStoneCount() < 2) {
                continue;
            } //            can only move if surrounfind position is free
            if (!surroundingPositions[i].hasStone()) {
                moveOptions[i] = surroundingPositions[i];
            }

        }
        super.setMoveOptions(moveOptions);
    }

    @Override
    public String move(Position destination) {
        if (hasVisited(destination)) {
            return ErrorMessage.HAS_VISITED_BEFORE_ERROR.getErrorMessage();
        }
        String output = super.move(destination);
        if (output.equals(OutputMessages.OK_MESSAGE.getOutput())) {
            visitedPositions.add(destination);
        }
        return output;
    }


    private boolean hasVisited(Position position) {
        for (Position thisPos : visitedPositions) {
            if (thisPos.equals(position)) {
                return true;
            }
        }
        return false;
    }
}
