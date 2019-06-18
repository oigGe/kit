package georggross;

import edu.kit.informatik.Terminal;

public class Main {
    /**
     * @param args command line arguments
     */
    public static void main(String[] args) {

        while (true) {
            String input = Terminal.readLine();
            String inputParts[] = input.split(" ");
            if (inputParts[0].equals("matrix-multiplication")) {
                multiply(inputParts);
            } else if (inputParts[0].equals("matrix-addition")) {
                addition(inputParts);
            } else if (inputParts[0].equals("scalar-multiplication")) {
                scalar(inputParts);
            } else if (inputParts[0].equals("transposition")) {
                transposition(inputParts);
            } else if (inputParts[0].equals("main-diagonal")) {
                diagonal(inputParts);
            } else if (inputParts[0].equals("quit")) {
                break;
            }
        }

    }

//    Handles the main-diagonal command.
//    Extracts the matrix dimensions and values from input.
//    Checks if input has enough values.
//    Checks if values are of the correct type.
//    Creates int[] with values from user input
//    Calls the buildMatrix method to create int[][] from int[].
//    Calls mainDiagonal() with int[][] as parameter.
//    Prints the result.

    private static void diagonal(String[] inputParts) {
        try {
            String[] diaParts = inputParts[1].split(":");

            int n = Integer.parseInt(diaParts[0]);

            int requiredValues = n * n;

            String[] values = diaParts[1].split(",");
            if (values.length != requiredValues) {
                Terminal.printLine("Error, wrong amount of values entered");
            } else {
                int[] matrixValues = new int[requiredValues];
                for (int i = 0; i < requiredValues; i++) {
                    matrixValues[i] = Integer.parseInt(values[i]);
                }
                int[][] matrix = MatrixBuilder.buildMatrix(matrixValues, n, n);
                print(MatrixCalculator.mainDiagonal(matrix));
            }
        } catch (NumberFormatException e) {
            Terminal.printLine("Error, you need to enter integer values");
        } catch (ArrayIndexOutOfBoundsException e) {
            Terminal.printLine("Error, not the required input format for main-diagonal");
        }
    }

    //    Handles the transposition command.
//    Extracts the matrix dimensions and values from input.
//    Checks if input has enough values.
//    Checks if values are of the correct type.
//    Creates int[] with values from user input
//    Calls the buildMatrix method to create int[][] from int[].
//    Calls transposition() with int[][] as parameter.
//    Prints the result.

    private static void transposition(String[] inputParts) {
        try {
            String[] transParts = inputParts[1].split(":");

            int m = Integer.parseInt(transParts[0]);
            int n = Integer.parseInt(transParts[1]);

            int matrixSize = n * m;
            int requiredValues = matrixSize;

            String[] values = transParts[2].split(",");
            if (values.length != requiredValues) {
                Terminal.printLine("Error, wrong amount of values entered");
            } else {
                int[] matrixValues = new int[matrixSize];
                for (int i = 0; i < matrixSize; i++) {
                    matrixValues[i] = Integer.parseInt(values[i]);
                }
                int[][] matrix = MatrixBuilder.buildMatrix(matrixValues, m, n);
                print(MatrixCalculator.transposition(matrix));
            }

        } catch (NumberFormatException e) {
            Terminal.printLine("Error, you need to enter integer values");
        } catch (ArrayIndexOutOfBoundsException e) {
            Terminal.printLine("Error, not the required input format for transposition");
        }
    }


    //    Handles the scalar-multiplication command.
//    Extracts the matrix dimensions and values from input.
//    Extracts skalar from input.
//    Checks if input has enough values.
//    Checks if values are of the correct type.
//    Creates int[] with values from user input
//    Calls the buildMatrix method to create int[][] from int[].
//    Calls scalarMultiplication() with int[][] and int scalar as parameter.
//    Prints the result.
    private static void scalar(String[] inputParts) {
        try {
            String[] scalarParts = inputParts[1].split(":");

            int skalar = Integer.parseInt(scalarParts[0]);
            int m = Integer.parseInt(scalarParts[1]);
            int n = Integer.parseInt(scalarParts[2]);

            int matrixSize = n * m;
            int requiredValues = matrixSize;

            String[] values = scalarParts[3].split(",");
            if (values.length != requiredValues) {
                Terminal.printLine("Error, wrong amount of values entered");
            } else {
                int[] matrixValues = new int[matrixSize];
                for (int i = 0; i < matrixSize; i++) {
                    matrixValues[i] = Integer.parseInt(values[i]);
                }
                int[][] matrix = MatrixBuilder.buildMatrix(matrixValues, m, n);

                print(MatrixCalculator.scalarMultiplication(matrix, skalar));

            }
        } catch (NumberFormatException e) {
            Terminal.printLine("Error, you need to enter integer values");
        } catch (ArrayIndexOutOfBoundsException e) {
            Terminal.printLine("Error, not the required input format for scalar-multiplication");
        }

    }

    //    Handles the matrix-addition command.
//    Extracts the matrix dimensions and values from input.
//    Checks if input has enough values.
//    Checks if values are of the correct type.
//    Creates int[] for each matrix with values from user input
//    Calls the buildMatrix method to create an int[][] for each int[].
//    Calls addition() with both int[][] as parameter.
//    Prints the result.
    private static void addition(String[] inputParts) {
        String[] additionParts = inputParts[1].split(":");
        try {

            int m = Integer.parseInt(additionParts[0]);
            int n = Integer.parseInt(additionParts[1]);

            int matrixSize = n * m;
            int requiredValues = matrixSize * 2;
            String[] values = additionParts[2].split(",");
            if (values.length != requiredValues) {
                Terminal.printLine("Error, wrong amount of values entered");
            } else {
                int[] matrixAValues = new int[matrixSize];
                int[] matrixBValues = new int[matrixSize];

                for (int i = 0; i < matrixSize; i++) {
                    matrixAValues[i] = Integer.parseInt(values[i]);
                }
                for (int i = matrixSize; i < values.length; i++) {
                    matrixBValues[i - matrixSize] = Integer.parseInt(values[i]);
                }
                int[][] matrixA = MatrixBuilder.buildMatrix(matrixAValues, m, n);
                int[][] matrixB = MatrixBuilder.buildMatrix(matrixBValues, m, n);

                print(MatrixCalculator.addition(matrixA, matrixB));
            }

        } catch (NumberFormatException e) {
            Terminal.printLine("Error, you need to enter integer values");
        } catch (ArrayIndexOutOfBoundsException e) {
            Terminal.printLine("Error, not the required input format for matrix-addition");
        }

    }

    //    Handles the matrix-multiplication command.
//    Extracts the matrix dimensions and values from input.
//    Checks if input has enough values.
//    Checks if values are of the correct type.
//    Creates int[] for each matrix with values from user input
//    Calls the buildMatrix method to create an int[][] for each int[].
//    Calls multiply() with both int[][] as parameter.
//    Prints the result.
    private static void multiply(String[] inputParts) {
        String[] multiplicationParts = inputParts[1].split(":");

        try {

            int l = Integer.parseInt(multiplicationParts[0]);
            int m = Integer.parseInt(multiplicationParts[1]);
            int n = Integer.parseInt(multiplicationParts[2]);

            int matrixASize = l * m;
            int matrixBSize = m * n;
            int requiredValues = matrixASize + matrixBSize;

            String[] values = multiplicationParts[3].split(",");
            if (values.length != requiredValues) {
                Terminal.printLine("Error, wrong amount of values entered");
            } else {
                int[] matrixAValues = new int[matrixASize];
                int[] matrixBValues = new int[matrixBSize];


                for (int i = 0; i < matrixASize; i++) {
                    matrixAValues[i] = Integer.parseInt(values[i]);
                }
                for (int i = matrixASize; i < values.length; i++) {
                    matrixBValues[i - matrixASize] = Integer.parseInt(values[i]);
                }
                int[][] matrixA = MatrixBuilder.buildMatrix(matrixAValues, l, m);
                int[][] matrixB = MatrixBuilder.buildMatrix(matrixBValues, m, n);

                print(MatrixCalculator.multiply(matrixA, matrixB));
            }
        } catch (NumberFormatException e) {
            Terminal.printLine("Error, you need to enter integer values");
        } catch (ArrayIndexOutOfBoundsException e) {
            Terminal.printLine("Error, not the required input format for matrix-multiplication");
        }
    }


    // Overloaded method to print the results.
    // Adds "," between the values.
    // Removes last ",".
    private static void print(int[][] matrix) {
        String result = "";
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result += matrix[j][i] + ",";
            }

        }
        result = result.substring(0, result.length() - 1);
        Terminal.printLine(result);
    }

    private static void print(int[] matrix) {
        String result = "";
        for (int i = 0; i < 2; i++) {
            result += matrix[i] + ",";
        }
        result = result.substring(0, result.length() - 1);
        Terminal.printLine(result);
    }

}
