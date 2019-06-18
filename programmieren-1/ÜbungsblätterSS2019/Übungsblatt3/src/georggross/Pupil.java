package georggross;

/**
 * Represents a pupil.
 */
public class Pupil
{
    private String name;
    private int id;
    private Teacher teacher;

    /**
     * Creates a new pupil.
     *
     * @param name - pupil name as String.
     * @param id - pupil id as int.
     * @param teacher - pupil's teacher of class Teacher.
     */
    public Pupil(String name, int id, Teacher teacher) {
        this.name = name;
        this.id = id;
        this.teacher = teacher;
    }

    /**
     * Returns pupil's name.
     *
     * @return - pupil's name as String.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns pupil's id.
     *
     * @return - pupil's id as int.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns pupil's teacher.
     *
     * @return - pupil's teacher of class Teacher.
     */
    public Teacher getTeacher() {
        return teacher;
    }
}
