export const spiralMatrix = (size) => {

    if (size === 0) {
        return [];
    }

    let matrix = initMatrix(size);
    let currentNumber = 1;
    let maxNumber = size * size;
    let i = 0;
    let j = 0;
    let minColumn = 0;
    let minRow = 0;
    let maxColumn = size;
    let maxRow = size;

    while (currentNumber <= maxNumber)  {
        
        while (j < maxColumn) {
            matrix[i][j] = currentNumber;
            j++;
            currentNumber++;
        }
        i++;
        j--;

        while (i < maxRow) {
            matrix[i][j] = currentNumber;
            i++;
            currentNumber++;
        }
        i--;
        j--;

        while(j >= minColumn) {
            matrix[i][j] = currentNumber;
            j--;
            currentNumber++;
        }
        i--;
        j++;

        while (i > minRow) {
            matrix[i][j] = currentNumber;
            i--;
            currentNumber++;
        }
        i++;
        j++;

        maxColumn--;
        maxRow--;
        minColumn++;
        minRow++;
        
    }
    
    return matrix;
};

const initMatrix = (size) => {
    
    let matrix = [];

    for (let i = 0; i < size; i++) {
        let row = [];
        for (let j = 0; j < size; j++) {
            row.push(-1);
        }
        matrix.push(row);
    }
    
    return matrix;
}
