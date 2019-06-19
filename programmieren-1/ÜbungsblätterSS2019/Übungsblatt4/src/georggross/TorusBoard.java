package georggross;

public class TorusBoard extends Board {

    public TorusBoard(int size) {
        super(size);
    }

    @Override
    public Position getPosition(int xPos, int yPos, App app) {
        int adjustedXPos = InputFormat.adjustNumber(xPos, app);
        int adjustedYPos = InputFormat.adjustNumber(yPos, app);
        return super.getPosition(adjustedXPos, adjustedYPos, app);
    }

}
