package georggross;

import edu.kit.informatik.Terminal;

import java.util.ArrayList;

/**
 * Represents a player.
 *
 * @author Georg Gross
 * @version 1.0
 */
public class Player {
    private static final int PLAYERA = 1;
    private static final int PLAYERB = 2;
    private int id;
    private ArrayList<Stone> stones;
    private boolean isTurn;
    private boolean hasLost;
    private boolean hasWon;


    /**
     * Constructor
     *
     * @param id - The players id. 1 for playerA and 2 for playerB.
     */
    public Player(int id) {
        this.id = id;

        stones = new ArrayList<>();
    }

    /**
     * Adds stone to player.
     *
     * @param stone - Stone to be added.
     */
    public void addStone(Stone stone) {
        stones.add(stone);
    }

    /**
     * Removes stone from player.
     *
     * @param stone - Stone to be removed
     */
    public void removeStone(Stone stone) {
        stones.remove(stone);
    }

    /**
     * Determines if player has lost because all stones were beaten.
     *
     * @return - True if player has lost.
     */
    public boolean hasLost() {
        if (stones.size() == 0) {
            hasLost = true;
        }
        return hasLost;
    }


    /**
     * Returnes player id.
     *
     * @return - Player id.
     */
    public int getId() {
        return id;
    }

    /**
     * Prints the stones a player has left.
     */
    public void printToken() {
        Terminal.printLine(stones.size());
    }

    /**
     * Returns a boolean value if it is players turn or not.
     *
     * @return - True if it is players turn.
     */
    public boolean isTurn() {
        return isTurn;
    }

    /**
     * Sets players turn.
     *
     * @param turn - Boolean value if it is players turn or not.
     */
    public void setTurn(boolean turn) {
        isTurn = turn;
    }

    //Returns a list of stones that are allowed to use with a certain roll
    private ArrayList<Stone> getRollOptions(int roll, App app) {
        ArrayList<Stone> rollOptions = new ArrayList<>();
        boolean hasRoll = false;
        for (int i = 0; i < stones.size(); i++) {
            if (roll == stones.get(i).getNumber()) {
                rollOptions.add(stones.get(i));
                hasRoll = true;
            }
        }
        if (!hasRoll) {
            for (int i = roll; i <= app.getDice(); i++) {
                for (int j = 0; j < stones.size(); j++)
                    if (stones.get(j).getNumber() == i) {
                        rollOptions.add(stones.get(j));
                        break;
                    }
            }
            for (int i = roll; i > 0; i--) {
                for (int j = 0; j < stones.size(); j++)
                    if (stones.get(j).getNumber() == i) {
                        rollOptions.add(stones.get(j));
                        break;
                    }
            }

        }
        return rollOptions;
    }

    //    Determines if a stone a player wants to move is allowed to be moved with a certain roll
    private boolean isCorrectStoneToMove(int roll, int input, App app) {
        ArrayList<Stone> options = getRollOptions(roll, app);
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).getNumber() == input) {
                return true;
            }
        }
        return false;
    }

    /**
     * Moves a stone.
     * Checks if stone is allowed to be moved with a certain roll.
     *
     * @param stoneNumber - Stone value.
     * @param roll        - Roll value from user input.
     * @param xPos        - X coordinate of destination.
     * @param yPos        - Y coordinate of destination.
     * @param app         - Program status.
     * @return - Boolean. True if move was successful.
     */
    public boolean moveStone(int stoneNumber, int roll, int xPos, int yPos, App app) {
        if (!isCorrectStoneToMove(roll, stoneNumber, app)) {
            return false;
        }
        Stone thisStone = getStoneWithInt(stoneNumber);
        return thisStone.move(app, xPos, yPos);
    }

    //    Returns players stone with certain value.
    private Stone getStoneWithInt(int stoneNumber) {
        for (int i = 0; i < stones.size(); i++) {
            if (stones.get(i).getNumber() == stoneNumber) {
                return stones.get(i);
            }
        }
        return null;
    }


    /**
     * Determines if player has won.
     * Checks for different positions on the board depending on the player.
     *
     * @param app - Programm state.
     * @return - Boolean, true if player has won.
     */
    public boolean hasWon(App app) {
        Board board = app.getBoard();
        if (id == PLAYERA) {
            for (int i = 0; i < stones.size(); i++) {
                if (stones.get(i).getPosition()
                        .equals(board.getPosition(board.getSize() - 1, board.getSize() - 1, app))) {
                    this.hasWon = true;
                    return true;
                }
            }
        } else if (id == PLAYERB) {
            for (int i = 0; i < stones.size(); i++) {
                if (stones.get(i).getPosition().equals(board.getPosition(0, 0, app))) {
                    this.hasWon = true;
                    return true;
                }
            }
        }
        return false;
    }
}
