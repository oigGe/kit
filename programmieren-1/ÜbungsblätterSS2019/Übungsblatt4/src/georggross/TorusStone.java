package georggross;

import java.util.ArrayList;

public class TorusStone extends Stone {
    public TorusStone(int number, Player player, Position position) {
        super(number, player, position);
    }

    @Override
    public ArrayList<Position> moveOptions(App app) {
        Board board = app.getBoard();
        ArrayList<Position> moveOptions = new ArrayList<>();
        int thisX = super.getPosition().getXPos();
        int thisY = super.getPosition().getYPos();
        int mod = app.getBoard().getSize();
        if (super.getPlayer().getId() == 1) {
            moveOptions.add(board.getPosition((thisX + 1) % mod, (thisY + 1) % mod, app));
            moveOptions.add(board.getPosition(thisX, (thisY + 1) % mod, app));
            moveOptions.add(board.getPosition((thisX + 1) % mod, thisY, app));
        } else if (super.getPlayer().getId() == 2) {
            if (thisX > 0 && thisY > 0) {
                moveOptions.add(board.getPosition(thisX - 1, thisY - 1, app));
                moveOptions.add(board.getPosition(thisX, thisY - 1, app));
                moveOptions.add(board.getPosition(thisX - 1, thisY, app));
            } else if (thisX <= 0 && thisY > 0) {
                moveOptions.add(board.getPosition(mod + ((thisX - 1) % mod), thisY - 1, app));
                moveOptions.add(board.getPosition(thisX, thisY - 1, app));
                moveOptions.add(board.getPosition(mod + ((thisX - 1) % mod), thisY, app));
            } else if (thisX > 0 && thisY <= 0) {
                moveOptions.add(board.getPosition(thisX - 1, mod + ((thisY) % mod), app));
                moveOptions.add(board.getPosition(thisX, mod + ((thisY) % mod), app));
                moveOptions.add(board.getPosition(thisX - 1, thisY, app));
            }
        }
        return moveOptions;

    }

    @Override
    public boolean isValidMove(App app, int xPos, int yPos) {
        int adjustedXPos = InputFormat.adjustNumber(xPos, app);
        int adjustedYPos = InputFormat.adjustNumber(yPos, app);
        return super.isValidMove(app, adjustedXPos, adjustedYPos);
    }

    @Override
    public boolean move(App app, int xPos, int yPos) {
        Board board = app.getBoard();
        int adjustedXPos = InputFormat.adjustNumber(xPos, app);
        int adjustedYPos = InputFormat.adjustNumber(yPos, app);
        if (isValidMove(app, adjustedXPos, adjustedYPos)) {
            Position newPosition = board.getPosition(adjustedXPos, adjustedYPos, app);
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

}

