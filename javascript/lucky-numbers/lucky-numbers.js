// @ts-check

/**
 * Calculates the sum of the two input arrays.
 *
 * @param {number[]} array1
 * @param {number[]} array2
 * @returns {number} sum of the two arrays
 */
export function twoSum(array1, array2) {
  let number1 = "";
  for (let i = 0; i < array1.length; i++) {
    let i0 = array1[i];
    number1 = number1.concat(i0.toString());
  }

  let number2 = "";
  for (let j = 0; j < array2.length; j++) {
    let j0 = array2[j];
    number2 = number2.concat(j0.toString());
  }

  let result = parseInt(number1) + parseInt(number2);

  return result;
}

/**
 * Checks whether a number is a palindrome.
 *
 * @param {number} value
 * @returns {boolean}  whether the number is a palindrome or not
 */
export function luckyNumber(value) {
  let number0 = value;
  let value0 = 0;
  while(number0 > 0) {
    value0 = (value0 * 10) + (number0 % 10);
    number0 = Math.floor(number0 / 10);
  }

  console.log(value0);

  return value === value0;
}

/**
 * Determines the error message that should be shown to the user
 * for the given input value.
 *
 * @param {string|null|undefined} input
 * @returns {string} error message
 */
export function errorMessage(input) {
  if (input === undefined || input === null || input === "") {
    return "Required field";
  }

  if (!isNumeric(input) || input === "0") {
    return "Must be a number besides 0";
  }

  return "";
}


function isNumeric(str) {
  if (typeof str != "string") return false 
  return !isNaN(str) && 
         !isNaN(parseFloat(str)) 
}