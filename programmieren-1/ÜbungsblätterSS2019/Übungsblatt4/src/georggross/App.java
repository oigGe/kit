package georggross;

/**
 * The Program status.
 * Contains players and the board.
 *
 * @author Georg Gross
 * @version 1.0
 */
public class App {
    private static final int FIVE = 5;
    private static final int SEVEN = 7;
    private Board board;
    private Player playerA;
    private Player playerB;
    private int size;
    private boolean isTorus;
    private int dice;


    /**
     * Constructor
     *
     * @param size - Size of the board.
     * @param isTorus - Boolean, true if torus mode. False if standard.
     */
    public App(int size, boolean isTorus) {
        this.size = size;
        if (size == 5) {
            this.dice = 6;
        } else {
            this.dice = 10;
        }
        this.isTorus = isTorus;
        if (isTorus) {
            this.board = new TorusBoard(size);
        } else {
            this.board = new Board(size);
        }
        this.playerA = new Player(1);
        this.playerB = new Player(2);

    }

    /**

     * Determines how many stones will be placed on the board and calls the necessary methods.
     * @param playerAPositions
     * @param playerBPositions
     */
    public void start(int[] playerAPositions, int[] playerBPositions) {

        if (size == FIVE) {
            StartingPositions.setFiveBoard(board, playerA, playerB, playerAPositions, playerBPositions, isTorus);
        } else if (size == SEVEN) {
            StartingPositions.setSevenBoard(board, playerA, playerB, playerAPositions, playerBPositions, isTorus);
        }
    }

    public int getDice() {
        return dice;
    }

    public int getSize() {
        return size;
    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayerA() {
        return playerA;
    }

    public Player getPlayerB() {
        return playerB;
    }

    public boolean getIsTorus() {
        return isTorus;
    }
}
