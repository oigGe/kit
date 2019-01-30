package Ludo;

public class Interactions {

    public void start(){
        Game game = new Game();
    }

    public void start(String red1, String red2, String red3, String red4, String blue1, String blue2, String blue3, String blue4,
                      String green1, String green2, String green3, String green4, String yellow1, String yellow2, String yellow3,
                      String yellow4){
        Game game = new Game(red1,red2,red3,red4,green1,green2,green3,green4,blue1,blue2,blue3,blue4,yellow1,yellow2,yellow3,yellow4);
    }


}
