package stones;

import georggross.ui.State;
import grid.Position;

import java.util.ArrayList;

public class ConectionChecker {
    //    need to count poositions as there can be several stones in one position.
    private ArrayList<Position> connectedPositions;
    private int occupiedPositionsCount;
    private ArrayList<Position> occupiedPositions;
    private boolean isCounting;
    private int counter;
    private Stone movingStone;

    public ConectionChecker(Stone movingStone) {
        this.occupiedPositions = State.getInstance().getGrid().getOccupiedPositions();
        this.occupiedPositionsCount = State.getInstance().getGrid().getOccupiedPositionCount();
        this.isCounting = true;
        this.counter = 0;
        this.movingStone = movingStone;
        this.connectedPositions = new ArrayList<>();
        connectedPositions.add(occupiedPositions.get(0));
    }


    public boolean canBeMoved() {
//        remove movingStone position if movingStone is the only stone in this position.
        if (movingStone.getPosition().getStones().size() < 2) {
//            There might be a bug here as position is removed. But this should be created new every time its called anyways.
            occupiedPositions.remove(movingStone.getPosition());
            occupiedPositionsCount--;
        }
        int connectedPositionCount = count();
        return connectedPositionCount == occupiedPositionsCount;
    }


    private int count() {
        while (isCounting) {
            Position startingPosition = connectedPositions.get(counter);
            if (startingPosition == null) {
                isCounting = false;
                return connectedPositions.size();
            }
            for (int i = 0; i <= startingPosition.getEdges().length; i++) {
                if (!isConnected(startingPosition.getEdge(i))) {
                    connectedPositions.add(startingPosition.getEdge(i));
                }

            }
            counter++;
            if (connectedPositions.size() <= counter)
                count();
        }
        return connectedPositions.size();
    }


    private boolean isConnected(Position position) {
        for (int i = 0; i < connectedPositions.size(); i++) {
            if (connectedPositions.get(i).equals(position)) {
                return true;
            }
        }
        return false;
    }
}
