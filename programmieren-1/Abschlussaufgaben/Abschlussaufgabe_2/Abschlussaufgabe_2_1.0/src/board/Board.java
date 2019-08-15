package board;

import edu.kit.informatik.Terminal;

public final class Board {

    public static final int SIZE = 5;
    private static Board instance;
    private int half = SIZE / 2;
    private Position[][] board;

    private Board() {
        this.board = new Position[SIZE][SIZE];

    }

    public static Board getInstance() {
        if (instance == null) {
            Board.instance = new Board();
        }
        return Board.instance;
    }


    private void setBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = new Position(i, j);
            }
        }

    }

    public void setBoardPositions() {
//        int row;
//        int cols;
        for (int row = 0; row < SIZE; row++) {
            int cols = SIZE - java.lang.Math.abs(row - half);
            for (int col = 0; col < cols; col++) {
                int xLbl = row < half ? col - row : col - half;
                int yLbl = row - half;
                board[row][col] = new Position(xLbl, yLbl);
            }
        }
    }

    public void initBoardPositions() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != null) {
                    board[i][j].setEdges();
                    System.out.println("DIDI EDGE");
                }else {
                    System.out.println("FUFIIFIFF");
                }
            }
        }
    }

    public Position getPosition(int xPos, int yPos) {

        String thisName = Integer.toString(xPos) + " " + Integer.toString(yPos);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == null) {
                    continue;
                }
                if (board[i][j].getName() != null && board[i][j].equals(thisName)) {
                    return board[i][j];
                }
            }
        }
        return null;
    }

    public void print() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != null) {
                    Terminal.printLine(board[i][j].getName());
                }
            }
        }
    }
}
