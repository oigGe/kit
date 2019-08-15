package georggross.ui;

import board.Board;

public class Main {
    public static void main(String[] args) {
        Board.getInstance().setBoardPositions();
        Board.getInstance().initBoardPositions();
        Board.getInstance().print();
    }
}
