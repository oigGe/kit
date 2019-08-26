package stones;


import grid.Position;
import player.Player;

public class Agent extends Stone {

    public Agent(String name, Player player) {
        super(name, player);
    }


    @Override
    public void updateMoveOptions() {
        Position[] surroundingPositions = super.getPosition().getEdges();
        Position[] moveOptions = new Position[surroundingPositions.length];
        for (int i = 0; i < surroundingPositions.length; i++) {

            if (surroundingPositions[i] == null){
                continue;
            }
            //            can only move there if there is another edge except the stone itself
            if (surroundingPositions[i].getSurroundingStoneCount() < 2) {
                continue;
            }
                moveOptions[i] = surroundingPositions[i];
        }
        super.setMoveOptions(moveOptions);

        // still needs to be checked for climbing. Like the ilias example shows, if the position is empty
        //the stone has to slide. if not, stone can climb and ignore sliding
        //move() should be overwritten.
    }

}

