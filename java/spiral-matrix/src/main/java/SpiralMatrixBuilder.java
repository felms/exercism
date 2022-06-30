public class SpiralMatrixBuilder {
    
    public enum Direction {
        LEFT, RIGHT, UP, DOWN
    } 

    public int[][] buildMatrixOfSize(int size) {
        
        if (size == 0) {

            return new int[][]{};
        }
        
        int[][] matrix = initMatrix(size);
        
        int i = 0;
        int j = 0;
        int currentNumber = 1;
        int maxNumber = size * size;
        Direction direction = Direction.RIGHT;

        while (currentNumber <= maxNumber) {
            matrix[i][j] = currentNumber;
            currentNumber++;
            
            if (direction == Direction.RIGHT) {
                if (j == size - 1
                        || matrix[i][j + 1] != -1) {
                    direction = Direction.DOWN;
                    i++;
                } else {
                    j++;
                } 
            } else if (direction == Direction.DOWN) {
                if (i == size - 1
                        || matrix[i + 1][j] != -1) {
                    direction = Direction.LEFT;
                    j--;
                } else {
                    i++;
                }
            } else if (direction == Direction.LEFT) {
                if (j == 0
                        || matrix[i][j - 1] != -1) {
                    direction = Direction.UP;
                    i--;
                } else {
                    j--;
                }
            } else if (direction == Direction.UP) {
                if (i == 0
                        || matrix[i - 1][j] != -1) {
                    direction = Direction.RIGHT;
                    j++;
                } else {
                    i--;
                }
            }

        } 

        return matrix;
    }
    
    private int[][] initMatrix(int size) {

        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = -1;
            }
        }
        
        return matrix;

    }
}
