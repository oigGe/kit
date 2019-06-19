package georggross;

import edu.kit.informatik.Terminal;

import java.util.ArrayList;

public class Board {

    private ArrayList<Stone> stones;
    private Position[][] board;
    private int size;


    public Board(int size) {
        this.stones = new ArrayList<>();
        this.size = size;
        fillBoard(size);
    }

    private void fillBoard(int size) {
        this.board = new Position[size][size];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = new Position(i, j);
            }
        }
    }

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

    public void setStone(Stone stone) {
        stone.getPosition().setStone(stone);
    }

    public Position getPosition(int xPos, int yPos, App app) {
        return board[xPos][yPos];
    }


    public void printCell(int xPos, int yPos) {
        Position thisPosition = board[xPos][yPos];
        if (thisPosition.getStone() == null) {
            Terminal.printLine("*");
        } else {
            Terminal.printLine("P" + thisPosition.getStone().getPlayer().getId() + ":"
                    + thisPosition.getStone().getNumber());
        }
    }

    public void printBoard() {
        String output = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j].getStone() == null) {
//                    LEERZEICHEN LÖSCHEN!
                    output += " * ";
                } else {
                    output += "P" + board[i][j].getStone().getPlayer().getId()
                            + ":" + board[i][j].getStone().getNumber();
                }
            }
            Terminal.printLine(output);
            output = "";
        }
    }


    public int getSize() {
        return size;
    }
}
