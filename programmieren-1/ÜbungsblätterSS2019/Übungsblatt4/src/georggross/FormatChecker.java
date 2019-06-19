package georggross;

public class FormatChecker {
    private static final String START_REGEX_5 = "start [1-6],[1-6],[1-6],[1-6],[1-6],[1-6];" +
            "[1-6],[1-6],[1-6],[1-6],[1-6],[1-6]";

    private static final String START_REGEX_7 = "start [1-10],[1-10],[1-10],[1-10],[1-10],[1-10];" +
            "[1-10],[1-10],[1-10],[1-10],[1-10],[1-10]";

    private static final String ROLL_REGEX_5 = "roll [1-6]";

    private static final String ROLL_REGEX_7 = "roll [1-10]";

    private static final String QUIT_REGEX = "quit";

    private static final String MOVE_REGEX_STANDARD_5 = "move [1-6],[0-4];[0-4]";

    private static final String MOVE_REGEX_STANDARD_7 = "move [1-10],[0-6];[0-6]";

    private static final String MOVE_REGEX_TORUS_5 = "move [1-6],[-]*[\\d]+;[-]*[\\d]+";

    private static final String MOVE_REGEX_TORUS_7 = "move [1-10],[-]*[\\d]+;[-]*[\\d]+";

    public static boolean isStart5(String cmd) {
        return cmd.matches(START_REGEX_5);
    }

    public static boolean isRoll5(String cmd) {
        return cmd.matches(ROLL_REGEX_5);
    }

    public static boolean isMoveTorus5(String cmd) {
        return cmd.matches(MOVE_REGEX_TORUS_5);
    }


}
