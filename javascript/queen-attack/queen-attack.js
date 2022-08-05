export class QueenAttack {

  constructor({
    black: [blackRow, blackColumn] = [],
    white: [whiteRow, whiteColumn] = [],
  } = {}) {
    
    if (blackRow === undefined) {
      blackRow = 0;
      blackColumn = 3;
    }

    if (whiteRow === undefined) {
      whiteRow = 7;
      whiteColumn = 3;
    }

    let blackQueen = [blackRow, blackColumn];
    let whiteQueen = [whiteRow, whiteColumn];

    this.#validateQueens(blackQueen, whiteQueen);
    
    
    this.black = blackQueen;
    this.white = whiteQueen;

    this.board = [];

    for (let i = 0; i < 8; i++) {
      let row = [];
      for (let j = 0; j < 8; j++) {
        row.push('_');
      }
      this.board.push(row);
    }

    this.board[blackRow][blackColumn] = 'B';
    this.board[whiteRow][whiteColumn] = 'W';

  }

  toString() {
    let str = '';

    this.board.forEach(row => {
      str += row.join(' ').trim();
      str += '\n';
    });

    return str.trim();
  }

  get canAttack() {

    // test rows and columns
    if (this.black[0] === this.white[0]
      || this.black[1] === this.white[1]) {
      return true;
    }

    // secondary diagonal
    if (this.black[0] + this.black[1] === this.white[0] + this.white[1]) {
      return true;
    }

    // main diagonal
    if (this.black[0] - this.black[1] === this.white[0] - this.white[1]) {
      return true;
    }

    return false;
  }

  #validateQueens (blackQueen, whiteQueen) {

    let [blackRow, blackColumn] = blackQueen;
    let [whiteRow, whiteColumn] = whiteQueen;

    if (blackRow < 0 || blackRow > 7 
      || blackColumn < 0 || blackColumn > 7 
      || whiteRow < 0 || whiteRow > 7 
      || whiteColumn < 0 || whiteColumn > 7) {
      throw new Error('Queen must be placed on the board');
    }

    if (JSON.stringify(whiteQueen) === JSON.stringify(blackQueen)) {
      throw new Error('Queens cannot share the same space');
    }
  }
}
