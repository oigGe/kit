package Ludo;

import edu.kit.informatik.Terminal;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Game game = new Game("36","AR","CR","DR","SB","10","16","22","SG","13","BG","DG","SY", "0", "20", "BY");




        Terminal.printLine(Arrays.toString(game.getYellow().getPlayerBoard()));






















        Terminal.printLine("Golbal:");
        for (int i = 0; i < game.getGlobalPositions().length; i++){
            Terminal.printLine(game.getGlobalPositions()[i].getName() + " :  " + game.getGlobalPositions()[i].getPosition());
       }
        Terminal.printLine("-------------------------------------------");
        Terminal.printLine("Yellow:");
        for (int i = 0; i < game.getYellow().getPlayerBoard().length; i++){
           Terminal.printLine(game.getYellow().getFiguresPositions()[i].getName() + " : " + game.getYellow().getFiguresPositions()[i].getPosition() );
       }
        Terminal.printLine("-------------------------------------------");

        Terminal.printLine("red:");
        for (int i = 0; i < game.getRed().getFiguresPositions().length; i++){
            Terminal.printLine((game.getRed().getFiguresPositions()[i].getName()) + " : " + (game.getRed().getFiguresPositions()[i].getPosition()));
        }






























        //
//        game.move(game.getRed(),6,"SR");
//        game.move(game.getRed(),4,"0");
//        game.move(game.getRed(),6,"SR");
//        game.move(game.getRed(),5,"0");
//        game.move(game.getRed(),6,"SR");
//        game.move(game.getRed(),5,"5");
//        game.move(game.getRed(),5,"10");
//        game.move(game.getRed(),5,"0");
//        game.move(game.getRed(),6,"SR");
//        game.move(game.getRed(),6,"0");
//        game.move(game.getRed(),6,"15");
//        game.move(game.getRed(),6,"21");
//        game.move(game.getRed(),6,"27");
//        game.move(game.getRed(),6,"33");
//        game.move(game.getRed(),4,"39");
//        game.move(game.getRed(),20,"4");
//        game.move(game.getRed(),18,"24");
//        game.move(game.getRed(),35,"6");
//        Terminal.printLine(game.hasWon(game.getRed()));
//        game.move(game.getRed(),35,"5");
//        Terminal.printLine(game.hasWon(game.getRed()));






//

//

//
//        Terminal.printLine(game.hasWon(game.getBlue()));
    }
}
