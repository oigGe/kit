package georggross;

/**
 * Represents an assignment.
 */
public class Assignment {
    private String text;
    private int id;

    /**
     * Creates a new assignment.
     *
     * @param text - assignment text as String.
     * @param id - assignment id as int.
     */
    public Assignment(String text, int id) {
        this.text = text;
        this.id = id;
    }

    /**
     * Returns assignment text.
     *
     * @return - assignment text as String.
     */
    public String getText() {
        return text;
    }

    /**
     * Returns assignment id.
     *
     * @return - assignment id as int.
     */
    public int getId() {
        return id;
    }


}
