package stones;


import grid.Position;
import player.Player;

public class Agent extends Stone {

    public Agent(String name, Player player) {
        super(name, player);
    }


    @Override
    public void setMoveOptions() {
        Position[] surroundingPositions = super.getPosition().getEdges();
        Position[] moveOptions = new Position[surroundingPositions.length];
        for (int i = 0; i < surroundingPositions.length; i++) {

            if (surroundingPositions[i] == null){
                continue;
            }
                moveOptions[i] = surroundingPositions[i];
        }
        super.setMoveOptions(moveOptions);
    }

}

