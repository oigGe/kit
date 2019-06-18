package georggross;

/**
 * Contains the required matrix operations
 */
public final class MatrixCalculator {

//    Utility class. Therefore private Constructor.
    private MatrixCalculator() {
    }

    /**
     * Calculates dimensions.
     * Creates int[][] of required dimensions.
     * Multiplies values of two int[][]
     *
     * @param matrixA contains matrixA as int[][].
     * @param matrixB matrixB as int[][].
     * @return result of multiplication as int[][]
     */
    public static int[][] multiply(int[][] matrixA, int[][] matrixB) {
        int m1 = matrixA.length;
        int n1 = matrixA[0].length;
        int n2 = matrixB[0].length;
        int[][] c = new int[m1][n2];
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n2; j++) {
                for (int k = 0; k < n1; k++) {
                    c[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return c;
    }

    /**
     * Calculates dimensions for result matrix.
     * Creates int[][] with required dimensions.
     * Adds the values of two int[][].
     *
     * @param matrixA int[][] with first matrix values.
     * @param matrixB int[][] with second matrix values.
     * @return result of matrix addition as int[][].
     */
    public static int[][] addition(int[][] matrixA, int[][] matrixB) {

        int n = matrixA[0].length;
        int m = matrixA.length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = matrixA[j][i] + matrixB[j][i];
            }
        }
        return result;
    }

    /**
     * Calculates dimensions for result matrix.
     * Creates int[][] with required dimensions.
     * Multiplies matrix with scalar.
     *
     * @param matrixA int[][] with matrix values.
     * @param skalar int with scalar.
     * @return result of scalar multiplication as int[][].
     */
    public static int[][] scalarMultiplication(int[][] matrixA, int skalar) {

        int n = matrixA[0].length;
        int m = matrixA.length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = matrixA[j][i] * skalar;
            }
        }
        return result;
    }

    /**
     * Calculates dimensions for result matrix.
     * Creates int[][] with required dimensions.
     * Transpositions the matrix.
     *
     * @param matrixA int[][] with matrix values.
     * @return int[][] with transpositioned matrix values.
     */
    public static int[][] transposition(int[][] matrixA) {

        int n = matrixA[0].length;
        int m = matrixA.length;
        int[][] result = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = matrixA[i][j];
            }
        }
        return result;
    }

    /**
     * Calculates the length of the required array and creates it.
     * Identifies the diagonal values and puts them in array.
     *
     * @param matrixA int[][] with matrix values.
     * @return int[] with diagonal values.
     */
    public static int[] mainDiagonal(int[][] matrixA) {

        int m = matrixA.length;
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j) {
                    result[i] = matrixA[i][j];
                }
            }
        }
        return result;
    }
}

