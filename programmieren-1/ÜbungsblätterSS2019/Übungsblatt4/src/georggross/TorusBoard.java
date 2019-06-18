package georggross;

public class TorusBoard extends Board {

    public TorusBoard(int size) {
        super(size);
    }

    @Override
    public Position getPosition(int xPos, int yPos) {
        xPos = adjustNumber(xPos);
        yPos = adjustNumber(yPos);
        return super.getPosition(xPos, yPos);
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
