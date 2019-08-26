package output;

public enum OutputMessages {
    OK_MESSAGE("Ok"),
    WINNER_MESSAGE("WINNER");


    private String output;

    OutputMessages(String output) {
        this.output = output;
    }

    public String getOutput() {
        return this.output;
    }

}
