package Ludo;

public class Player {
    private String color;
    private Figure figure1;
    private Figure figure2;
    private Figure figure3;
    private Figure figure4;
    private Figure [] figuresPositions;
    private Board board = new Board();
    private String playerBoard [];


    public Player(String color) {
        board.setUpBoard();
        this.color = color;
        this.figure1 = new Figure("figure1");
        this.figure2 = new Figure("figure2");
        this.figure3 = new Figure("figure3");
        this.figure4 = new Figure("figure4");
        this.figuresPositions = new Figure[45];
        for (int i = 0; i < figuresPositions.length; i++){
            figuresPositions[i] = new Figure("0");
            figuresPositions[i].setPosition(i);
        }
        switch (color) {
            case "red": this.playerBoard = board.getRedBoard();
            break;

            case "blue": this.playerBoard = board.getBlueBoard();
            break;

            case "green": this.playerBoard = board.getGreenBoard();
            break;

            case "yellow": this.playerBoard = board.getYellowBoard();
        }

    }

    public Figure getFigure1() {
        return figure1;

    }

    public void setFigure1(Figure figure1) {
        this.figure1 = figure1;
    }

    public Figure getFigure2() {
        return figure2;
    }

    public void setFigure2(Figure figure2) {
        this.figure2 = figure2;
    }

    public Figure getFigure3() {
        return figure3;
    }

    public void setFigure3(Figure figure3) {
        this.figure3 = figure3;
    }

    public Figure getFigure4() {
        return figure4;
    }

    public void setFigure4(Figure figure4) {
        this.figure4 = figure4;
    }

    public Figure[] getFiguresPositions() {
        return figuresPositions;
    }

    public void setFiguresPositions(int index, Figure figure) {
        this.figuresPositions[index] = figure;
    }

    public void setFiguresPositions(int index, String name) {
        this.figuresPositions[index].setName(name);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String[] getPlayerBoard() {
        return playerBoard;
    }

    public void setPlayerBoard(String[] playerBoard) {
        this.playerBoard = playerBoard;
    }
}

