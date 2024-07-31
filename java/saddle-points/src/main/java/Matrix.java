import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Matrix {

    private List<List<Integer>> matrixValues;

    Matrix(List<List<Integer>> values) {
        this.matrixValues = new ArrayList<>();
        for (List<Integer> v : values) {
            matrixValues.add(new ArrayList<>(v));
        }
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        Set<MatrixCoordinate> set = new HashSet<>();

        for (int r = 0; r < this.matrixValues.size(); r++) {
            for (int c = 0; c < this.matrixValues.get(0).size(); c++) {
                if (isLargestInRow(r, c) && isSmallestInColumn(r, c)) {
                    set.add(new MatrixCoordinate(r + 1, c + 1));
                }
            }
        }

        return set;
    }

    private boolean isLargestInRow(int r, int c) {
        int value = this.matrixValues.get(r).get(c);

        return this.matrixValues.get(r).stream().allMatch(i -> value >= i);
    }

    private boolean isSmallestInColumn(int r, int c) {
        int value = this.matrixValues.get(r).get(c);

        return this.matrixValues.stream().allMatch(list -> list.get(c) >= value);
    }

}
