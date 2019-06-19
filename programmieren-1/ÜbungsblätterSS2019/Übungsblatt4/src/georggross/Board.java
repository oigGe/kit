package georggross;

import edu.kit.informatik.Terminal;

import java.util.ArrayList;

/**
 * Represents a playing board.
 *
 * @author Georg Gross
 * @version 1.0
 */
public class Board {

    private ArrayList<Stone> stones;
    private Position[][] board;
    private int size;


    /**
     * Constructor
     *
     * @param size - Board size.
     */
    public Board(int size) {
        this.stones = new ArrayList<>();
        this.size = size;
        fillBoard(size);
    }

    //    Fills board with positions.
    private void fillBoard(int size) {
        this.board = new Position[size][size];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = new Position(i, j);
            }
        }
    }

    /**
     * Returns a position according to its name.
     *
     * @param name - Name of the position in question.
     * @return - Position in question.
     */
    public Position getPositionWithName(String name) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].getName().matches(name)) {
                    return board[i][j];
                }
            }
        }
        return null;
    }

    /**
     * Sets stone to certain position
     *
     * @param stone - Stone to be set.
     */
    public void setStone(Stone stone) {
        stone.getPosition().setStone(stone);
    }

    /**
     * Gets position with int coordinates.
     *
     * @param xPos - Int value of x coordinate.
     * @param yPos - Int value of y coordinate.
     * @param app  - Program state.
     * @return - Position at x y coordinate.
     */
    public Position getPosition(int xPos, int yPos, App app) {
        return board[xPos][yPos];
    }


    /**
     * Prints the content of a position according to the print-cell commands requirements.
     *
     * @param xPos - Int x value of position.
     * @param yPos - Int y value of position.
     */
    public void printCell(int xPos, int yPos) {
        Position thisPosition = board[xPos][yPos];
        if (thisPosition.getStone() == null) {
            Terminal.printLine("*");
        } else {
            Terminal.printLine("P" + thisPosition.getStone().getPlayer().getId() + ":"
                    + thisPosition.getStone().getNumber());
        }
    }

    /**
     * Prints the board according to the print commands requirements.
     */
    public void printBoard() {
        String output = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j].getStone() == null) {
                    output += "*";
                } else {
                    output += "P" + board[i][j].getStone().getPlayer().getId()
                            + ":" + board[i][j].getStone().getNumber();
                }
            }
            Terminal.printLine(output);
            output = "";
        }
    }


    /**
     * Returns size of board.
     *
     * @return - Board size.
     */
    public int getSize() {
        return size;
    }
}
