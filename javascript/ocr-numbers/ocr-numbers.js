const UPPER_EMPTY = '   ';
const UPPER_UNDERSCORE = ' _ ';

const MIDDLE_PIPES = '| |';
const MIDDLE_R_PIPE = '  |';
const MIDDLE_B_RIGHT = ' _|';
const MIDDLE_CUP = '|_|';
const MIDDLE_L_BOTTOM = '|_ ';

const LOWER_CUP = '|_|';
const LOWER_R_PIPE = '  |';
const LOWER_L_BOTTOM = '|_ ';
const LOWER_B_RIGHT = ' _|';

export const convert = (grid) => {
  let matrix = grid.split('\n');

  // Primeira linha só é vazia nos números 1 e 4
  if (matrix[0] === UPPER_EMPTY) { 
    if (matrix[1] === MIDDLE_CUP) {  
      return '4';
    }

    return '1';
  }
  
  // Todos os outros casos terão o mesmo 
  // padrão na primeira linha.
  // A diferença vem nas próximas

  if (matrix[1] === MIDDLE_R_PIPE) {
    return '7';
  }

  if (matrix[1] === MIDDLE_PIPES) {
    return '0';
  }

  // 2 ou 3
  if (matrix[1] === MIDDLE_B_RIGHT) {
    if (matrix[2] === LOWER_L_BOTTOM) {
      return '2';
    }

    return '3';
  }

  // 5 ou 6
  if (matrix[1] === MIDDLE_L_BOTTOM) {
    if (matrix[2] === LOWER_B_RIGHT) {
      return '5';
    }

    return '6';
  }

  // 8 ou 9
  if (matrix[1] === MIDDLE_CUP) {
    if (matrix[2] === LOWER_CUP) {
      return '8';
    }

    return '9';
  }
};
