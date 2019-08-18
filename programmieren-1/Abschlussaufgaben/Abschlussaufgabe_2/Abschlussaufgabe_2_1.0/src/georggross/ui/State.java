package georggross.ui;

import grid.Grid;
import player.Player;

public final class State {

    private static State instance;
    Player ultraviolet;
    Player infrared;
    Grid grid;


    private State() {
        this.grid = Grid.getInstance();
    }

    public static State getInstance() {
        if (instance == null) {
            instance = new State();
        }
        return instance;
    }

    public Grid getGrid() {
        return grid;
    }

    public Player getUltraviolet() {
        return ultraviolet;
    }

    public Player getInfrared() {
        return infrared;
    }
}
