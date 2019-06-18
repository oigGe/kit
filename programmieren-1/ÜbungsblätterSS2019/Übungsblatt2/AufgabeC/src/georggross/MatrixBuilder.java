package georggross;

/**
 * Builds a int[][] matrix
 */
public final class MatrixBuilder {

    // Utility class. Therefore private constructor.
    private MatrixBuilder() {
    }

    /**
     * Build int[][] matrix from int[] and dimensions m,n.
     *
     * @param values int array of values for matrix.
     * @param m      matrix rows as int.
     * @param n      matrix columns as int.
     * @return int[][] with dimensions m,n containing values from int[] values.
     */
    public static int[][] buildMatrix(int[] values, int m, int n) {
        int[][] matrix = new int[n][m];
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                matrix[j][i] = values[k];
                k++;

            }
        }
        return matrix;
    }
}
