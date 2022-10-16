export class Board {

  #board;
  #rows;
  #columns;

  constructor(board) {
    this.#board = board.map(line => line.trim().split(/\s/));
    this.#rows = this.#board.length;
    this.#columns = this.#board[0].length;

  }

  winner() {

    // empty board
    let b = this.#board.join('');
    if (!b.includes('X') && !b.includes('O')) {
      return '';
    }

    // single player on a 1 x 1 board
    if (this.#rows === 1 && this.#columns === 1) {
      return this.#board[0][0];
    }

    return this.oWins() ? 'O' : this.xWins() ? 'X' : '';

  }

  oWins() {

    // tests if there's an 'O' in all rows otherwise the 'O' player can't win
    let presentInAllRows = this.#board.every(line => line.findIndex(player => player === 'O') >= 0);

    if (!presentInAllRows) {
      return false;
    }


    let index = this.#board[0].findIndex(player => player === 'O');
    let r = 0;
    let finished = false;

    while (!finished) {

      if (r === this.#rows - 1) {
        return true;
      }

      if (this.#board[r + 1][index] === 'O') {
        r++;
      } else if (this.#board[r][index + 1] === 'O') {
        index++;
      } else if (index > 0 && this.#board[r + 1][index - 1] === 'O') {
        r++;
        index--;
      } else {
        return false;
      }
    }

    return false;
  }

  xWins() {

    // tests if there's an 'X' player in all columns otherwise the 'X' player can't win
    for (let column = 0; column < this.#columns; column++) {

      let countXs = 0;
      for (let row = 0; row < this.#rows; row++) {
        if (this.#board[row][column] === 'X') {
          countXs++;
        }
      }

      if (countXs === 0) {
        return false;
      }
    }


    let index = 0;
    for (let row = 0; row < this.#rows; row++) {
      if (this.#board[row][0] === 'X') {
        index = row;
        break;
      }
    }
    

    let c = 0;
    let finished = false;

    while (!finished) {

      this.#board[index][c] = '*';

      if (c === this.#columns - 1) {
        return true;
      }

      if (this.#board[index][c + 1] === 'X') {
        c++;
      } else if (index > 0 && this.#board[index - 1][c] === 'X') {
        index--;
      } else if (index < this.#rows - 1 && this.#board[index + 1][c] === 'X') {
        index++;
      } else if (index < this.#rows - 1 && (index !== c) && this.#board[index + 1][c + 1] === 'X') {
        c++;
        index++;
      } else if (index > 0 && this.#board[index - 1][c + 1] === 'X') {
        c++;
        index--;
      } else if (c > 0 && this.#board[index][c - 1] === 'X') {
        c--;
      } else {
        return false;
      }
    }

    return false;
  }
}
