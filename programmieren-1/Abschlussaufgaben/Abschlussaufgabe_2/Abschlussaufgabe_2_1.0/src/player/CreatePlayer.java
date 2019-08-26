package player;

import stones.*;

import java.util.ArrayList;

public enum CreatePlayer {
    ULTRAVIOLETT("Ultraviolet", "V"),
    INFRARED("Infrared", "R");

    private final String MISTER_X_STRING = "X1";
    private final String AGENT_1_STRING = "A1";
    private final String AGENT_2_STRING = "A2";
    private final String SPY_1_STRING = "S1";
    private final String SPY_2_STRING = "S2";
    private final String INVESTIGATOR_1_STRING = "E1";
    private final String INVESTIGATOR_2_STRING = "E2";
    private final String INVESTIGATOR_3_STRING = "E3";
    private final String INFORMANT_1_STRING = "I1";
    private final String INFORMANT_2_STRING = "I2";
    private final String INFORMANT_3_STRING = "I3";

    private String playerName;
    private String colorId;
    private Player player;
    private ArrayList<Stone> hand;
    private String[] stoneNames;

    CreatePlayer(String playerName, String colorId) {
        this.playerName = playerName;
        this.colorId = colorId;
        this.stoneNames = new String[]{MISTER_X_STRING + colorId,
                AGENT_1_STRING + colorId,
                AGENT_2_STRING + colorId,
                SPY_1_STRING + colorId,
                SPY_2_STRING + colorId,
                INVESTIGATOR_1_STRING + colorId,
                INVESTIGATOR_2_STRING + colorId,
                INVESTIGATOR_3_STRING + colorId,
                INFORMANT_1_STRING + colorId,
                INFORMANT_2_STRING + colorId,
                INFORMANT_3_STRING + colorId
        };
        this.player = new Player(playerName, colorId, stoneNames);
        initHand();
        player.setHand(hand);

    }

    private void initHand() {
        hand.add(new MisterX(MISTER_X_STRING + colorId, player));
        hand.add(new Agent(AGENT_1_STRING + colorId, player));
        hand.add(new Agent(AGENT_2_STRING + colorId, player));
        hand.add(new Spy(SPY_1_STRING + colorId, player));
        hand.add(new Spy(SPY_2_STRING + colorId, player));
        hand.add(new Investigator(INVESTIGATOR_1_STRING + colorId, player));
        hand.add(new Investigator(INVESTIGATOR_2_STRING + colorId, player));
        hand.add(new Investigator(INVESTIGATOR_3_STRING + colorId, player));
        hand.add(new Informant(INFORMANT_1_STRING + colorId, player));
        hand.add(new Informant(INFORMANT_2_STRING + colorId, player));
        hand.add(new Informant(INFORMANT_3_STRING + colorId, player));
    }

    public Player getPlayer() {
        return player;
    }
}
