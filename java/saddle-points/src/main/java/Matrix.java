import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Matrix {

    private int[][] matrix;

    Matrix(List<List<Integer>> values) {
        this.matrix = new int[values.size()][];
        
        for (int i = 0; i < values.size(); i++) {
            this.matrix[i] = values.get(i).stream().mapToInt(Integer::intValue).toArray();
        }
    }

    Set<MatrixCoordinate> getSaddlePoints() {

        Set<MatrixCoordinate> settlePoints = new HashSet<>();
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                if (isSettlePoint(i, j)) {
                    settlePoints.add(new MatrixCoordinate(i + 1, j + 1));
                }
            }
        }

        return settlePoints;
    }

    private boolean isSettlePoint(int row, int column) {
        int value = this.matrix[row][column];

        for (int j = 0; j < this.matrix[row].length; j++) {
            if (value < this.matrix[row][j]) {
                return false;
            }
        }

        for (int i = 0; i < this.matrix.length; i++) {
            if (value > this.matrix[i][column]) {
                return false;
            }
        }

        return true;
    }

    
}
