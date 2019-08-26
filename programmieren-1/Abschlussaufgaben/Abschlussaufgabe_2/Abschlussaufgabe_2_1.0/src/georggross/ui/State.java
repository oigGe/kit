package georggross.ui;

import grid.Grid;
import player.CreatePlayer;
import player.Player;
import stones.Stone;

import java.util.ArrayList;

public final class State {

    private static State instance;
    private Player ultraviolet;
    private Player infrared;
    private Grid grid;
    private ArrayList<Stone> allStones;


    private State() {
        this.grid = Grid.getInstance();
        this.infrared = CreatePlayer.INFRARED.getPlayer();
        this.ultraviolet = CreatePlayer.ULTRAVIOLETT.getPlayer();
        initAllStones();
    }

    private void initAllStones() {
        allStones.addAll(ultraviolet.getHand());
        allStones.addAll(infrared.getHand());
    }

    public static State getInstance() {
        if (instance == null) {
            instance = new State();
        }
        return instance;
    }

    public static void resetState() {
        instance = null;
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

    public Stone getStoneWithName(String name) {
        for (Stone stone : allStones) {
            if (stone.getName().equals(name)) {
                return stone;
            }
        }
        return null;
    }
}
