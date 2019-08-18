package output;

public enum ErrorMessage {
    STONE_NOT_IN_HAND_ERROR("Error, stone not in hand."),
    SURROUNDING_OPPONENT_ERROR_MESSAGE("Error, position adjoins opponent's stone."),
    NO_SURROUNDING_STONE_ERROR_MESSAGE("Error, no surrounding stone."),
    POSITION_NOT_EMPTY_ERROR_MESSAGE("Error, position is occupied."),
    NOT_A_VALID_MOVE_OPTION_ERROR("Error, not a valid move option."),
    CONNECTION_BREAK_ERROR("Error, move would break connection."),
    IS_BLOCKED_BY_AGENT_ERROR("Error, stone is blocked by agent."),
    SLIDE_IS_BLOCKED_ERROR("Error, stone can not slide to this position.");


    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
