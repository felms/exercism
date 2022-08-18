const ZERO = '_ | ||_|';
const ONE = '|  |';
const TWO = '_  _||_';
const THREE = '_  _| _|';
const FOUR = '|_|  |';
const FIVE = '_ |_  _|';
const SIX = '_ |_ |_|';
const SEVEN = '_   |  |';
const EIGHT = '_ |_||_|';
const NINE = '_ |_| _|';

export const convert = (grid) => {

  let lines = grid.split('\n');
  let numbers = [];

  for (let column = 0; column < lines[0].length; column += 3) {
    let number = []
    for (let row = 0; row < lines.length - 1; row++) {
      number.push(lines[row].slice(column, column + 3));
    }
    numbers.push(number.join('').trim());
  }


  let result = '';
  numbers.forEach(number => result += ocrNumber(number));

  return result;

};

const ocrNumber = (number) => {
  switch(number) {
    case ZERO:
      return '0';
    case ONE:
      return '1';
    case TWO:
      return '2';
    case THREE:
      return '3';
    case FOUR:
      return '4';
    case FIVE:
      return '5';
    case SIX:
      return '6';
    case SEVEN:
      return '7';
    case EIGHT:
      return '8';
    case NINE:
      return '9';
    default:
      return '?';
  }

};
