package stones;

import grid.Position;

public interface movable {


    void updateMoveOptions();

    Position[] getMoveOptions();

    String move(Position position);
}
