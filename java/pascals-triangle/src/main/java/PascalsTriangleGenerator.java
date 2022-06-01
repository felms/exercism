public class PascalsTriangleGenerator{

    private int[][] matrix;

    public PascalsTriangleGenerator() {
        
    }

    public int[][] generateTriangle(int rows) {

        if (rows == 0) {
            return new int[][]{};
        }

        if (rows == 1) {
            return new int [][] {{1}};
        }

        this.matrix = new int[rows][rows];
        this.matrix[0] = new int[]{1};

        for (int i = 2; i <= rows; i++) {
            this.matrix[i - 1] = getRow(i);
        } 

        return this.matrix;
    }

    private int[] getRow(int rowNumber) {

        int[] row = new int[rowNumber];
        row[0] = 1;

        for (int k = 1; k < rowNumber; k++) {
            double number = (double)(rowNumber - k) / (double) k;
            number *= row[k - 1];
            row[k] = (int)number;
        }

        return row;
    }

}