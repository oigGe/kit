package stones;

import grid.Position;
import player.Player;

public class MisterX extends Stone {

    public MisterX(String name, Player player) {
        super(name, player);
    }

    @Override
    public void setMoveOptions() {
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
}
