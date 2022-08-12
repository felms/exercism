export const annotate = (input) => {
  if (input.length === 0) {
    return input;
  }


  let rows = input.length;
  let columns = rows > 0 ? input[0].length : 0;

  let board = [];

  input.forEach(row => board.push(row.split('')));

  return withNumbers(board, rows, columns);
};

const withNumbers = (board, rows, columns) => {

  if(board.length === 0) {
    return [];
  }

  let numberedBoard = [];
  const MINE = '*';

  for (let i = 0; i < rows; i++) {
    let sb = '';
    let r = board[i];
    for (let j = 0; j < columns; j++) {
      if (r[j] === MINE) {
        sb = sb.concat(MINE);
      } else {
        let sum = 0;
        if (j == 0 && j + 1 < columns && r[j + 1] === MINE) {
          sum++;
        }

        if (j > 0 && r[j - 1] === MINE) {
          sum++;
        }

        if (j > 0 && j < columns - 1 && r[j + 1] === MINE) {
          sum++;
        }

        if (i + 1 < rows) {
          let r1 = board[i + 1];
          if (r1[j] === MINE) {
            sum++;
          }

          if (j < columns - 1 && r1[j + 1] === MINE) {
            sum++;
          }

          if (j > 0 && r1[j - 1] === MINE) {
            sum++;
          }

        }

        if (i > 0) {
          let r0 = board[i - 1];
          if (r0[j] === MINE) {
            sum++;
          }

          if (j < columns - 1 && r0[j + 1] === MINE) {
            sum++;
          }

          if (j > 0 && r0[j - 1] === MINE) {
            sum++;
          }
        }

        sb = sb.concat(sum === 0 ? ' ' : sum.toString());
      }

    }

    numberedBoard.push(sb);
  }

  return numberedBoard;

};
