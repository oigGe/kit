package georggross;

import java.util.ArrayList;

/**
 *  Represents a teacher
 */
public class Teacher {

    private String name;
    private ArrayList<Pupil> pupils;

    /**
     * Creates a new teacher.
     *
     * @param name - name of the new teacher as String.
     */
    public Teacher(String name) {
        this.name = name;
        this.pupils = new ArrayList<>();
    }

    /**
     * Adds a pupil to pupils.
     *
     * @param pupil - A pupil as class Pupil
     * @return
     */
    public void addPupil(Pupil pupil) {
        pupils.add(pupil);
    }

    /**
     * Returns name of the teacher.
     *
     * @return - name of the teacher as String
     */
    public String getName() {
        return name;
    }

    /**
     * Returns size of pupils.
     *
     * @return - size of pupils as int.
     */
    public int getClassSize() {
        return pupils.size();
    }
}

