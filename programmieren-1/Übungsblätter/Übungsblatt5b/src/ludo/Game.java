package Ludo;


import edu.kit.informatik.Terminal;

import java.util.Arrays;

public class Game {
    private boolean validRoll = true;
    private Board board = new Board();
    private Player red = new Player("red");
    private Player blue = new Player("blue");
    private Player green = new Player("green");
    private Player yellow = new Player("yellow");
    private Figure[] globalPositions = new Figure[40];


    public Game() {
        board.setUpBoard();
        for (int i = 0; i < getGlobalPositions().length; i++) {
            getGlobalPositions()[i] = new Figure("0");
            getGlobalPositions()[i].setPosition(i);
        }

    }

    public Game(String red1, String red2, String red3, String red4, String blue1, String blue2, String blue3
            , String blue4,
                String green1, String green2, String green3, String green4, String yellow1, String yellow2
            , String yellow3,
                String yellow4) {

        board.setUpBoard();
        for (int i = 0; i < getGlobalPositions().length; i++) {
            getGlobalPositions()[i] = new Figure("0");
            getGlobalPositions()[i].setPosition(i);
        }

        String[] inputPositions = new String[]{red1, red2, red3, red4, blue1, blue2, blue3, blue4, green1, green2, green3, green4, yellow1, yellow2, yellow3, yellow4};
        String regex = "-?\\d+(\\.\\d+)?";
        for (int i = 0; i < inputPositions.length; i++) {

            if (i < 4) {
                int x = 1;

                if (inputPositions[i].matches(regex)) {
                    for (int j = 0; j < red.getPlayerBoard().length; j++) {
                        if (red.getPlayerBoard()[j].equals(inputPositions[i])) {
                            Figure newGlobalPosition = new Figure("red" + " " + "figure" + i);

                            newGlobalPosition.setPosition(Integer.parseInt(inputPositions[i]));
                            globalPositions[Integer.parseInt(inputPositions[i])] = newGlobalPosition;
                        }
                    }
                }

                for (int a = 0; a < red.getPlayerBoard().length; a++) {
                    if (red.getPlayerBoard()[a].equals(inputPositions[i])) {
                        if (i == 0) {

                            red.getFigure1().setPosition(a);
                            red.setFiguresPositions(a, red.getFigure1());
                        } else if (i == 1) {

                            red.getFigure2().setPosition(a);
                            red.setFiguresPositions(a, red.getFigure2());
                        } else if (i == 2) {

                            red.getFigure3().setPosition(a);
                            red.setFiguresPositions(a, red.getFigure3());
                        } else if (i == 3) {

                            red.getFigure4().setPosition(a);
                            red.setFiguresPositions(a, red.getFigure4());
                        }
                    }
                }


            } else if (i < 8) {

                int q = 1;

                if (inputPositions[i].matches(regex)) {
                    for (int j = 0; j < blue.getPlayerBoard().length; j++) {
                        if (blue.getPlayerBoard()[j].equals(inputPositions[i])) {
                            Figure newGlobalPosition = new Figure("blue figure" + (i - 4));
                            q++;
                            newGlobalPosition.setPosition(Integer.parseInt(inputPositions[i]));
                            globalPositions[Integer.parseInt(inputPositions[i])] = newGlobalPosition;
                        }
                    }
                }

                for (int a = 0; a < blue.getPlayerBoard().length; a++) {
                    if (blue.getPlayerBoard()[a].equals(inputPositions[i])) {
                        if (i == 4) {

                            blue.getFigure1().setPosition(a);
                            blue.setFiguresPositions(a, blue.getFigure1());
                        } else if (i == 5) {

                            blue.getFigure2().setPosition(a);
                            blue.setFiguresPositions(a, blue.getFigure2());
                        } else if (i == 6) {

                            blue.getFigure3().setPosition(a);
                            blue.setFiguresPositions(a, blue.getFigure3());
                        } else if (i == 7) {

                            blue.getFigure4().setPosition(a);
                            blue.setFiguresPositions(a, blue.getFigure4());
                        }
                    }
                }

            } else if (i < 12) {

                int e = 1;

                if (inputPositions[i].matches(regex)) {
                    for (int j = 0; j < green.getPlayerBoard().length; j++) {
                        if (green.getPlayerBoard()[j].equals(inputPositions[i])) {
                            Figure newGlobalPosition = new Figure("green figure" + (i - 8));
                            e++;
                            newGlobalPosition.setPosition(Integer.parseInt(inputPositions[i]));
                            globalPositions[Integer.parseInt(inputPositions[i])] = newGlobalPosition;
                        }
                    }
                }

                for (int a = 0; a < green.getPlayerBoard().length; a++) {
                    if (green.getPlayerBoard()[a].equals(inputPositions[i])) {
                        if (i == 8) {

                            green.getFigure1().setPosition(a);
                            green.setFiguresPositions(a, green.getFigure1());
                        } else if (i == 9) {

                            green.getFigure2().setPosition(a);
                            green.setFiguresPositions(a, green.getFigure2());
                        } else if (i == 10) {

                            green.getFigure3().setPosition(a);
                            green.setFiguresPositions(a, green.getFigure3());
                        } else if (i == 11) {

                            green.getFigure4().setPosition(a);
                            green.setFiguresPositions(a, green.getFigure4());
                        }
                    }
                }

            } else if (i < 16) {

                int r = 1;

                if (inputPositions[i].matches(regex)) {
                    for (int j = 0; j < yellow.getPlayerBoard().length; j++) {
                        if (yellow.getPlayerBoard()[j].equals(inputPositions[i])) {
                            Figure newGlobalPosition = new Figure("yellow figure" + (i - 12));
                            r++;
                            newGlobalPosition.setPosition(Integer.parseInt(inputPositions[i]));
                            globalPositions[Integer.parseInt(inputPositions[i])] = newGlobalPosition;
                        }
                    }
                }

                for (int a = 0; a < yellow.getPlayerBoard().length; a++) {
                    if (yellow.getPlayerBoard()[a].equals(inputPositions[i])) {
                        if (i == 12) {

                            yellow.getFigure1().setPosition(a);
                            yellow.setFiguresPositions(a, yellow.getFigure1());
                        } else if (i == 13) {

                            yellow.getFigure2().setPosition(a);
                            yellow.setFiguresPositions(a, yellow.getFigure2());
                        } else if (i == 14) {

                            yellow.getFigure3().setPosition(a);
                            yellow.setFiguresPositions(a, yellow.getFigure3());
                        } else if (i == 15) {

                            blue.getFigure4().setPosition(a);
                            blue.setFiguresPositions(a, blue.getFigure4());
                        }
                    }
                }

            }

        }

    }

    public void printBoard() {
        Terminal.printLine(Arrays.toString(board.getRedBoard()));
    }

    public void kickFigure(int position) {
        String whichPlayer = globalPositions[position].getName();
        String[] parts = whichPlayer.split(" ");
        String thatPlayer = parts[0];

        if (thatPlayer.equals("red")) {
            for (int i = 0; i < red.getPlayerBoard().length; i++) {
                if (red.getPlayerBoard()[i].equals(String.valueOf(position))) {
                    Figure kickedFigure = red.getFiguresPositions()[i];
                    kickedFigure.setPosition(0);
                    Figure emptyFigure = new Figure("0");
                    emptyFigure.setPosition(i);
                    red.setFiguresPositions(i, emptyFigure);
                    break;

                }
            }
        } else if (thatPlayer.equals("yellow")) {
            for (int i = 0; i < yellow.getPlayerBoard().length; i++) {
                if (yellow.getPlayerBoard()[i].equals(String.valueOf(position))) {
                    Figure kickedFigure = yellow.getFiguresPositions()[i];
                    kickedFigure.setPosition(0);
                    Figure emptyFigure = new Figure("0");
                    emptyFigure.setPosition(i);
                    yellow.setFiguresPositions(i, emptyFigure);
                    break;

                }
            }
        } else if (thatPlayer.equals("green")) {
            for (int i = 0; i < green.getPlayerBoard().length; i++) {
                if (green.getPlayerBoard()[i].equals(String.valueOf(position))) {
                    Figure kickedFigure = green.getFiguresPositions()[i];
                    kickedFigure.setPosition(0);
                    Figure emptyFigure = new Figure("0");
                    emptyFigure.setPosition(i);
                    green.setFiguresPositions(i, emptyFigure);
                    break;

                }
            }
        } else if (thatPlayer.equals("blue")) {
            for (int i = 0; i < yellow.getPlayerBoard().length; i++) {
                if (blue.getPlayerBoard()[i].equals(String.valueOf(position))) {
                    Figure kickedFigure = blue.getFiguresPositions()[i];
                    kickedFigure.setPosition(0);
                    Figure emptyFigure = new Figure("0");
                    emptyFigure.setPosition(i);
                    blue.setFiguresPositions(i, emptyFigure);
                    break;

                }
            }
        }


    }

    public void roll(Player player, int diceRoll) {


        if (diceRoll == 6) {

            // if no figures out
            if ((player.getFigure1().getPosition() == 0) && (player.getFigure2().getPosition() == 0) && (player.getFigure3().getPosition() == 0) && (player.getFigure4().getPosition() == 0)) {

                Terminal.printLine(player.getPlayerBoard()[player.getFigure1().getPosition()] + "-" + player.getPlayerBoard()[player.getFigure1().getPosition() + 1]);


                // if at least one figure out
            } else if ((player.getFigure1().getPosition() == 0) || (player.getFigure2().getPosition() == 0) || (player.getFigure3().getPosition() == 0) || (player.getFigure4().getPosition() == 0)) {
                // if position 1 is free
                if (player.getFiguresPositions()[1].getName().equals("0")) {
                    if (player.getFigure1().getPosition() == 0) {
                        Terminal.printLine(player.getPlayerBoard()[player.getFigure1().getPosition()] + "-" + player.getPlayerBoard()[player.getFigure1().getPosition() + 1]);

                    } else if (player.getFigure2().getPosition() == 0) {
                        Terminal.printLine(player.getPlayerBoard()[player.getFigure2().getPosition()] + "-" + player.getPlayerBoard()[player.getFigure2().getPosition() + 1]);

                    } else if (player.getFigure3().getPosition() == 0) {
                        Terminal.printLine(player.getPlayerBoard()[player.getFigure3().getPosition()] + "-" + player.getPlayerBoard()[player.getFigure3().getPosition() + 1]);

                    } else if (player.getFigure4().getPosition() == 0) {
                        Terminal.printLine(player.getPlayerBoard()[player.getFigure4().getPosition()] + "-" + player.getPlayerBoard()[player.getFigure4().getPosition() + 1]);

                    }


                    //if position 1 isnt free
                } else if (!player.getFiguresPositions()[1].getName().equals("0")) {
                    if (isFree(player, player.getFiguresPositions()[1], diceRoll)) {
                        Terminal.printLine(player.getPlayerBoard()[player.getFiguresPositions()[1].getPosition()] + "-" + player.getPlayerBoard()[player.getFiguresPositions()[1 + diceRoll].getPosition()]);
                    } else {
                        if (isFree(player, player.getFiguresPositions()[1 + diceRoll], diceRoll)) {
                            Terminal.printLine(player.getPlayerBoard()[player.getFiguresPositions()[1 + diceRoll].getPosition()] + "-" + player.getPlayerBoard()[player.getFiguresPositions()[1 + diceRoll + diceRoll].getPosition()]);
                        } else {
                            if (isFree(player, player.getFiguresPositions()[1 + diceRoll + diceRoll], diceRoll)) {
                                Terminal.printLine(player.getPlayerBoard()[player.getFiguresPositions()[1 + diceRoll + diceRoll].getPosition()] + "-" + player.getPlayerBoard()[player.getFiguresPositions()[1 + diceRoll + diceRoll + diceRoll].getPosition()]);
                            }
                        }
                    }
                }
                //if all figures are out
            } else {
                if (isFree(player, player.getFigure1(), diceRoll) && (player.getFigure1().getPosition() + diceRoll < player.getPlayerBoard().length)) {
                    Terminal.printLine(player.getPlayerBoard()[player.getFigure1().getPosition()] + "-" + player.getPlayerBoard()[player.getFigure1().getPosition() + diceRoll]);
                }
                if (isFree(player, player.getFigure2(), diceRoll) && (player.getFigure1().getPosition() + diceRoll < player.getPlayerBoard().length)) {
                    Terminal.printLine(player.getPlayerBoard()[player.getFigure2().getPosition()] + "-" + player.getPlayerBoard()[player.getFigure2().getPosition() + diceRoll]);
                }
                if (isFree(player, player.getFigure3(), diceRoll) && (player.getFigure1().getPosition() + diceRoll < player.getPlayerBoard().length)) {
                    Terminal.printLine(player.getPlayerBoard()[player.getFigure3().getPosition()] + "-" + player.getPlayerBoard()[player.getFigure3().getPosition() + diceRoll]);
                }
                if (isFree(player, player.getFigure4(), diceRoll) && (player.getFigure1().getPosition() + diceRoll < player.getPlayerBoard().length)) {
                    Terminal.printLine(player.getPlayerBoard()[player.getFigure4().getPosition()] + "-" + player.getPlayerBoard()[player.getFigure4().getPosition() + diceRoll]);
                }
            }


        } else {

            boolean canMove = false;
            //if at least one figure is out and diceroll is != 6;

            if (isFree(player, player.getFigure1(), diceRoll) && (player.getFigure1().getPosition() != 0) && (player.getFigure1().getPosition() + diceRoll < player.getPlayerBoard().length)) {
                Terminal.printLine(player.getPlayerBoard()[player.getFigure1().getPosition()] + "-" + player.getPlayerBoard()[player.getFigure1().getPosition() + diceRoll]);
                canMove = true;
            }
            if (isFree(player, player.getFigure2(), diceRoll) && (player.getFigure2().getPosition() != 0) && (player.getFigure1().getPosition() + diceRoll < player.getPlayerBoard().length)) {
                Terminal.printLine(player.getPlayerBoard()[player.getFigure2().getPosition()] + "-" + player.getPlayerBoard()[player.getFigure2().getPosition() + diceRoll]);
                canMove = true;
            }
            if (isFree(player, player.getFigure3(), diceRoll) && (player.getFigure3().getPosition() != 0) && (player.getFigure1().getPosition() + diceRoll < player.getPlayerBoard().length)) {
                Terminal.printLine(player.getPlayerBoard()[player.getFigure3().getPosition()] + "-" + player.getPlayerBoard()[player.getFigure3().getPosition() + diceRoll]);
                canMove = true;
            }
            if (isFree(player, player.getFigure4(), diceRoll) && (player.getFigure4().getPosition() != 0) && (player.getFigure1().getPosition() + diceRoll < player.getPlayerBoard().length)) {
                Terminal.printLine(player.getPlayerBoard()[player.getFigure4().getPosition()] + "-" + player.getPlayerBoard()[player.getFigure4().getPosition() + diceRoll]);
                canMove = true;
            }
            if (!canMove) {
                Terminal.printLine("falsefalsefalse");
                validRoll = false;
            }

        }


    }

    public void move(Player player, int confirmedRoll, String position) {
        Figure newGlobalPosition = new Figure("0");
        if (confirmedRoll == 6) {
            if ((player.getFigure1().getPosition() == 0) && (player.getFigure2().getPosition() == 0)
                    && (player.getFigure3().getPosition() == 0) && (player.getFigure4().getPosition() == 0)) {

                player.getFigure1().setPosition(1);
                player.setFiguresPositions(1, player.getFigure1());
                Terminal.printLine(player.getPlayerBoard()[1]);

//                check if beat other player
                if (!globalPositions[Integer.parseInt((player.getPlayerBoard()[1]))].getName().equals("0")) {
                    kickFigure(Integer.parseInt(player.getPlayerBoard()[1]));
                }

//                set global position
                newGlobalPosition.setPosition(Integer.parseInt(player.getPlayerBoard()[1]));
                newGlobalPosition.setName(player.getColor() + " " + "figure1");
                globalPositions[Integer.parseInt(player.getPlayerBoard()[1])] = newGlobalPosition;


            } else if ((player.getFigure1().getPosition() == 0) || (player.getFigure2().getPosition() == 0)
                    || (player.getFigure3().getPosition() == 0) || (player.getFigure4().getPosition() == 0)) {
                // if position 1 is free
                if (player.getFiguresPositions()[1].getName().equals("0")) {
                    if (player.getFigure1().getPosition() == 0) {
                        player.getFigure1().setPosition(1);
                        player.setFiguresPositions(1, player.getFigure1());
                        Terminal.printLine(player.getPlayerBoard()[1]);

                        //                check if kick other player
                        if (!globalPositions[Integer.parseInt((player.getPlayerBoard()[1]))].getName().equals("0")) {
                            kickFigure(Integer.parseInt(player.getPlayerBoard()[1]));
                        }

//                        set global position
                        newGlobalPosition.setPosition(Integer.parseInt(player.getPlayerBoard()[1]));
                        newGlobalPosition.setName(player.getColor() + " " + "figure1");
                        globalPositions[Integer.parseInt(player.getPlayerBoard()[1])] = newGlobalPosition;

                    } else if (player.getFigure2().getPosition() == 0) {
                        player.getFigure2().setPosition(1);
                        player.setFiguresPositions(1, player.getFigure2());
                        Terminal.printLine(player.getPlayerBoard()[1]);

                        //                check if kick other player
                        if (!globalPositions[Integer.parseInt((player.getPlayerBoard()[1]))].getName().equals("0")) {
                            kickFigure(Integer.parseInt(player.getPlayerBoard()[1]));
                        }

//                        set global position
                        newGlobalPosition.setPosition(Integer.parseInt(player.getPlayerBoard()[1]));
                        newGlobalPosition.setName(player.getColor() + " " + "figure2");
                        globalPositions[Integer.parseInt(player.getPlayerBoard()[1])] = newGlobalPosition;

                    } else if (player.getFigure3().getPosition() == 0) {
                        player.getFigure3().setPosition(1);
                        player.setFiguresPositions(1, player.getFigure3());
                        Terminal.printLine(player.getPlayerBoard()[1]);

                        //                check if kick other player
                        if (!globalPositions[Integer.parseInt((player.getPlayerBoard()[1]))].getName().equals("0")) {
                            kickFigure(Integer.parseInt(player.getPlayerBoard()[1]));
                        }


                        //                        set global position
                        newGlobalPosition.setPosition(Integer.parseInt(player.getPlayerBoard()[1]));
                        newGlobalPosition.setName(player.getColor() + " " + "figure3");
                        globalPositions[Integer.parseInt(player.getPlayerBoard()[1])] = newGlobalPosition;

                    } else if (player.getFigure4().getPosition() == 0) {
                        player.getFigure4().setPosition(1);
                        player.setFiguresPositions(1, player.getFigure4());
                        Terminal.printLine(player.getPlayerBoard()[1]);


                        //                check if kick other player
                        if (!globalPositions[Integer.parseInt((player.getPlayerBoard()[1]))].getName().equals("0")) {
                            kickFigure(Integer.parseInt(player.getPlayerBoard()[1]));
                        }


                        //                        set global position
                        newGlobalPosition.setPosition(Integer.parseInt(player.getPlayerBoard()[1]));
                        newGlobalPosition.setName(player.getColor() + " " + "figure1");
                        globalPositions[Integer.parseInt(player.getPlayerBoard()[1])] = newGlobalPosition;

                    }


                }


            } else {
//
                for (int i = 0; i < board.getRedBoard().length; i++) {
                    if (player.getPlayerBoard()[i].equals(position)) {
//                        String newName = player.getFiguresPositions()[i].getName();
//                        player.getFiguresPositions()[i].setName("0");
//                        player.getFiguresPositions()[i + confirmedRoll].setName(newName);
//                        player.getFiguresPositions()[i + confirmedRoll].setPosition(i + confirmedRoll);
                        Figure movedFigure = player.getFiguresPositions()[i];
                        movedFigure.setPosition(i + confirmedRoll);
                        player.setFiguresPositions(i + confirmedRoll, movedFigure);
                        Figure emptyFigure = new Figure("0");
                        emptyFigure.setPosition(i);
                        player.setFiguresPositions(i, emptyFigure);
                        Terminal.printLine(player.getPlayerBoard()[i + confirmedRoll]);


                        //                check if kick other player
                        if (!globalPositions[Integer.parseInt((player.getPlayerBoard()[i + confirmedRoll]))]
                                .getName().equals("0")) {
                            kickFigure(Integer.parseInt(player.getPlayerBoard()[i + confirmedRoll]));
                        }

                        //                        set global position

                        if (i + confirmedRoll < 41) {
                            newGlobalPosition.setPosition(Integer.parseInt(player.getPlayerBoard()[i
                                    + confirmedRoll]));
                            newGlobalPosition.setName(player.getColor() + " " + movedFigure.getName());
                            globalPositions[Integer.parseInt(player.getPlayerBoard()[i
                                    + confirmedRoll])] = newGlobalPosition;
                        } else {
                            newGlobalPosition.setPosition(Integer.parseInt(player.getPlayerBoard()[i]));
                            newGlobalPosition.setName("0");
                            globalPositions[Integer.parseInt(player.getPlayerBoard()[i])] = newGlobalPosition;

                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < player.getPlayerBoard().length; i++) {

                if (player.getPlayerBoard()[i].equals(position)) {
                    Figure movedFigure = player.getFiguresPositions()[i];
                    movedFigure.setPosition(i + confirmedRoll);
                    player.setFiguresPositions(i + confirmedRoll, movedFigure);
                    Figure emptyFigure = new Figure("0");
                    emptyFigure.setPosition(i);
                    player.setFiguresPositions(i, emptyFigure);
                    Terminal.printLine(player.getPlayerBoard()[i + confirmedRoll]);

//                    String newName = player.getFiguresPositions()[i].getName();
//                    player.getFiguresPositions()[i].setName("0");
//                    player.getFiguresPositions()[i + confirmedRoll].setName(newName);
//                    player.getFiguresPositions()[i + confirmedRoll].setPosition(i + confirmedRoll);

                    //                check if kick other player
                    if (!globalPositions[Integer.parseInt((player.getPlayerBoard()[i + confirmedRoll]))]
                            .getName().equals("0")) {
                        kickFigure(Integer.parseInt(player.getPlayerBoard()[i + confirmedRoll]));
                    }

                    //                        set global position
                    if (i + confirmedRoll < 41) {
                        newGlobalPosition.setPosition(Integer.parseInt(player.getPlayerBoard()[i + confirmedRoll]));
                        newGlobalPosition.setName(player.getColor() + " " + movedFigure.getName());
                        globalPositions[Integer.parseInt(player.getPlayerBoard()[i + confirmedRoll])]
                                = newGlobalPosition;
                        globalPositions[Integer.parseInt(player.getPlayerBoard()[i])].setName("0");
                    } else {
                        newGlobalPosition.setPosition(Integer.parseInt(player.getPlayerBoard()[i]));
                        newGlobalPosition.setName("0");
                        globalPositions[Integer.parseInt(player.getPlayerBoard()[i])] = newGlobalPosition;

                    }
                }

            }
        }


    }


    public boolean isFree(Player player, Figure figure, int roll) {
//        return true if the value in figuresPositions in Player at the index of the moved figures next position is 0;
        if (figure.getPosition() + roll < 45) {
            return player.getFiguresPositions()[figure.getPosition() + roll].getName().equals("0");
        }
        return false;
    }


//    public void setOccupied(Player player, Figure figure, int roll) {
//        Figure l = new Figure("0");
//        int newPosition = player.getFiguresPositions()[figure.getPosition()].getPosition() + roll;
//        player.setFiguresPositions(figure.getPosition(), l);
//        player.setFiguresPositions(newPosition, figure);
//    }

    public boolean hasWon(Player player) {
        for (int i = 41; i < 45; i++) {
            if (player.getFiguresPositions()[i].getName().equals("0")) {
                return false;
            }
        }
        return true;
    }

    public Board getBoard() {
        return board;
    }

    public Player getRed() {
        return red;
    }

    public Player getBlue() {
        return blue;
    }

    public Player getGreen() {
        return green;
    }

    public Player getYellow() {
        return yellow;
    }

    public Figure[] getGlobalPositions() {
        return globalPositions;
    }

    public boolean isValidRoll() {
        return validRoll;
    }

    public void setValidRoll(boolean validRoll) {
        this.validRoll = validRoll;
    }
}
