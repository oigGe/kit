package georggross;

import edu.kit.informatik.Terminal;

public class Main {
    public static void main(String[] args) {

        App app = new App(5,true);
        int[] reihenfolgeA = {1, 2, 3, 4, 5, 6};
        int[] reihenfolgeB = {2, 3, 1, 4, 6, 5};
        app.start(reihenfolgeA, reihenfolgeB);
        app.getBoard().printBoard();
        app.getBoard().getPosition(0, 0).getStone().move(app.getBoard(), 1, 1);
        app.getBoard().getPosition(1, 1).getStone().move(app.getBoard(), 2, 2);
        app.getBoard().getPosition(2, 2).getStone().move(app.getBoard(), 3, 3);
        app.getBoard().getPosition(3, 3).getStone().move(app.getBoard(), 3, 4 );
        app.getBoard().getPosition(3, 4).getStone().move(app.getBoard(), 3, 5 );
        app.getBoard().getPosition(3, 5).getStone().move(app.getBoard(), 3, 6 );

Terminal.printLine("__________________________________________________________");
        app.getBoard().printBoard();
        Terminal.printLine(app.getPlayerA().hasWon(app.getBoard()));

    }

}
