package georggross;

import java.util.Arrays;

/**
 * Checks if input is of valid format.
 *
 * @author Georg Gross
 * @version 1.0
 */
public class FormatChecker {

    private static final int DICE_5 = 6;

    private static final int DICE_7 = 10;

    private static final String START_REGEX_5 = "start [1-6],[1-6],[1-6],[1-6],[1-6],[1-6];"
            + "[1-6],[1-6],[1-6],[1-6],[1-6],[1-6]";

    private static final String START_REGEX_7 = "start ([\\d]+,){9}\\d+;([\\d]+,){9}\\d+";

    private static final String ROLL_REGEX_5 = "roll [1-6]";

    private static final String ROLL_REGEX_7 = "roll [\\d]+";

    private static final String QUIT_REGEX = "quit";

    private static final String MOVE_REGEX_STANDARD_5 = "move [1-6],[0-4];[0-4]";

    private static final String MOVE_REGEX_STANDARD_7 = "move [\\d]+,[0-6];[0-6]";

    private static final String MOVE_REGEX_TORUS_5 = "move [1-6],[-]*[\\d]+;[-]*[\\d]+";

    private static final String MOVE_REGEX_TORUS_7 = "move [\\d]+,[-]*[\\d]+;[-]*[\\d]+";

    private static final String PRINT_CELL_5 = "print-cell [0-4];[0-4]";

    private static final String PRINT_CELL_7 = "print-cell [0-6];[0-6]";

    private static final String PRINT_CELL_TORUS = "print-cell [-]*[//d]+;[-]*[//d]+";

    private static final String PRINT = "print";

    private static final String TOKEN_REGEX = "token";

    /**
     * Checks for print command
     *
     * @param cmd - User input.
     * @return - True if found command.
     */
    public static boolean isPrint(String cmd) {
        return cmd.matches(PRINT);
    }

    /**
     * Checks for token command.
     *
     * @param cmd - User input.
     * @return - True if command was found.
     */
    public static boolean isToken(String cmd) {
        return cmd.matches(TOKEN_REGEX);
    }

    /**
     * Checks for print-cell command.
     *
     * @param size    - Size of board.
     * @param cmd     - User input.
     * @param isTorus - True if game mode is torus.
     * @return - True if command was found.
     */
    public static boolean isPrintCell(int size, String cmd, boolean isTorus) {
        if (isTorus) {
            return isPrintCellTorus(cmd);
        } else if (size == 5) {
            return isPrintCell5(cmd);
        } else if (size == 7) {
            return isPrintCell7(cmd);
        }
        return false;
    }

    /**
     * Checks for move command.
     *
     * @param size    - Size of board.
     * @param isTorus - True if game mode is torus.
     * @param cmd     - User input.
     * @return - True if command was found.
     */
    public static boolean isMove(int size, boolean isTorus, String cmd) {
        if (size == 5 && !isTorus) {
            return isMoveStandard5(cmd);
        } else if (size == 5 && isTorus) {
            return isMoveTorus5(cmd);
        } else if (size == 7 && !isTorus) {
            return isMoveStandard7(cmd);
        } else if (size == 7 && isTorus) {
            return isMoveTorus7(cmd);
        }
        return false;
    }

    /**
     * Checks for start command.
     *
     * @param size - Board size.
     * @param cmd  - User input.
     * @return - True if command was found.
     */
    public static boolean isStart(int size, String cmd) {
        if (size == 5) {
            return isStart5(cmd);
        } else if (size == 7) {
            return isStart7(cmd);
        }
        return false;
    }

    /**
     * Checks for quit command.
     *
     * @param cmd - User input.
     * @return - True if command was found.
     */
    public static boolean isQuit(String cmd) {
        return cmd.matches(QUIT_REGEX);
    }

    /**
     * Checks for roll command.
     *
     * @param size - Board size.
     * @param cmd  - User input.
     * @return - True if command was found.
     */
    public static boolean isRoll(int size, String cmd) {
        if (size == 5) {
            return isRoll5(cmd);
        } else if (size == 7) {
            return isRoll7(cmd);
        }
        return false;
    }

    private static boolean isPrintCell5(String cmd) {
        return cmd.matches(PRINT_CELL_5);
    }

    private static boolean isPrintCellTorus(String cmd) {
        return cmd.matches(PRINT_CELL_TORUS);
    }

    private static boolean isPrintCell7(String cmd) {
        return cmd.matches(PRINT_CELL_7);
    }

    private static boolean isMoveStandard5(String cmd) {
        return cmd.matches(MOVE_REGEX_STANDARD_5);
    }

    private static boolean isMoveTorus5(String cmd) {
        return cmd.matches(MOVE_REGEX_TORUS_5);
    }

    private static boolean isMoveStandard7(String cmd) {
        return cmd.matches(MOVE_REGEX_STANDARD_7);
    }

    private static boolean isMoveTorus7(String cmd) {
        return cmd.matches(MOVE_REGEX_TORUS_7);
    }

    //    Checks if the stone values from start command  are correct for board size 7.
    private static boolean isStart7(String cmd) {
        if (!cmd.matches(START_REGEX_7)) {
            return false;
        }
        int[] playerAValues = InputFormat.playerStartValues(cmd, 0);
        int[] playerBValues = InputFormat.playerStartValues(cmd, 1);
        boolean crt1 = hasAllStones(playerAValues, DICE_7);
        boolean crt2 = hasAllStones(playerBValues, DICE_7);
        if (crt1 && crt2) {
            return true;
        }
        return false;
    }

    //    Checks if the stone values from start command are correct for board size 5.
    private static boolean isStart5(String cmd) {
        if (!cmd.matches(START_REGEX_5)) {
            return false;
        }
        int[] playerAValues = InputFormat.playerStartValues(cmd, 0);
        int[] playerBValues = InputFormat.playerStartValues(cmd, 1);
        boolean crt1 = hasAllStones(playerAValues, DICE_5);
        boolean crt2 = hasAllStones(playerBValues, DICE_5);
        if (crt1 && crt2) {
            return true;
        }
        return false;
    }

    private static boolean isRoll7(String cmd) {
        return cmd.matches(ROLL_REGEX_7);
    }

    private static boolean isRoll5(String cmd) {
        return cmd.matches(ROLL_REGEX_5);
    }

    /**
     * Checks if the command line arguments are valid.
     *
     * @param args - The command line arguments.
     * @return - True if args are of valid form.
     */
    public static boolean isCorrectCommandlineArgument(String[] args) {
        boolean firstArg = args[0].equals("standard") || args[0].equals("torus");
        boolean secondArg = args[1].equals("5") || args[1].equals("7");
        boolean correctSize = args.length == 2;
        if (firstArg && secondArg && correctSize) {
            return true;
        }
        return false;
    }

    //    Checks if all stone values are assigned.
    private static boolean hasAllStones(int[] stoneNumbers, int dice) {
        int[] diceNumbers = new int[dice];
        for (int i = 0; i < dice; i++) {
            diceNumbers[i] = i + 1;
        }
        sortIntArray(stoneNumbers);
        if (Arrays.equals(stoneNumbers, diceNumbers)) {
            return true;
        }
        return false;
    }

    private static int[] sortIntArray(int[] array) {
        Arrays.sort(array);
        return array;
    }

    /**
     * Checks if the roll value from roll command provided by the user is valid.
     *
     * @param app - Program state.
     * @param roll - Roll value provided by user.
     * @return - True if within bounds of dice.
     */
    public static boolean isCorrectRoll(App app, int roll) {
        if (app.getSize() == 5) {
            return (roll > 0 && roll <= 6);
        }
        return (roll > 0 && roll <= 10);
    }


}


