const CORNER = '+';
const HORIZONTAL_SIDE = '-';
const VERTICAL_SIDE = '|';
let matrix;

export function count(diagram) {
  if (diagram.length < 2) {
    return 0;
  }

  let counter = 0;
  matrix = [];
  diagram.forEach(row => matrix.push(row.split('')));

  for (let i = 0; i < matrix.length; i++) {
    let row = matrix[i];
    for (let leftCorner = 0; leftCorner < row.length; leftCorner++) {
      if (row[leftCorner] === CORNER) {
        for (let rightCorner = leftCorner + 1; rightCorner < row.length; rightCorner++) {
          if (row[rightCorner] === CORNER) {
            counter += matchSquare(i, leftCorner, rightCorner);
          }
        }
      }
    }
  }

  return counter;
}

function matchSquare(upperRow, letfCorner, rightCorner) {
  let squareCounter = 0;

  for (let i = upperRow + 1; i < matrix.length; i++) {
    let row = matrix[i];
    if(row[letfCorner] === CORNER && row[rightCorner] === CORNER) {
      squareCounter++;
    } else if ((row[rightCorner] !== CORNER 
            && row[rightCorner] !== VERTICAL_SIDE)
            || (row[letfCorner] !== CORNER 
            && row[letfCorner] !== VERTICAL_SIDE)) {
      return squareCounter;
    }
  }

  return squareCounter;
}

