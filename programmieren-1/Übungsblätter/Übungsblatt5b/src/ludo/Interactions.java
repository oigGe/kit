package Ludo;

import edu.kit.informatik.Terminal;

public class Interactions {

    private static boolean gameIsRunning = false;
    private Game game;

    public void start() {
        if (!gameIsRunning) {
            this.game = new Game();
            gameIsRunning = true;
            Terminal.printLine("OK");
        }
    }

    public void start(String input) {
        if (!gameIsRunning) {

//          check for winning conditions

            String[] playerInput = input.split(";");
            String redInput = playerInput[0];
            String blueInput = playerInput[1];
            String greenInput = playerInput[2];
            String yellowInput = playerInput[3];

            String[] splitRedInput = redInput.split(",");
            String[] splitBlueInput = blueInput.split(",");
            String[] splitGreenInput = greenInput.split(",");
            String[] splitYellowInput = yellowInput.split(",");

            String red1 = splitRedInput[0];
            String red2 = splitRedInput[1];
            String red3 = splitRedInput[2];
            String red4 = splitRedInput[3];

            String blue1 = splitBlueInput[0];
            String blue2 = splitBlueInput[1];
            String blue3 = splitBlueInput[2];
            String blue4 = splitBlueInput[3];

            String green1 = splitGreenInput[0];
            String green2 = splitGreenInput[1];
            String green3 = splitGreenInput[2];
            String green4 = splitGreenInput[3];

            String yellow1 = splitYellowInput[0];
            String yellow2 = splitYellowInput[1];
            String yellow3 = splitYellowInput[2];
            String yellow4 = splitYellowInput[3];

            String regex = "^(?=.*A)(?=.*B)(?=.*C)(?=.*D).*";

            if (redInput.matches(regex) || blueInput.matches(regex) || greenInput.matches(regex)
                    || yellowInput.matches(regex)) {
                Terminal.printLine("Error");
            } else {


                this.game = new Game(red1, red2, red3, red4, blue1, blue2, blue3, blue4, green1, green2, green3, green4,
                        yellow1, yellow2, yellow3, yellow4);
                Terminal.printLine("OK");
                gameIsRunning = true;

            }

        }
    }

    public void roll(int roll, Player player) {
        game.roll(player, roll);

    }

    public void move(Player player, int roll, String position) {
        game.move(player, roll, position);


//        check if won
//        check if parameters were correct
    }

    public void print() {


        Terminal.printLine(game.getRed().getPlayerBoard()[game.getRed().getFigure1().getPosition()] + ","
                + game.getRed().getPlayerBoard()[game.getRed().getFigure2().getPosition()] + ","
                + game.getRed().getPlayerBoard()[game.getRed().getFigure3().getPosition()] + ","
                + game.getRed().getPlayerBoard()[game.getRed().getFigure4().getPosition()]);

        Terminal.printLine(game.getBlue().getPlayerBoard()[game.getBlue().getFigure1().getPosition()] + ","
                + game.getBlue().getPlayerBoard()[game.getBlue().getFigure2().getPosition()] + ","
                + game.getBlue().getPlayerBoard()[game.getBlue().getFigure3().getPosition()] + ","
                + game.getBlue().getPlayerBoard()[game.getBlue().getFigure4().getPosition()]);

        Terminal.printLine(game.getGreen().getPlayerBoard()[game.getGreen().getFigure1().getPosition()] + ","
                + game.getGreen().getPlayerBoard()[game.getGreen().getFigure2().getPosition()] + ","
                + game.getGreen().getPlayerBoard()[game.getGreen().getFigure3().getPosition()] + ","
                + game.getGreen().getPlayerBoard()[game.getGreen().getFigure4().getPosition()]);

        Terminal.printLine(game.getYellow().getPlayerBoard()[game.getYellow().getFigure1().getPosition()] + ","
                + game.getYellow().getPlayerBoard()[game.getYellow().getFigure2().getPosition()] + ","
                + game.getYellow().getPlayerBoard()[game.getYellow().getFigure3().getPosition()] + ","
                + game.getYellow().getPlayerBoard()[game.getYellow().getFigure4().getPosition()]);


    }




    public void abort() {

    }

    public void quit() {

    }


    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public static boolean isGameIsRunning() {
        return gameIsRunning;
    }

    public static void setGameIsRunning(boolean gameIsRunning) {
        Interactions.gameIsRunning = gameIsRunning;
    }
}


