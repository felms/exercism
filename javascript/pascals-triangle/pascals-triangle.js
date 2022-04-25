//
// This is only a SKELETON file for the 'Pascals Triangle' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

export const rows = (numberOfRows) => {
  let matrix = [];

  for (let i = 1; i <= numberOfRows; i++) {
    matrix.push(getRow(i));
  }
  
  return matrix;
};


const getRow = (row) => {
  if (row == 1) {
    return [1];
  }
  
  let result = [1];

  for (let k = 1; k <= row - 1; k++) {
    let number = (row - k) / k;
    number *= result[result.length - 1];
    result.push(number);
  }

  return result;
}