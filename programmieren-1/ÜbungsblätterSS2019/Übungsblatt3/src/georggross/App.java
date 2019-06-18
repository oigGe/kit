package georggross;

import edu.kit.informatik.Terminal;

import java.util.ArrayList;

/**
 * App class handles the functions. It stores teachers, pupils, assignments and reviews.
 */
public class App {
    private static App appInstance = null;
    private ArrayList<Teacher> teachers;
    private ArrayList<Pupil> pupils;
    private Teacher selectedTeacher;
    private int assignmentCount;
    private ArrayList<Assignment> assignments;
    private ArrayList<Result> results;

    private App() {
        teachers = new ArrayList<>();
        pupils = new ArrayList<>();
        assignments = new ArrayList<>();
        results = new ArrayList<>();
        this.assignmentCount = 0;
    }

    /**
     * Creates an instance of App and returns it.
     * Makes sure only one instance can be created.
     *
     * @return - An instance of App.
     */
    public static App getInstance() {
        if (appInstance == null) {
            appInstance = new App();
        }
        return appInstance;
    }

    /**
     * Creates new teacher.
     * Checks if teacher with passed name is already existing.
     * If teacher with passed name already exists, it is selected.
     *
     * @param name - name of the teacher that should be created or selected.
     */
    public void newTeacher(String name) {
        if (!isTeacherExisting(name)) {
            Teacher newTeacher = new Teacher(name);
            addTeacherToList(newTeacher);
            selectedTeacher = newTeacher;
        } else {
            selectedTeacher = getTeacher(name);
        }
    }

    /**
     * Creates new Pupil.
     * Checks if teacher is selected.
     * Checks if correct pupil id.
     * Adds pupil to pupils.
     * Adds pupil to currently selected Teacher.pupils
     *
     * @param name - name of new pupil as String.
     * @param id   - new pupil id as int.
     */
    public void newPupil(String name, int id) {
        if (hasTeacher()) {
            if (isCorrectPupilId(id)) {
                Pupil newPupil = new Pupil(name, id, selectedTeacher);
                addPupilToList(newPupil);
                addPupilToTeacher(newPupil);
            }
        } else {
            Terminal.printError("no teacher selected.");
        }
    }


    /**
     * Creates a new assignment.
     * Adds assignment to assignments.
     * increses the assignment count by 1.
     *
     * @param text - assignment text as String.
     */
    public void newAssignment(String text) {
        assignmentCount++;
        Assignment newAssignment = new Assignment(text, assignmentCount);
        assignments.add(newAssignment);
        Terminal.printLine("assignment id(" + assignmentCount + ")");
    }

    /**
     * Submits a result from a pupil.
     * Checks if pupil with passed id exists.
     * Checks if the assignment id is valid.
     * Checks if pupil has already submitted a result.
     * If all checks are passed a new resulöt is created and added to results.
     *
     * @param assignmentId - assignment id as int.
     * @param pupilId      - pupil id as int.
     * @param text         - submitted solutions as String.
     */
    public void submit(int assignmentId, int pupilId, String text) {
        Pupil pupil = getPupilWithId(pupilId);
        if (pupil != null) {
            if (isValidAssignment(assignmentId)) {
                if (!hasResult(pupil, assignmentId)) {
                    Result newResult = new Result(pupil, assignmentId, text, pupil.getTeacher());
                    addResultToList(newResult);
                } else {
                    Terminal.printError(pupilId + " has already submitted "
                            + "a solution to assignment id(" + assignmentId + ")");
                }
            } else {
                Terminal.printError("assignment id(" + assignmentId + ") does not exist.");
            }
        } else {
            Terminal.printError("pupil id " + pupilId + " does not exist");
        }
    }

    /**
     * Creates a review of a solution.
     * Checks if pupil with passed id exists.
     * Checks if assignment with passed id exists.
     * Checks if given grade is valid.
     * Checks if solution has been submitted.
     * Prints error if check fails.
     * Prints an output of the required form.
     *
     * @param assignmentID - assignment id as int.
     * @param pupilId      - pupil id as int.
     * @param grade        - grade as int.
     * @param comment      - comment on the solution as String.
     */
    public void review(int assignmentID, int pupilId, int grade, String comment) {
        if (!isIdFree(pupilId)) {
            if (isValidAssignment(assignmentID)) {
                if (isCorrectGrade(grade)) {
                    Pupil pupil = getPupilWithId(pupilId);
                    Result reviewedResult = getResult(pupil, assignmentID);
                    if (reviewedResult != null) {
                        reviewedResult.correctAssignment(grade, comment);
                        Terminal.printLine(reviewedResult.getCorrector().getName() + " reviewed (" + pupilId
                                + "," + pupil.getName() + ") with grade " + grade);
                    } else {
                        Terminal.printError(pupilId + " has not submitted "
                                + "a solution to assignment id(" + assignmentID + ")");
                    }
                } else Terminal.printLine("Error, grade is not correct.");
            } else {
                Terminal.printLine("Error, assignment does not exist.");
            }
        } else {
            Terminal.printLine("Error, pupil does not exist.");
        }
    }

    /**
     * Creates an output according to the requirements of the list-pupils command.
     */
    public void listPupils() {
        String output = "";
        for (int i = 0; i < pupils.size(); i++) {
            output = "(" + pupils.get(i).getId() + "," + pupils.get(i).getName() + "): "
                    + pupils.get(i).getTeacher().getName();
            Terminal.printLine(output);
        }
    }

    /**
     * Lists all solutions of assignment with the passed id.
     *
     * @param assignmentId - assignment id as int.
     */
    public void listSolutions(int assignmentId) {
        for (int i = 0; i < results.size(); i++) {
            if (results.get(i).getAssignmentId() == assignmentId) {
                String output = "(" + results.get(i).getPupilId() + "," + results.get(i).getPupilName() + "): "
                        + results.get(i).getText();
                Terminal.printLine(output);
            }
        }
    }

    /**
     * Prints all results according to the requirements of the results command.
     * Checks for submitted solutions that are already corrected.
     */
    public void results() {
        for (int i = 0; i < assignments.size(); i++) {
            String output = "assignment id(" + assignments.get(i).getId() + "): " + assignments.get(i).getText();
            Terminal.printLine(output);
            for (int j = 0; j < results.size(); j++) {
                if (results.get(j).getAssignmentId() == i + 1) {
                    if (results.get(j).isCorrected()) {
                        String output2 = results.get(j).getPupilId() + ": " + results.get(j).getGrade();
                        Terminal.printLine(output2);
                    }
                }
            }
        }
    }

    /**
     * Prints a summary of all assignments according to the requirements of the summary-assignment command.
     */
    public void summaryAssignment() {
        int j = 1;
        while (j <= assignmentCount) {
            Terminal.printLine("assignment id(" + j + "): " + getReviwedNumber(j) + " / "
                    + getSubmittedCount(j));
            j++;
        }
    }

    /**
     * Prints an output accordint to the requirements of the summary-teacher command.
     */
    public void summaryTeachers() {
        String output = "";
        for (int i = 0; i < teachers.size(); i++) {
            output += teachers.get(i).getName() + ": " + teachers.get(i).getClassSize() + " pupils, "
                    + missingReviews(teachers.get(i)) + " missing review(s)";
            Terminal.printLine(output);
            output = "";
        }

    }

    /**
     * Sets the current instance of App to null.
     * returns a new instance of App.
     *
     * @return - returns new instance of App.
     */
    public App reset() {
        appInstance = null;
        return getInstance();
    }

    //    Returns the number of missing reviews of passed teacher.
    private int missingReviews(Teacher teacher) {
        int missingReviews = 0;
        for (int i = 0; i < results.size(); i++) {
            if (results.get(i).getCorrector() == teacher && !results.get(i).isCorrected()) {
                missingReviews++;
            }
        }
        return missingReviews;
    }

    //    Returns the number of solutions already reviewed of the assignment with passed id.
    private int getReviwedNumber(int assignmentId) {
        int reviewCounter = 0;
        for (int i = 0; i < results.size(); i++) {
            if (results.get(i).isCorrected() && assignmentId == results.get(i).getAssignmentId()) {
                reviewCounter++;
            }
        }
        return reviewCounter;
    }

    //    Returns the number of submitted solutions of the assignment with the passed id.
    private int getSubmittedCount(int assignmentId) {
        int submittedCount = 0;
        for (int i = 0; i < results.size(); i++) {
            if (results.get(i).getAssignmentId() == assignmentId) {
                submittedCount++;
            }
        }
        return submittedCount;
    }

    //    Adds passed Pupil to pupils in the ascending order of Pupils id.
    private void addPupilToList(Pupil pupil) {
        if (pupils.size() == 0) {
            pupils.add(pupil);
        } else {
            int currentNumber = pupil.getId();
            for (int i = 0; i < pupils.size(); i++) {
                if (pupils.get(i).getId() >= currentNumber) {
                    pupils.add(i, pupil);
                    break;
                }
                if (i == pupils.size() - 1) {
                    pupils.add(pupil);
                    break;
                }
            }
        }
    }

    //    Adds passed Result to results int the ascending order of Pupils id.
    private void addResultToList(Result result) {
        boolean isAdded = false;
        if (results.size() == 0) {
            results.add(result);
        } else {
            int currentNumber = result.getPupilId();
            for (int i = 0; i < results.size(); i++) {
                if (results.get(i).getPupilId() >= currentNumber) {
                    results.add(i, result);
                    isAdded = true;
                    break;
                }
            }
            if (!isAdded) {
                results.add(result);
            }
        }
    }

    //    Adds passed Teacher to teachers in alphabetical order.
    private void addTeacherToList(Teacher newTeacher) {
        if (teachers.size() == 0) {
            teachers.add(newTeacher);
        } else {
            for (int i = 0; i < teachers.size(); i++) {

                if (newTeacher.getName().compareToIgnoreCase(teachers.get(i).getName()) < 0) {
                    teachers.add(i, newTeacher);
                    break;

                }
                if (i == teachers.size() - 1) {
                    teachers.add(newTeacher);
                    break;
                }
            }
        }
    }

    //    Returns Pupil with passed pupil id. If no pupil is found return null.
    private Pupil getPupilWithId(int pupilId) {
        for (int i = 0; i < pupils.size(); i++) {
            if (pupils.get(i).getId() == pupilId) {
                return pupils.get(i);
            }
        }
        return null;
    }

    //    Returns Teacher with passed name. If no teacher is found return null.
    private Teacher getTeacher(String name) {
        for (int i = 0; i < name.length(); i++) {
            if (teachers.get(i).getName().equals(name)) {
                return teachers.get(i);
            }
        }
        return null;
    }

    //    Returns result of assignment with passed assignment id of the passed Pupil.
    private Result getResult(Pupil pupil, int assignmentID) {
        for (int i = 0; i < results.size(); i++) {
            if (results.get(i).getPupil() == pupil) {
                if (results.get(i).getAssignmentId() == assignmentID) {
                    return results.get(i);
                }
            }
        }
        return null;
    }

    //    Adds pupil to selectedTeacher.pupils.
    private void addPupilToTeacher(Pupil pupil) {
        selectedTeacher.addPupil(pupil);
    }

    //    Checks if passed Pupil has submitted a result for an assignment with passed id.
    private boolean hasResult(Pupil pupil, int assignmentId) {
        for (int i = 0; i < results.size(); i++) {
            if (results.get(i).getAssignmentId() == assignmentId && results.get(i).getPupil() == pupil) {
                return true;
            }
        }
        return false;
    }

    //    Checks if an passed assignment id is within the valid range of the assignments already created.
    private boolean isValidAssignment(int assignmentID) {
        if (assignmentID >= 1 && assignmentID <= assignmentCount) {
            return true;
        }
        return false;
    }

    //    Checks if a teacher is currently selected.
    private boolean hasTeacher() {
        if (selectedTeacher == null) {
            return false;
        }
        return true;
    }

    //    Checks if a passed pupil id is within the valid range or already in use.
    private boolean isCorrectPupilId(int id) {
        if (id >= 100000 && id <= 999999) {
            if (isIdFree(id)) {
                return true;
            } else {
                Terminal.printError("a pupil with id " + id + " already exists.");
            }
        } else {
            Terminal.printError("id " + id + " is out of bounds.");
        }
        return false;
    }

    //    Checks if passed pupil id is already in use.
    private boolean isIdFree(int id) {
        for (int i = 0; i < pupils.size(); i++) {
            if (pupils.get(i).getId() == id) {
                return false;
            }
        }
        return true;
    }

    //    Checks if passed teacher name is already in use.
    private boolean isTeacherExisting(String name) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    //    Checks if a passed grade is within the valid bounds.
    private boolean isCorrectGrade(int grade) {
        if (grade >= 1 && grade <= 6) {
            return true;
        }
        return false;
    }

}
