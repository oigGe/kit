package grid;

import edu.kit.informatik.Terminal;

import java.util.ArrayList;

public final class Grid {

    public static final int SIZE = 30;
    private static Grid instance;
    private int half = SIZE / 2;
    private Position[][] grid;

    private Grid() {
        this.grid = new Position[SIZE][SIZE];

    }

    public static Grid getInstance() {
        if (instance == null) {
            Grid.instance = new Grid();
        }
        return Grid.instance;
    }


    private void setBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = new Position(i, j);
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
                grid[row][col] = new Position(xLbl, yLbl);
            }
        }
    }

    public void initBoardPositions() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] != null) {
                    grid[i][j].setEdges();

                }
            }
        }
    }

    public int getOccupiedPositionCount() {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j].hasStone()) {
                    count++;
                }
            }
        }
        return count;
    }

    public ArrayList<Position> getOccupiedPositions() {
        ArrayList<Position> occupiedPositions = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j].hasStone()) {
                    occupiedPositions.add(grid[i][j]);

                }
            }
        }
        return occupiedPositions;
    }

    public Position[][] getGrid() {
        return grid;
    }

    public Position getPosition(int xPos, int yPos) {
        String thisName = Integer.toString(xPos) + " " + Integer.toString(yPos);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == null) {
                    continue;
                }
                if (grid[i][j].getName() != null && grid[i][j].getName().equals(thisName)) {
                    return grid[i][j];
                }
            }
        }
        return null;
    }

    public void print() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] != null) {
                    Terminal.printLine(grid[i][j].getName());
                }
            }
        }
    }
}
