package georggross;

import java.util.ArrayList;

public class Stone {
    private int number;
    private Player player;
    private Position position;
    private boolean isDeleted = false;

    public Stone(int number, Player player, Position position) {
        this.number = number;
        this.player = player;
        this.position = position;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public void deleteStone() {
        this.setDeleted(true);
        this.position.getStone().getPlayer().removeStone(this);
        this.position.setStone(null);
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public Position getPosition() {
        return position;
    }

    public int getNumber() {
        return number;
    }

    public Player getPlayer() {
        return player;
    }


    public ArrayList<Position> moveOptions(Board board) {
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
            Position opt1 = board.getPosition(thisX, thisY + modifier);
            Position opt2 = board.getPosition(thisX + modifier, thisY);
            Position opt3 = board.getPosition(thisX + modifier, thisY + modifier);
            moveOptions.add(opt1);
            moveOptions.add(opt2);
            moveOptions.add(opt3);
        } else if (criteria2) {
            Position opt1 = board.getPosition(thisX + modifier, thisY);
            moveOptions.add(opt1);
        } else if (criteria3) {
            Position opt1 = board.getPosition(thisX, thisY + modifier);
            moveOptions.add(opt1);
        }
        return moveOptions;
    }

    public boolean isValidMove(Board board, int xPos, int yPos) {
        Position newPosition = board.getPosition(xPos, yPos);
        if (moveOptions(board).contains(newPosition)) {
            return true;
        }
        return false;
    }

    public boolean move(Board board, int xPos, int yPos) {
        if (isValidMove(board, xPos, yPos)) {
            Position newPosition = board.getPosition(xPos, yPos);
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

    public void beat(Position position) {
        position.getStone().deleteStone();
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
