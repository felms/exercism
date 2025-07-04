export const annotate = (input) => {
    let grid = input.map(row => row.split(''));

    return grid.map((row, r) => row.map((item, c) => 
        item === ' ' 
            ? countMines(grid, [r, c]) || ' '
            : grid[r][c]
    )).map(row => row.join(''));
};

const countMines = (grid, [r, c]) => 
    getNeighbors(grid, [r, c]).filter(([rr, cc]) => grid[rr][cc] === '*').length;

const getNeighbors = (board, [r, c]) => {
    let rows = board.length;
    let columns = board[0].length;

    return [[r - 1, c], [r + 1, c], [r, c - 1], [r, c + 1],
            [r - 1, c - 1], [r - 1, c + 1], [r + 1, c - 1], [r + 1, c + 1]]
                .filter(([row, col]) => row >= 0 && row < rows 
                            && col >= 0 && col < columns);
};
