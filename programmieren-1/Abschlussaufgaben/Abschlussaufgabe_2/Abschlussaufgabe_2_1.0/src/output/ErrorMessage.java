package output;

public enum ErrorMessage {
    STONE_NOT_IN_HAND_ERROR("Error, stone not in hand."),
    SURROUNDING_OPPONENT_ERROR_MESSAGE("Error, position adjoins opponent's stone."),
    NO_SURROUNDING_STONE_ERROR_MESSAGE("Error, no surrounding stone."),
    POSITION_NOT_EMPTY_ERROR_MESSAGE("Error, position is occupied."),
    NOT_A_VALID_MOVE_OPTION_ERROR("Error, not a valid move option."),
    CONNECTION_BREAK_ERROR("Error, move would break connection."),
    IS_BLOCKED_BY_AGENT_ERROR("Error, stone is blocked by agent."),
    SLIDE_IS_BLOCKED_ERROR("Error, stone can not slide to this position."),
    HAS_VISITED_BEFORE_ERROR("Error, position was visited before."),
    NOT_IN_TOUCH_ERROR("Error, position is not in touch with previous stone."),
    INVALID_STONE_ERROR("Error, invalid stone input."),
    INVALID_POSITION_ERROR("Error, invalid position input."),
    HAS_TO_PLAY_MR_X_ERROR("Error, MR X needs to be played."),
    INVALID_AMOUNT_OF_POSITIONS_ERROR("Error, invalid amount of positions.");


    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
