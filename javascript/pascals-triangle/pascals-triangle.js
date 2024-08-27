export const rows = (numberOfRows) => {

    if (numberOfRows === 0) {
        return [];
    }

    if (numberOfRows === 1) {
        return [[1]];
    }

    let r = rows(numberOfRows - 1);
    r.push(generateRow(r[r.length - 1]));

    return r;

};

const generateRow = (previousRow) => {

    let arr0 = [0, ...previousRow];
    let arr1 = [...previousRow, 0];

    return [...Array(previousRow.length + 1).keys()]
            .map((i) => arr0[i] + arr1[i]);
};
