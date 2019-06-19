package georggross;

import java.util.ArrayList;

/**
 * Class that overrides function of the stone class in case of torus mode.
 *
 * @author Georg Gross
 * @version 1.0
 */
public class TorusStone extends Stone {

    /**
     * Constructor
     *
     * @param number   - Stone value.
     * @param player   - Stone owner.
     * @param position - Position on the board.
     */
    public TorusStone(int number, Player player, Position position) {
        super(number, player, position);
    }

    /**
     * Returns an array list of positions a stone can reach with the next move.
     *
     * @param app - The program state.
     * @return - List of possible destinations.
     */
    @Override
    public ArrayList<Position> moveOptions(App app) {
        Board board = app.getBoard();
        ArrayList<Position> moveOptions = new ArrayList<>();
        int thisX = super.getPosition().getXPos();
        int thisY = super.getPosition().getYPos();
        int mod = app.getBoard().getSize();
        if (super.getPlayer().getId() == 1) {
            moveOptions.add(board.getPosition((thisX + 1) % mod, (thisY + 1) % mod, app));
            moveOptions.add(board.getPosition(thisX, (thisY + 1) % mod, app));
            moveOptions.add(board.getPosition((thisX + 1) % mod, thisY, app));
        } else if (super.getPlayer().getId() == 2) {
            if (thisX > 0 && thisY > 0) {
                moveOptions.add(board.getPosition(thisX - 1, thisY - 1, app));
                moveOptions.add(board.getPosition(thisX, thisY - 1, app));
                moveOptions.add(board.getPosition(thisX - 1, thisY, app));
            } else if (thisX <= 0 && thisY > 0) {
                moveOptions.add(board.getPosition(mod + ((thisX - 1) % mod), thisY - 1, app));
                moveOptions.add(board.getPosition(thisX, thisY - 1, app));
                moveOptions.add(board.getPosition(mod + ((thisX - 1) % mod), thisY, app));
            } else if (thisX > 0 && thisY <= 0) {
                moveOptions.add(board.getPosition(thisX - 1, mod + ((thisY) % mod), app));
                moveOptions.add(board.getPosition(thisX, mod + ((thisY) % mod), app));
                moveOptions.add(board.getPosition(thisX - 1, thisY, app));
            }
        }
        return moveOptions;

    }

    /**
     * Checks if move is valid. Adjusts position for torus mode.
     *
     * @param app  - Program state.
     * @param xPos - X value of destination.
     * @param yPos - Y value of destination.
     * @return - True if move is valid.
     */
    @Override
    public boolean isValidMove(App app, int xPos, int yPos) {
        int adjustedXPos = InputFormat.adjustNumber(xPos, app);
        int adjustedYPos = InputFormat.adjustNumber(yPos, app);
        return super.isValidMove(app, adjustedXPos, adjustedYPos);
    }

    @Override
    public boolean move(App app, int xPos, int yPos) {
        Board board = app.getBoard();
        int adjustedXPos = InputFormat.adjustNumber(xPos, app);
        int adjustedYPos = InputFormat.adjustNumber(yPos, app);
        if (isValidMove(app, adjustedXPos, adjustedYPos)) {
            Position newPosition = board.getPosition(adjustedXPos, adjustedYPos, app);
            if (newPosition.getStone() != null) {
                beat(newPosition);
            }
            super.getPosition().setStone(null);
            super.setPosition(newPosition);
            newPosition.setStone(this);
            return true;
        }
        return false;

    }

}

