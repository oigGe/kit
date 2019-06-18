package georggross;

import java.util.ArrayList;

public class TorusStone extends Stone {
    public TorusStone(int number, Player player, Position position) {
        super(number, player, position);
    }

    @Override
    public ArrayList<Position> moveOptions(Board board) {
        ArrayList<Position> moveOptions = new ArrayList<>();
        int thisX = super.getPosition().getXPos();
        int thisY = super.getPosition().getYPos();
        if (super.getPlayer().getId() == 1) {
            moveOptions.add(board.getPosition((thisX + 1) % 5, (thisY + 1) % 5));
            moveOptions.add(board.getPosition(thisX, (thisY + 1) % 5));
            moveOptions.add(board.getPosition((thisX + 1) % 5, thisY));
        } else if (super.getPlayer().getId() == 2) {
            if (thisX > 0 && thisY > 0) {
                moveOptions.add(board.getPosition(thisX - 1, thisY - 1));
                moveOptions.add(board.getPosition(thisX, thisY - 1));
                moveOptions.add(board.getPosition(thisX - 1, thisY));
            } else if (thisX <= 0 && thisY > 0) {
                moveOptions.add(board.getPosition(5 + ((thisX - 1) % 5), thisY - 1));
                moveOptions.add(board.getPosition(thisX, thisY - 1));
                moveOptions.add(board.getPosition(5 + ((thisX - 1) % 5), thisY));
            } else if (thisX > 0 && thisY <= 0) {
                moveOptions.add(board.getPosition(thisX - 1, 5 + ((thisY) % 5)));
                moveOptions.add(board.getPosition(thisX, 5 + ((thisY) % 5)));
                moveOptions.add(board.getPosition(thisX - 1, thisY));
            }
        }
        return moveOptions;

    }

    @Override
    public boolean isValidMove(Board board, int xPos, int yPos) {
        xPos = adjustNumber(xPos);
        yPos = adjustNumber(yPos);
        return super.isValidMove(board, xPos, yPos);
    }

    @Override
    public boolean move(Board board, int xPos, int yPos) {
        xPos = adjustNumber(xPos);
        yPos = adjustNumber(yPos);
        if (isValidMove(board, xPos, yPos)) {
            Position newPosition = board.getPosition(xPos, yPos);
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

    private int adjustNumber(int number) {
        if (number < 0) {
            number = (5 + (number % 5)) % 5;
        } else {
            number %= 5;
        }
        return number;
    }
}

