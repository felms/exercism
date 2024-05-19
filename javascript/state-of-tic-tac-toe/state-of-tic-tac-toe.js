export const gamestate = (board) => {

    checkBoard(board);

    return someoneWon(board) ? 'win' 
            : board.join('').includes(' ') ? 'ongoing' 
            : 'draw';
};

const someoneWon = (board) => {

    // Victory on rows
    if (board.includes('XXX') || board.includes('OOO')) {
        return true;
    }

    // Victory on columns
    for (let i = 0; i < 3; i++) {
        if (board[0][i] !== ' ' 
            && board [0][i] === board[1][i] && board[1][i] === board[2][i]) {
            return true;
        }
    }

    // Victory on a diagonal
    if (board[1][1] !== ' ' 
       && ((board[0][0] === board[1][1] && board[1][1] === board[2][2])
            || (board[0][2] === board[1][1] && board[1][1] === board[2][0]))) {
        return true;
    }

    return false;
};

const checkBoard = (board) => {
    let freq = {'X': 0, 'O': 0, ' ': 0};

    [...board.join('')].forEach(play => freq[play]++);

    if ((freq['X'] - freq['O']) > 1) {
        throw new Error('Wrong turn order: X went twice');
    }

    if (freq['O'] > freq['X']) {
        throw new Error('Wrong turn order: O started');
    }

    if (board.includes('XXX') && board.includes('OOO')) {
        throw new Error('Impossible board: game should have ended after the game was won');
    }
};
