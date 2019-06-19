package georggross;

import java.util.ArrayList;

/**
 * Represents a stone on the field.
 *
 * @author Georg Gross
 * @version 1.0
 */
public class Stone {
    private int number;
    private Player player;
    private Position position;
    private boolean isDeleted = false;

    /**
     * Constructor
     *
     * @param number   - Stone value.
     * @param player   - Stone owner.
     * @param position - Position on the board.
     */
    public Stone(int number, Player player, Position position) {
        this.number = number;
        this.player = player;
        this.position = position;
    }

    /**
     * Sets isDeleted value.
     *
     * @param deleted - Boolean value.
     */
    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    /**
     * Deletes a stone from the board and the players stone list.
     */
    public void deleteStone() {
        this.setDeleted(true);
        this.position.getStone().getPlayer().removeStone(this);
        this.position.setStone(null);
    }

    /**
     * Gets stones position.
     *
     * @return - current position.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Gets stones value.
     *
     * @return - Stones value.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Gets stones owner.
     *
     * @return - Player who owns stone.
     */
    public Player getPlayer() {
        return player;
    }


    /**
     * Returns a list of possible positions a stone can move to.
     *
     * @param app - Programm state.
     * @return - Array list of positions.
     */
    public ArrayList<Position> moveOptions(App app) {
        Board board = app.getBoard();
        ArrayList<Position> moveOptions = new ArrayList<>();
        int allowedSize = board.getSize() - 1;
        int modifier = 0;
        int thisX = position.getXPos();
        int thisY = position.getYPos();
        boolean criteria1 = false;
        boolean criteria2 = false;
        boolean criteria3 = false;
        if (player.getId() == 1) {
            modifier = 1;
            criteria1 = thisX < allowedSize && thisY < allowedSize;
            criteria2 = thisX < allowedSize && thisY >= allowedSize;
            criteria3 = thisX >= allowedSize && thisY < allowedSize;
        } else if (player.getId() == 2) {
            modifier = -1;
            criteria1 = thisX > 0 && thisY > 0;
            criteria2 = thisX > 0 && thisY <= 0;
            criteria3 = thisX <= 0 && thisY > 0;
        }
        if (criteria1) {
            Position opt1 = board.getPosition(thisX, thisY + modifier, app);
            Position opt2 = board.getPosition(thisX + modifier, thisY, app);
            Position opt3 = board.getPosition(thisX + modifier, thisY + modifier, app);
            moveOptions.add(opt1);
            moveOptions.add(opt2);
            moveOptions.add(opt3);
        } else if (criteria2) {
            Position opt1 = board.getPosition(thisX + modifier, thisY, app);
            moveOptions.add(opt1);
        } else if (criteria3) {
            Position opt1 = board.getPosition(thisX, thisY + modifier, app);
            moveOptions.add(opt1);
        }
        return moveOptions;
    }

    /**
     * Determines if a move is valid.
     *
     * @param app  - Program state.
     * @param xPos - X coordinate of destination.
     * @param yPos - Y coordinate of destination.
     * @return - True if move is valid.
     */
    public boolean isValidMove(App app, int xPos, int yPos) {
        Position newPosition = app.getBoard().getPosition(xPos, yPos, app);
        if (moveOptions(app).contains(newPosition)) {
            return true;
        }
        return false;
    }

    /**
     * Moves a stone to a designated position.
     *
     * @param app  - Program state.
     * @param xPos - X coordinate of destination.
     * @param yPos - Y coordinate of destionation.
     * @return - True if move was successful
     */
    public boolean move(App app, int xPos, int yPos) {
        if (isValidMove(app, xPos, yPos)) {
            Position newPosition = app.getBoard().getPosition(xPos, yPos, app);
            if (newPosition.getStone() != null) {
                beat(newPosition);
            }
            this.position.setStone(null);
            this.position = newPosition;
            newPosition.setStone(this);
            return true;
        }
        return false;
    }

    /**
     * removes stone at certain position.
     *
     * @param position - The position of the stone to be removed.
     */
    public void beat(Position position) {
        position.getStone().deleteStone();
    }

    /**
     * Sets stone to certain position
     *
     * @param position - position that stone should be set to.
     */
    public void setPosition(Position position) {
        this.position = position;
    }
}
