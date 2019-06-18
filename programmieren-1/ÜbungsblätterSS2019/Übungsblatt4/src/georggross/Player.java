package georggross;

import java.util.ArrayList;

public class Player {
    private final int PLAYERA = 1;
    private final int PLAYERB = 2;
    private int id;
    private ArrayList<Stone> stones;


    public Player(int id) {
        this.id = id;

        stones = new ArrayList<>();
    }

    public void addStone(Stone stone) {
        stones.add(stone);
    }

    public void removeStone(Stone stone) {
        stones.remove(stone);
    }

    public boolean hasLost() {
        return stones.size() == 0;
    }

    public int getId() {
        return id;
    }
    public int token(){
        return stones.size();
    }


    public ArrayList<Stone> getRollOptions(int roll){
        ArrayList<Stone> rollOptions = new ArrayList<>();
        boolean hasRoll = false;
        for (int i = 0; i < stones.size(); i++){
            if (roll == stones.get(i).getNumber()){
                rollOptions.add(stones.get(i));
                hasRoll = true;
            }
        }if (!hasRoll){
            int j = roll;
            int k = roll;
            for (int i = 0; i < stones.size(); i++){
                if (stones.get(i).getNumber() == j){
                    rollOptions.add(stones.get(i));
                    break;
                }
                j++;
            }for (int i = 0; i< stones.size(); i++){
                if (stones.get(i).getNumber() == j){
                    rollOptions.add(stones.get(i));
                    break;
                }
                k++;
            }
        }return rollOptions;
    }



    public boolean hasWon(Board board){
        if (id == PLAYERA){
            for (int i = 0; i < stones.size(); i++){
                if (stones.get(i).getPosition().equals(board.getPosition(board.getSize()-1,board.getSize()-1))){
                    return true;
                }
            }
        }else if (id == PLAYERB){
            for (int i = 0; i < stones.size();i++){
                if (stones.get(i).getPosition().equals(board.getPosition(0,0))){
                    return true;
                }
            }
        }return false;
    }
}
