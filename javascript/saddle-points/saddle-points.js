export const saddlePoints = (matrix) => {

    let sPoints = [];

    for (let i = 0; i < matrix.length; i++) {
        for (let j = 0; j < matrix[i].length; j++) {
            if (isSaddlePoint(matrix, i, j)) {
                sPoints.push({ row: i + 1, column: j + 1 });
            }
        }
    } 

    return sPoints;

};

const isSaddlePoint = (matrix, row, column) => {
    let value = matrix[row][column];

    for (let j = 0; j < matrix[row].length; j++) {
        if (value < matrix[row][j]) {
            return false;
        }
    }

    for (let i = 0; i < matrix.length; i++) {
        if (value > matrix[i][column]) {
            return false;
        }
    }

    return true;
}
