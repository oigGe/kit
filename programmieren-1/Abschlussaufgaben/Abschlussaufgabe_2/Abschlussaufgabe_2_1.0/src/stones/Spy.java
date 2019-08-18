package stones;

import grid.Position;
import player.Player;

public class Spy extends Stone {

    public Spy(String name, Player player) {
        super(name, player);
    }

    @Override
    public Position[] getMoveOptions() {

    }
}
