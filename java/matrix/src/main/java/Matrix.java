import java.util.Arrays;

class Matrix {

    private int[][] matrix;
    private int rows;

    Matrix(String matrixAsString) {
        String[] lines = matrixAsString.split("\\n");
        rows = lines.length;
        matrix = new int[rows][];
        for (int i = 0; i < lines.length; i++) {
            matrix[i] = Arrays.stream(lines[i].split("\\s+")).mapToInt(Integer::parseInt).toArray();

        }

    }

    int[] getRow(int rowNumber) {
        return matrix[rowNumber - 1];
    }

    int[] getColumn(int columnNumber) {
        int[] column = new int[rows];
        for (int i = 0; i < rows; i++) {
            column[i] = matrix[i][columnNumber - 1];
        }

        return column;
    }
}
