package georggross.ui;

import grid.Grid;

public class Main {
    public static void main(String[] args) {
        Grid.getInstance().setBoardPositions();
        Grid.getInstance().initBoardPositions();
        Grid.getInstance().print();
    }
}
