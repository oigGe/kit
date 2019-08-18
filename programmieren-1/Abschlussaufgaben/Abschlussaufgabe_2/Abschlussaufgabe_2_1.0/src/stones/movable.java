package stones;

import grid.Position;

public interface movable {


    void setMoveOptions();

    Position[] getMoveOptions();

    String move(Position position);
}
