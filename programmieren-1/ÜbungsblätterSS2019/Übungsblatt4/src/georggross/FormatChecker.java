package georggross;

import java.util.Arrays;

public class FormatChecker {

    private static final int DICE_5 = 6;

    private static final int DICE_7 = 10;

    private static final String START_REGEX_5 = "start [1-6],[1-6],[1-6],[1-6],[1-6],[1-6];"
            + "[1-6],[1-6],[1-6],[1-6],[1-6],[1-6]";

    private static final String START_REGEX_7 = "start [1-10],[1-10],[1-10],[1-10],[1-10],[1-10];"
            + "[1-10],[1-10],[1-10],[1-10],[1-10],[1-10]";

    private static final String ROLL_REGEX_5 = "roll [1-6]";

    private static final String ROLL_REGEX_7 = "roll [1-10]";

    private static final String QUIT_REGEX = "quit";

    private static final String MOVE_REGEX_STANDARD_5 = "move [1-6],[0-4];[0-4]";

    private static final String MOVE_REGEX_STANDARD_7 = "move [1-10],[0-6];[0-6]";

    private static final String MOVE_REGEX_TORUS_5 = "move [1-6],[-]*[\\d]+;[-]*[\\d]+";

    private static final String MOVE_REGEX_TORUS_7 = "move [1-10],[-]*[\\d]+;[-]*[\\d]+";

    private static final String PRINT_CELL_5 = "print-cell [0-4];[0-4]";

    private static final String PRINT_CELL_7 = "print-cell [0-6];[0-6]";

    private static final String PRINT_CELL_TORUS = "print-cell [-]*[//d]+;[-]*[//d]+";

    private static final String PRINT = "print";

    private static final String TOKEN_REGEX = "token";

    public static boolean isPrint(String cmd) {
        return cmd.matches(PRINT);
    }

    public static boolean isToken(String cmd) {
        return cmd.matches(TOKEN_REGEX);
    }

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

    public static boolean isStart(int size, String cmd) {
        if (size == 5) {
            return isStart5(cmd);
        } else if (size == 7) {
            return isStart7(cmd);
        }
        return false;
    }

    public static boolean isQuit(String cmd) {
        return cmd.matches(QUIT_REGEX);
    }

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

    public static boolean isCorrectCommandlineArgument(String[] args) {
        boolean firstArg = args[0].equals("standard") || args[0].equals("torus");
        boolean secondArg = args[1].equals("5") || args[1].equals("7");
        boolean correctSize = args.length == 2;
        if (firstArg && secondArg && correctSize) {
            return true;
        }
        return false;
    }

    public static boolean hasAllStones(int[] stoneNumbers, int dice) {
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

    public static int[] sortIntArray(int[] array) {
        Arrays.sort(array);
        return array;
    }


}


