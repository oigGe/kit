package stones;

import georggross.ui.State;
import grid.Position;
import output.ErrorMessage;
import output.OutputMessages;
import player.Player;

import java.util.ArrayList;

public abstract class Stone implements movable {
    private String name;
    //    private Stone[] edegs;
    private Position position;
    private Player player;
    private Position[] moveOptions;


    public Stone(String name, Player player) {
        this.name = name;
        this.player = player;
    }

    @Override
    public Position[] getMoveOptions() {
        return this.moveOptions;
    }

    @Override
    public String move(Position destination) {
        if (breaksConnection()) {
            return ErrorMessage.CONNECTION_BREAK_ERROR.getErrorMessage();
        }
        if (isBlockedByAgent()) {
            return ErrorMessage.IS_BLOCKED_BY_AGENT_ERROR.getErrorMessage();
        }
        if (isSlideBlocked(destination)) {
            return ErrorMessage.SLIDE_IS_BLOCKED_ERROR.getErrorMessage();
        }
        updateMoveOptions();
        for (int i = 0; i < moveOptions.length; i++) {
            if (moveOptions[i].equals(destination)) {
                this.position.removeStone(this);
                this.position = destination;
                this.position.addStone(this);
                return OutputMessages.OK_MESSAGE.getOutput();
            }
        }
        return ErrorMessage.NOT_A_VALID_MOVE_OPTION_ERROR.getErrorMessage();
    }

    public boolean isSlideBlocked(Position destination) {
//        should maybe check if destination is free
//        should maybe check if destination is neighbour position. but this should only be called if that has already been established

        int whichEdge = 0;
        for (int i = 0; i < position.getEdges().length; i++) {
            if (position.getEdges()[i].equals(destination)) {
                whichEdge = i;
            }
        }
        //            could be sweeter!!!!
        int rightEdge = (whichEdge + 1) % 6;
        int leftEdge = (whichEdge > 0) ? whichEdge - 1 : 5;
        return position.getEdge(leftEdge).hasStone() && position.getEdge(rightEdge).hasStone();


    }

    public boolean isBlockedByAgent() {
        ArrayList<Stone> thisPile = position.getStones();
        if (thisPile.get(thisPile.size() - 1) == this) {
            return false;
        }
        for (int i = thisPile.size() - 1; i >= 0; i--) {
            if (thisPile.get(i).getName().matches("A.*") && thisPile.get(i) != this) {
                return true;
            }
        }
        return false;
    }


    @Override
    public void updateMoveOptions() {
    }

    public Position getPosition() {
        return position;
    }

    public String playStoneFromHand(Position position) {

        if (position.hasSurroundingOpponent(player)) {
            return ErrorMessage.SURROUNDING_OPPONENT_ERROR_MESSAGE.getErrorMessage();
        }
        if (!position.hasSurroundingStone()) {
            return ErrorMessage.NO_SURROUNDING_STONE_ERROR_MESSAGE.getErrorMessage();
        }
        if (position.hasStone()) {
            return ErrorMessage.POSITION_NOT_EMPTY_ERROR_MESSAGE.getErrorMessage();
        }

        this.position = position;
        return OutputMessages.OK_MESSAGE.getOutput();
    }

    public String playAsFirstStone() {
        this.position = State.getInstance().getGrid().getPosition(0, 0);
        if (this.position != null) {
            this.position.addStone(this);
            return OutputMessages.OK_MESSAGE.getOutput();
        }
        return ErrorMessage.NOT_A_VALID_MOVE_OPTION_ERROR.getErrorMessage();
    }

    //    check if connection is broken by moving the stone.
    public boolean breaksConnection() {
        ConectionChecker c = new ConectionChecker(this);
        return !c.canBeMoved();

    }


    public Player getPlayer() {
        return player;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Stone[] getEdegs() {
//        return edegs;
//    }
//
//    public void setEdegs(Stone[] edegs) {
//        this.edegs = edegs;
//    }

    public void setPosition(Position newPosition) {
        this.position.removeStone(this);
        this.position = newPosition;
        this.position.addStone(this);
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setMoveOptions(Position[] moveOptions) {
        this.moveOptions = moveOptions;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(name);
        for (int i = 0; i < position.getEdges().length; i++) {
            if (position.getEdge(i).hasStone()) {
                output.append(" ");
                output.append(i + 1);
                output.append(" ");
                output.append(position.getEdge(i).getHighestStone().getName());
            }
        }
        return output.toString();
    }
}
