package Ludo;

import edu.kit.informatik.Terminal;

public class Main {
    public static void main(String[] args) {


        Interactions interactions = new Interactions();

        String input = "";
        boolean running = false;
        Player red;
        Player blue;
        Player green;
        Player yellow;
        int roll = 0;
        String position = "0";
        boolean redTurn = true;


        while (!input.equals("quit")) {

            input = Terminal.readLine();

            while (!input.equals("abort")) {


                if (input.matches("start")) {
                    interactions.start();
                    running = true;
                } else if (input.matches("start.*")) {
                    String[] parts = input.split(" ");
                    interactions.start(parts[1]);
                    running = true;

                } else if (input.matches("roll.*")) {
                    String[] parts = input.split(" ");
                    String rollSting = parts[1];
                    roll = Integer.parseInt(rollSting);

                } else if (input.matches("print")) {

                }


                if (running) {

                    red = interactions.getGame().getRed();
                    blue = interactions.getGame().getBlue();
                    green = interactions.getGame().getGreen();
                    yellow = interactions.getGame().getYellow();

                    while (running) {


                        boolean blueTurn = false;
                        boolean greenTurn = false;
                        boolean yellowTurn = false;


                        while (redTurn) {
                            input = Terminal.readLine();
                            if (input.matches("roll.*")) {
                                String[] parts = input.split(" ");
                                String rollSting = parts[1];
                                roll = Integer.parseInt(rollSting);
                                interactions.roll(roll, red);

                                if (interactions.getGame().isValidRoll()) {
                                    Terminal.printLine("red");
                                } else {
                                    Terminal.printLine("blue");
                                    blueTurn = true;
                                    redTurn = false;
                                }
                                if (interactions.getGame().isValidRoll()) {
                                    input = Terminal.readLine();
                                    if (input.matches("move.*")) {
                                        String[] moveRedParts = input.split(" ");
                                        String movePosition = moveRedParts[1];
                                        interactions.move(red, roll, movePosition);
                                        Terminal.printLine("blue");
                                        blueTurn = true;
                                        redTurn = false;
                                        if (interactions.getGame())
                                    }
                                }
                                interactions.getGame().setValidRoll(true);
                            }
                            else if (input.matches("print")){
                                interactions.print();
                                Terminal.printLine("red");

                            }
                            else if (input.matches("abort")){
                                running = false;
                                Interactions.setGameIsRunning(false);

                            }
                        }




                        while (blueTurn) {
                            input = Terminal.readLine();
                            if (input.matches("roll.*")) {
                                String[] parts = input.split(" ");
                                String rollSting = parts[1];
                                roll = Integer.parseInt(rollSting);
                                interactions.roll(roll, blue);

                                if (interactions.getGame().isValidRoll()) {
                                    Terminal.printLine("blue");
                                } else {
                                    Terminal.printLine("green");
                                    greenTurn = true;
                                    blueTurn = false;
                                }
                                if (interactions.getGame().isValidRoll()) {
                                    input = Terminal.readLine();
                                    if (input.matches("move.*")) {
                                        String[] moveRedParts = input.split(" ");
                                        String movePosition = moveRedParts[1];
                                        interactions.move(blue, roll, movePosition);
                                        Terminal.printLine("green");
                                        greenTurn = true;
                                        blueTurn = false;
                                    }
                                }
                                interactions.getGame().setValidRoll(true);
                            }
                            else if (input.matches("print")){
                                interactions.print();
                                Terminal.printLine("blue");

                            }
                            else if (input.matches("abort")){
                                running = false;
                                Interactions.setGameIsRunning(false);
                            }
                        }


                        while (greenTurn) {
                            input = Terminal.readLine();
                            if (input.matches("roll.*")) {
                                String[] parts = input.split(" ");
                                String rollSting = parts[1];
                                roll = Integer.parseInt(rollSting);
                                interactions.roll(roll, green);
                                if (interactions.getGame().isValidRoll()) {
                                    Terminal.printLine("green");
                                } else {
                                    Terminal.printLine("yellow");
                                    yellowTurn = true;
                                    greenTurn = false;
                                }
                                if (interactions.getGame().isValidRoll()) {
                                    input = Terminal.readLine();
                                    if (input.matches("move.*")) {
                                        String[] moveRedParts = input.split(" ");
                                        String movePosition = moveRedParts[1];
                                        interactions.move(green, roll, movePosition);
                                        Terminal.printLine("yellow");
                                        yellowTurn = true;
                                        greenTurn = false;
                                    }
                                }
                                interactions.getGame().setValidRoll(true);
                            }
                            else if (input.matches("print")){
                                interactions.print();
                                Terminal.printLine("green");

                            }
                            else if (input.matches("abort")){
                                running = false;
                                Interactions.setGameIsRunning(false);
                            }
                        }

                        while (yellowTurn) {
                            input = Terminal.readLine();
                            if (input.matches("roll.*")) {
                                String[] parts = input.split(" ");
                                String rollSting = parts[1];
                                roll = Integer.parseInt(rollSting);
                                interactions.roll(roll, yellow);
                                if (interactions.getGame().isValidRoll()) {
                                    Terminal.printLine("yellow");
                                } else {
                                    Terminal.printLine("red");
                                    redTurn = true;
                                    yellowTurn = false;
                                }
                                if (interactions.getGame().isValidRoll()) {
                                    input = Terminal.readLine();
                                    if (input.matches("move.*")) {
                                        String[] moveRedParts = input.split(" ");
                                        String movePosition = moveRedParts[1];
                                        interactions.move(yellow, roll, movePosition);
                                        Terminal.printLine("red");
                                        redTurn = true;
                                        yellowTurn = false;
                                    }
                                }
                                interactions.getGame().setValidRoll(true);
                            }
                            else if (input.matches("print")){
                                interactions.print();
                                Terminal.printLine("yellow");

                            }
                            else if (input.matches("abort")){
                                running = false;
                                Interactions.setGameIsRunning(false);
                            }
                        }




                    }


                }

            }

        }


    }
}
