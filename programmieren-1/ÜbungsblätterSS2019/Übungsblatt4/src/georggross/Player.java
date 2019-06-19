package georggross;

import edu.kit.informatik.Terminal;

import java.util.ArrayList;

public class Player {
    private static final int PLAYERA = 1;
    private static final int PLAYERB = 2;
    private int id;
    private ArrayList<Stone> stones;
    private boolean isTurn;
    private boolean hasLost;
    private boolean hasWon;


    public Player(int id) {
        this.id = id;

        stones = new ArrayList<>();
    }

    public void addStone(Stone stone) {
        stones.add(stone);
    }

    public void removeStone(Stone stone) {
        stones.remove(stone);
    }

    public boolean hasLost() {
        if (stones.size() == 0) {
            hasLost = true;
        }
        return hasLost;
    }


    public int getId() {
        return id;
    }

    public void printToken() {
        Terminal.printLine(stones.size());
    }

    public boolean isTurn() {
        return isTurn;
    }

    public void setTurn(boolean turn) {
        isTurn = turn;
    }

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

    private boolean isCorrectStoneToMove(int roll, int input, App app) {
        ArrayList<Stone> options = getRollOptions(roll, app);
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).getNumber() == input) {
                return true;
            }
        }
        return false;
    }

    public boolean moveStone(int stoneNumber, int roll, int xPos, int yPos, App app) {

        if (!isCorrectStoneToMove(roll, stoneNumber, app)) {
            return false;
        }
        Stone thisStone = getStoneWithInt(stoneNumber);
        return thisStone.move(app.getBoard(), xPos, yPos);
    }

    private Stone getStoneWithInt(int stoneNumber) {
        for (int i = 0; i < stones.size(); i++) {
            if (stones.get(i).getNumber() == stoneNumber) {
                return stones.get(i);
            }
        }
        return null;
    }


    public boolean hasWon(Board board) {
        if (id == PLAYERA) {
            for (int i = 0; i < stones.size(); i++) {
                if (stones.get(i).getPosition().equals(board.getPosition(board.getSize() - 1, board.getSize() - 1))) {
                    this.hasWon = true;
                    return true;
                }
            }
        } else if (id == PLAYERB) {
            for (int i = 0; i < stones.size(); i++) {
                if (stones.get(i).getPosition().equals(board.getPosition(0, 0))) {
                    this.hasWon = true;
                    return true;
                }
            }
        }
        return false;
    }
}
