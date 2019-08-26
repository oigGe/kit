package stones;

import grid.Position;
import output.ErrorMessage;
import player.Player;

import java.util.ArrayList;

public class Investigator extends Stone {

    private ArrayList<Position> visitedPositions;
    private ArrayList<Stone> prevTouched;

    public Investigator(String name, Player player) {
        super(name, player);
        this.visitedPositions = new ArrayList<>();
        visitedPositions.add(super.getPosition());
    }

    @Override
    public void updateMoveOptions() {
        updatePrevTouched();
        //        there is a bug here. THe stone first has to be removed to check if the neighbour stones have other
        Position[] surroundingPositions = super.getPosition().getEdges();
        Position[] moveOptions = new Position[surroundingPositions.length];
        for (int i = 0; i < surroundingPositions.length; i++) {
//            this should never happen.
            if (surroundingPositions[i] == null) {
                continue;
            }
            if (hasVisited(surroundingPositions[i])) {
                continue;
            }
            if (!isInTouch(surroundingPositions[i])){
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
        if (!isInTouch(destination)) {
            return ErrorMessage.NOT_IN_TOUCH_ERROR.getErrorMessage();
        }
        return super.move(destination);
    }
    private void updatePrevTouched() {
        for (Position position : super.getPosition().getEdges()) {
            if (position.hasStone()) {
                prevTouched.add(position.getHighestStone());
            }
        }
    }

    private ArrayList<Stone> getTouchingStones(Position position) {
        ArrayList<Stone> touchingStones = new ArrayList<>();
        for (Position thisPos : position.getEdges()) {
            if (thisPos.hasStone()) {
                touchingStones.add(thisPos.getHighestStone());
            }
        }
        return touchingStones;
    }

    private boolean isInTouch(Position position) {
        ArrayList<Stone> touchingStones = getTouchingStones(position);
        for (int i = 0; i < prevTouched.size(); i++) {
            for (int j = 0; j < touchingStones.size(); j++) {
                if (prevTouched.get(i).equals(touchingStones.get(j))) {
                    return true;
                }
            }
        }
        return false;
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
