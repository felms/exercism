export const saddlePoints = (matrix) => {
    let points = [];

    for (let r = 0; r < matrix.length; r++) {
        for (let c = 0; c < matrix[0].length; c++) {

            let isLargestInRow = matrix[r].every(i => i <= matrix[r][c]);
            let isSmallestInColumn = matrix.every(row => row[c] >= matrix[r][c]);

            if (isLargestInRow && isSmallestInColumn) {
                points.push({row: r + 1 , column: c + 1});
            }
        }
    }

    return points;
};
