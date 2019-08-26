package input;

import georggross.ui.State;
import stones.Stone;

public class InputChecker {
    //    this wont work
    public static final String START_REGEX = "start [3]";

    public static final String STONE_REGEX = "[]";

    public static final String PLACE_REGEX = "place " + STONE_REGEX + "/d" + STONE_REGEX;

    public static final String PRINT_REGEX = "print";

    public static final String MOVE_REGEX = "move " + STONE_REGEX;

    public static final String PASS_REGEX = "pass";

    public static final String QUIT_REGEX = "quit";

//    implement me!!!
    public static final String MR_X_REGEX = "";

    public static boolean isStartCommand(String input) {
        if (input.matches(START_REGEX)) {
            return getStoneFromInput(input) != null;
        }
        return false;
    }

    public static boolean isPlaceCommand(String input) {
        return input.matches(PLACE_REGEX);
    }

    public static boolean isPrintCommand(String input) {
        return input.matches(PRINT_REGEX);
    }

    public static boolean isMoveCommand(String input) {
        return input.matches(MOVE_REGEX);
    }

    public static boolean isPassCommand(String input) {
        return input.matches(PASS_REGEX);
    }

    public static boolean isQuitCommand(String input) {
        return input.matches(QUIT_REGEX);
    }


    public static Stone getStoneFromInput(String input) {
        //regex magic here
        String stoneName = "";
        return State.getInstance().getStoneWithName(stoneName);
    }

}
