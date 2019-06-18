package georggross;

public class App {
    private Board board;
    private Player playerA;
    private Player playerB;
    private int size;
    private final int FIVExFIVE = 5;
    private final int SEVEN = 7;
    boolean isTorus;


    public App(int size, boolean isTorus) {
        this.size = size;
        this.isTorus = isTorus;
        if (isTorus) {
            this.board = new TorusBoard(size);
        } else {
            this.board = new Board(size);
        }
        this.playerA = new Player(1);
        this.playerB = new Player(2);

    }

    public void start(int[] playerAPositions, int[] playerBPositions) {

        if (size == FIVExFIVE) {
            StartingPositions.setFiveBoard(board, playerA, playerB, playerAPositions, playerBPositions, isTorus);
        } else if (size == SEVEN) {
            StartingPositions.setSevenBoard(board, playerA, playerB, playerAPositions, playerBPositions, isTorus);
        }
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
}
