package georggross;

public class StartingPositions {
    private static final String[] START_POS_PLAYER_A_FIVE = {"00", "01", "02", "10", "11", "20"};
    private static final String[] START_POS_PLAYER_B_FIVE = {"24", "33", "34", "42", "43", "44"};
    private static final String[] START_POS_PLAYER_A_SEVEN = {"00", "01", "02", "03", "10", "11", "12", "20",
            "21", "30"};
    private static final String[] START_POS_PLAYER_B_SEVEN = {"36", "45", "46", "54", "55", "56", "63",
            "64", "65", "66"};


    public static void setFiveBoard(Board board, Player playerA, Player playerB, int[] playerAPositions,
                                    int[] playerBPositions, boolean isTorus) {

        for (int i = 0; i < START_POS_PLAYER_A_FIVE.length; i++) {
            Position thisPosition = board.getPositionWithName(START_POS_PLAYER_A_FIVE[i]);
            if (thisPosition != null) {
                Stone newStone;
                if (!isTorus) {
                    newStone = new Stone(playerAPositions[i], playerA, thisPosition);
                } else {
                    newStone = new TorusStone(playerAPositions[i], playerA, thisPosition);
                }
                board.setStone(newStone);
                playerA.addStone(newStone);
            }
        }
        for (int i = 0; i < START_POS_PLAYER_B_FIVE.length; i++) {
            Position thisPosition = board.getPositionWithName(START_POS_PLAYER_B_FIVE[i]);
            if (thisPosition != null) {
                Stone newStone;
                if (!isTorus) {
                    newStone = new Stone(playerBPositions[i], playerB, thisPosition);
                } else {
                    newStone = new TorusStone(playerBPositions[i], playerB, thisPosition);
                }
                board.setStone(newStone);
                playerB.addStone(newStone);
            }
        }
    }


    public static void setSevenBoard(Board board, Player playerA, Player playerB, int[] playerAPositions,
                                     int[] playerBPositions, boolean isTorus) {
        for (int i = 0; i < START_POS_PLAYER_A_SEVEN.length; i++) {
            Position thisPosition = board.getPositionWithName(START_POS_PLAYER_A_SEVEN[i]);
            if (thisPosition != null) {
                Stone newStone;
                if (!isTorus) {
                    newStone = new Stone(playerAPositions[i], playerA, thisPosition);
                } else {
                    newStone = new TorusStone(playerAPositions[i], playerA, thisPosition);
                }
                board.setStone(newStone);
                playerA.addStone(newStone);
            }
        }
        for (int i = 0; i < START_POS_PLAYER_B_SEVEN.length; i++) {
            Position thisPosition = board.getPositionWithName(START_POS_PLAYER_B_SEVEN[i]);
            if (thisPosition != null) {
                Stone newStone;
                if (!isTorus) {
                    newStone = new Stone(playerBPositions[i], playerB, thisPosition);
                } else {
                    newStone = new TorusStone(playerBPositions[i], playerB, thisPosition);
                }
                board.setStone(newStone);
                playerB.addStone(newStone);
            }
        }
    }

}

