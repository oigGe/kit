package georggross;

/**
 * Represents a result
 */
public class Result {
    private Pupil pupil;
    private int assignmentId;
    private String text;
    private int grade;
    private Teacher corrector;
    private boolean isCorrected;
    private String comment;

    /**
     * Creates a new result.
     *
     * @param pupil - pupil that submitted result as object Pupil.
     * @param assignmentId - id of the assignment the result was submitted for as int.
     * @param text - the solution submitted by the student as String.
     * @param corrector - the pupil's teacher of class Teacher.
     */
    public Result(Pupil pupil, int assignmentId, String text, Teacher corrector) {
        this.pupil = pupil;
        this.assignmentId = assignmentId;
        this.text = text;
        this.isCorrected = false;
        this.corrector = corrector;
    }


    /**
     * Corrects the assignment adding a grade and a comment by pupil's teacher.
     * Sets isCorrected to true.
     *
     * @param grade - grade submitted by the teacher as int.
     * @param comment - comment submitted by teacher as String.
     */
    public void correctAssignment( int grade, String comment) {
        this.grade = grade;
        this.comment = comment;
        this.isCorrected = true;
    }

    /**
     * Returns grade.
     *
     * @return - grade as int.
     */
    public int getGrade() {
        return grade;
    }

    /**
     * Returns solution submitted by pupil.
     *
     * @return - solution as String
     */
    public String getText() {
        return text;
    }

    /**
     * Returns pupil that submitted this solution.
     *
     * @return - pupil of class Pupil.
     */
    public Pupil getPupil() {
        return pupil;
    }

    /**
     * Returns name of pupil who submitted this solution.
     *
     * @return -  pupil's name as Sting.
     */
    public String getPupilName() {
        return pupil.getName();
    }

    /**
     * Returns id of pupil who submitted this solution.
     *
     * @return - pupil's id as int.
     */
    public int getPupilId() {
        return pupil.getId();
    }

    /**
     * Returns the id of the assignment this solution was submitted for.
     *
     * @return - assignment id as int.
     */
    public int getAssignmentId() {
        return assignmentId;
    }

    /**
     * Returns a boolean indicating if the result has already been reviewed by a teacher.
     *
     * @return - boolean, if result was corrected.
     */
    public boolean isCorrected() {
        return isCorrected;
    }

    /**
     * Returns the pupil's teacher.
     *
     * @return -  pupil's teacher of class Teacher.
     */
    public Teacher getCorrector() {
        return corrector;
    }
}
