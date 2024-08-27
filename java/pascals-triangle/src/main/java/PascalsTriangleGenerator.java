class PascalsTriangleGenerator {

    int[][] generateTriangle(int rows) {

        if (rows == 0) {
            return new int[][]{};
        }

        int[][] res = new int[rows][];
        res[0] = new int[]{1};

        for (int i = 1; i < rows; i++) {
            res[i] = generateRow(res[i - 1]);
        }

        return res;
    }

    int[] generateRow(int[] previousRow) {

        int[] res = new int[previousRow.length + 1];
        res[res.length - 1] = 1;

        int[] row0 = new int[previousRow.length + 1];
        row0[0] = 0;

        for (int i = 0; i < previousRow.length; i++) {
            row0[i + 1] = previousRow[i];
        }

        for (int i = 0; i < res.length - 1; i++) {
            res[i] = row0[i] + row0[i + 1];
        }

        return res;
    }

}
