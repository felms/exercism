import java.util.Arrays;

class Matrix {

    private int[][] matrix;
    private int rows;
    private int columns;

    Matrix(String matrixAsString) {
        String[] lines = matrixAsString.split("\\n");
        rows = lines.length;
        matrix = new int[rows][];
        for (int i = 0; i < lines.length; i++) {
            String[] row = lines[i].split("\\s+");
            columns = row.length;
            matrix[i] = Arrays.stream(row).mapToInt(Integer::parseInt).toArray();
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
