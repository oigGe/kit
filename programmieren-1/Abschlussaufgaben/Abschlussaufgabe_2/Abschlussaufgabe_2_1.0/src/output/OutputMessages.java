package output;

public enum OutputMessages {
    OK_MESSAGE("Ok");


    private String output;

    OutputMessages(String output) {
        this.output = output;
    }

    public String getOutput() {
        return this.output;
    }

}
