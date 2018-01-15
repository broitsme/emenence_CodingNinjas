package matrix;

public class Matrix {
    public static long[][] pow_matrix(long[][] matrix, long power) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix.length != matrix[i].length) {
                throw new NotSquareMatrix(matrix);
            }
        }
        return pow_matrixHelp(matrix, power);
    }

    private static long[][] pow_matrixHelp(long[][] matrix, long power) {
        if (power == 0) {
            return getIdentityMatrix(matrix.length);
        }
        long[][] newMatrix = pow_matrixHelp(matrix, power / 2);
        if (power % 2 == 0) {
            return multiply_matrices(newMatrix, newMatrix);
        } else {
            return multiply_matrices(multiply_matrices(newMatrix, newMatrix), matrix);
        }
    }

    public static long[][] getIdentityMatrix(int length) {
        long[][] matrix = new long[length][length];
        for (int i = 0; i < length; i++) {
            matrix[i][i] = 1;
        }
        return matrix;
    }

    public static long[][] multiply_matrices(long[][] matrix1, long[][] matrix2) {
        if (matrix1[0].length != matrix2.length) {
            throw new UnequalColoumnAndRow(matrix1, matrix2);
        }
        return multiply_matricesHelp(matrix1, matrix2);
    }

    private static long[][] multiply_matricesHelp(long[][] matrix1, long[][] matrix2) {
        long[][] matrix = new long[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    matrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return matrix;
    }
}