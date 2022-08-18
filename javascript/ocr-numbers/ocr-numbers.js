const UPPER_EMPTY = '   ';
const UPPER_UNDERSCORE = ' _ ';
const MIDDLE_PIPES = '| |';
const MIDDLE_RPIPE = '  |';
const LOWER_CUP = '|_|';
const LOWER_RPIPE = '  |';

export const convert = (grid) => {
  let matrix = grid.split('\n');

  if (matrix[0] === UPPER_UNDERSCORE && matrix[1] === MIDDLE_PIPES 
    && matrix[2] === LOWER_CUP) {
    return '0';
  } else if (matrix[0] === UPPER_EMPTY && matrix[1] === MIDDLE_RPIPE 
    && matrix[2] === LOWER_RPIPE) {
    return '1';
  }

};
