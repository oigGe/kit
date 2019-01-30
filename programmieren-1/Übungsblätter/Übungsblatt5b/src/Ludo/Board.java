package Ludo;

public class Board {

    private String[] board = new String[45];
    private String[] redBoard = new String[45];
    private String[] blueBoard = new String[45];
    private String[] greenBoard = new String[45];
    private String[] yellowBoard = new String[45];

    public Board() {

    }

    public void setUpBoard() {
        Board red = new Board();
        Board blue = new Board();
        Board green = new Board();
        Board yellow = new Board();

        red.board[0] = "SR";
        blue.board[0] = "SB";
        green.board[0] = "SG";
        yellow.board[0] = "SY";

        red.board[41] = "AR";
        blue.board[41] = "AB";
        green.board[41] = "AG";
        yellow.board[41] = "AY";

        red.board[42] = "BR";
        blue.board[42] = "BB";
        green.board[42] = "BG";
        yellow.board[42] = "BY";

        red.board[43] = "CR";
        blue.board[43] = "CB";
        green.board[43] = "CG";
        yellow.board[43] = "CY";

        red.board[44] = "DR";
        blue.board[44] = "DB";
        green.board[44] = "DG";
        yellow.board[44] = "DY";


// red fields
        for (int i = 0; i < 40; i++) {
            red.board[i + 1] = Integer.toString(i);
        }

        //blue fields
        int b = 10;

        for (int i = 0; i < 40; i++) {

            blue.board[i + 1] = Integer.toString(b);
            b++;
            if (b % 40 == 0) {
                b = 0;
            }
        }
// green fields

        int g = 20;

        for (int i = 0; i < 40; i++) {

            green.board[i + 1] = Integer.toString(g);
            g++;
            if (g % 40 == 0) {
                g = 0;
            }
        }

        // yellow fields

        int y = 30;

        for (int i = 0; i < 40; i++) {

            yellow.board[i + 1] = Integer.toString(y);
            y++;
            if (y % 40 == 0) {
                y = 0;
            }
        }

        redBoard = red.board;
        blueBoard = blue.board;
        greenBoard = green.board;
        yellowBoard = yellow.board;




    }

    public String[] getRedBoard() {
        return redBoard;
    }

    public void setRedBoard(String[] redBoard) {
        this.redBoard = redBoard;
    }

    public String[] getBlueBoard() {
        return blueBoard;
    }

    public void setBlueBoard(String[] blueBoard) {
        this.blueBoard = blueBoard;
    }

    public String[] getGreenBoard() {
        return greenBoard;
    }

    public void setGreenBoard(String[] greenBoard) {
        this.greenBoard = greenBoard;
    }

    public String[] getYellowBoard() {
        return yellowBoard;
    }

    public void setYellowBoard(String[] yellowBoard) {
        this.yellowBoard = yellowBoard;
    }
}
