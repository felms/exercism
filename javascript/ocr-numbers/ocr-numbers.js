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
  let number = grid.trim().split('\n').join('');

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
  }

};
