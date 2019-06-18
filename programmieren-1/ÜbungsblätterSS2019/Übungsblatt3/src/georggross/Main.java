package georggross;

import edu.kit.informatik.Terminal;

/**
 * This is the starting point of the program, including the main method
 */
public class Main {

    private static boolean isRunning = true;

    /**
     * This is the main method
     *
     * @param args -arguments as array being passed to the program upon start.
     */
    public static void main(String[] args) {
        while (isRunning) {
            String input = Terminal.readLine();
            int partCount = countSpaces(input);
            String[] inputParts = splitInput(input);
            App app = App.getInstance();

            if (partCount == 1) {
                if (input.equals("list-pupils")) {
                    app.listPupils();
                } else if (input.equals("results")) {
                    app.results();
                } else if (input.equals("summary-assignment")) {
                    app.summaryAssignment();
                } else if (input.equals("summary-teacher")) {
                    app.summaryTeachers();
                } else if (input.equals("reset")) {
                    app.reset();
                } else if (input.equals("quit")) {
                    isRunning = false;
                } else {
                    invalidInputError(input);
                }
            } else if (partCount == 2) {
                if (inputParts[0].equals("teacher")) {
                    teacher(inputParts, app);
                } else if (inputParts[0].equals("assignment")) {
                    assignment(inputParts, app);
                } else if (inputParts[0].equals("list-solutions")) {
                    listSolutions(inputParts, app);
                } else {
                    invalidInputError(input);
                }
            } else if (partCount == 3) {
                if (inputParts[0].equals("pupil")) {
                    pupil(inputParts, app);
                } else {
                    invalidInputError(input);
                }
            } else if (partCount == 4) {
                if (inputParts[0].equals("submit")) {
                    submit(inputParts, app);
                } else {
                    invalidInputError(input);
                }
            } else if (partCount == 5) {
                if (inputParts[0].equals("review")) {
                    review(inputParts, app);
                } else {
                    invalidInputError(input);
                }
            } else {
                invalidInputError(input);
            }
        }

    }

    //Handles the input in case of the review command.
//    Checks if all arguments are correct.
    private static void review(String[] inputParts, App app) {
        if (isInt(inputParts[1])) {
            if (isInt(inputParts[2])) {
                if (isInt(inputParts[3])) {
                    if (isValidText(inputParts[4])) {
                        app.review(toInt(inputParts[1]), toInt(inputParts[2]), toInt(inputParts[3]), inputParts[4]);
                    }
                }
            }
        }
    }

    //Handles the input in case of the submit command.
//    Checks if all arguments are correct.
    private static void submit(String[] inputParts, App app) {
        if (isInt(inputParts[1])) {
            if (isInt(inputParts[2])) {
                if (isValidText(inputParts[3])) {
                    app.submit(toInt(inputParts[1]), toInt(inputParts[2]), inputParts[3]);
                }
            }
        }
    }

    //Handles the input in case of the pupil command.
//    Checks if all arguments are correct.
    private static void pupil(String[] inputParts, App app) {
        if (isCorrectName(inputParts[1])) {
            if (isInt(inputParts[2])) {
                app.newPupil(inputParts[1], toInt(inputParts[2]));
            }
        }
    }

    //Handles the input in case of the list-solution command.
//    checks if all arguments are correct.
    private static void listSolutions(String[] inputParts, App app) {
        if (isInt(inputParts[1])) {
            app.listSolutions(toInt(inputParts[1]));
        }
    }

    //Handles the input in case of the assignment command.
//    Checks if all arguments are correct.
    private static void assignment(String inputParts[], App app) {
        if (isValidText(inputParts[1])) {
            app.newAssignment(inputParts[1]);
        }
    }

    //Handles the input in case of the teacher command.
//    Checks if all arguments are correct.
    private static void teacher(String[] inputParts, App app) {
        if (isCorrectName(inputParts[1])) {
            app.newTeacher(inputParts[1]);
        }
    }

    //    Counts the parts created by splitting the String input passed to the method at " ".
//        Returns that number as int.
    private static int countSpaces(String input) {
        if (input.equals("")) {
            return 0;
        } else {
            String inputParts[] = input.split(" ");
            return inputParts.length;
        }
    }

    //    Parses String to int.
    private static int toInt(String input) {
        return Integer.parseInt(input);
    }

    //    Checks if String passed to the method can be parsed to int value.
    private static boolean isInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            Terminal.printError("\"" + input + "\" is not a valid integer value");
            return false;
        }
    }

    //    Checks if String passed to the method contains anything but small letters.
//    Returns false and prints error, if it contains non letter character or capital letters.
    private static boolean isCorrectName(String name) {
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isLetter(name.charAt(i)) || !Character.isLowerCase(name.charAt(i))) {
                Terminal.printError("\"" + name + "\" is invalid name.");
                return false;
            }
        }
        return true;
    }

    //    Checks if String passed to the method has line breaks, white spaces or tabulators
    // in which case it prints an error and returns false.
    private static boolean isValidText(String input) {
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == '\t' || currentChar == 32 || currentChar == 10) {
                Terminal.printError("text: \"" + input + "\" has invalid characters");
                return false;
            }
        }
        return true;
    }

    //    Splits String passed to method using " ", and returns it.
    private static String[] splitInput(String input) {
        return input.split(" ");
    }

    //    Prints error message.
    private static void invalidInputError(String input) {
        Terminal.printError("\"" + input + "\" is invalid input");
    }
}