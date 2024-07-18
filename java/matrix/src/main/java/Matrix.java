import java.util.Arrays;

class Matrix {

    private int[][] rows;

    Matrix(String matrixAsString) {
        this.rows = Arrays.stream(matrixAsString.split("\\n"))
                        .map(this::parseRow).toArray(int[][]::new);
    }

    int[] getRow(int rowNumber) {
        return this.rows[rowNumber - 1];
    }

    int[] getColumn(int columnNumber) {
        return Arrays.stream(this.rows).mapToInt(row -> row[columnNumber - 1]).toArray();
    }

    private int[] parseRow(String row) {
        return Arrays.stream(row.split("\\s+"))
                        .mapToInt(Integer::parseInt).toArray();
    }
}
