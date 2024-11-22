export class QueenAttack {
    constructor({
        black: [blackRow, blackColumn] = [0, 3],
        white: [whiteRow, whiteColumn] = [7, 3],
    } = {}) {
        if ([blackRow, blackColumn, whiteRow, whiteColumn].some(n => n < 0 || n > 7)) {
            throw new Error('Queen must be placed on the board');
        }

        if (blackRow === whiteRow && blackColumn === whiteColumn) {
            throw new Error('Queens cannot share the same space')
        }

        this.black = [blackRow, blackColumn]
        this.white = [whiteRow, whiteColumn]
    }

    toString() {
        let board = [...Array(8)].map(() => Array(8).fill('_'));
        board[this.black[0]][this.black[1]] = 'B';
        board[this.white[0]][this.white[1]] = 'W';

        return board.map(row => row.join(' ')).join('\n');

    }

    get canAttack() {
        return this.black[0] === this.white[0] || this.black[1] === this.white[1]
            || this.black[0] + this.black[1] === this.white[0] + this.white[1]
            || Math.abs(this.black[0] - this.black[1]) === Math.abs(this.white[0] - this.white[1]);
    }
}
