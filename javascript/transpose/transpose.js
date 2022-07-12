export const transpose = (input) => {

    if (input.length === 0) {
        return [];
    }

    // Cria matriz com as strings
    let matrix = [];
    input.forEach(row => matrix.push(row.split('')));

    // Retorna o tamanho da maior string do array
    let sizes = matrix.map(row => row.length);
    let maxSize = Math.max(...sizes);

    // Deixa todas as linhas da matriz do mesmo tamanho
    padRows(maxSize, matrix);

    // "Transpõe" a matriz
    let transposed = [];
    for (let i = 0; i < maxSize; i++) {
        let str = getColumn(i, matrix).join('');
    //    console.log(str);
        transposed.push(getColumn(i, matrix).join(''));
    }

    // Remove o "padding" da string. Gambiarra das brabas
    for (let i = transposed.length - 1; i >= 0; i--) {
        // remove o "padding" do fim
        let str = transposed[i].replaceAll(/#+$/g, '');

        // remove o "padding" do meio da string
        str = str.replaceAll(/#/g, ' ');

        transposed[i] = str;

    }

    return transposed;

};

const getColumn = (column, matrix) =>  {

    let arr = [];
    for (let i = 0; i < matrix.length; i++) {
        arr.push(matrix[i][column]);
    }

    return arr;
}

const padRows = (maxSize, matrix) => {

    matrix.forEach(row => {
        while (row.length < maxSize) {
            row.push('#');
        }
    });
}
