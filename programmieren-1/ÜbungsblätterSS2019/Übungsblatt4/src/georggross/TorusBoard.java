package georggross;

/**
 * CLass that overrides methods  of Board in case of torus game mode.
 *
 * @author Georg Gross
 * @version 1.0
 */
public class TorusBoard extends Board {

    /**
     * Constructor
     *
     * @param size - Board size.
     */
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
