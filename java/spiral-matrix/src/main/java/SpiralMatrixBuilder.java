import java.util.Arrays;

class SpiralMatrixBuilder {
    int[][] buildMatrixOfSize(int size) {

        int lastNumber = size * size;
        int currentNumber = 1;
        int r = 0;
        int c = 0;

        Direction direction = Direction.RIGHT;

        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(matrix[i], -1);
        }

        while (currentNumber <= lastNumber) {

            matrix[r][c] = currentNumber;
            currentNumber++;

            if(direction == Direction.RIGHT) {

                if (c == size - 1 || matrix[r][c + 1] != -1) {
                    r++;
                    direction = Direction.DOWN;
                } else {
                    c++;
                }

            } else if (direction == Direction.DOWN) {

                if (r == size - 1 || matrix[r + 1][c] != -1) {
                    c--;
                    direction = Direction.LEFT;
                } else {
                    r++;
                }

            } else if (direction == Direction.LEFT) {

                if (c == 0 || matrix[r][c - 1] != -1) {
                    r--;
                    direction = Direction.UP;
                } else {
                    c--;
                }

            } else { // direction == Direction.UP

                if (r == 0 || matrix[r - 1][c] != -1) {
                    c++;
                    direction = Direction.RIGHT;
                } else {
                    r--;
                }

            }
        }

        return matrix;
    }

    private enum Direction {
        UP, DOWN, LEFT, RIGHT;
    }
}
