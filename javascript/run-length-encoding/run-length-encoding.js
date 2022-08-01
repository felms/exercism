export const encode = (inputString) => {
  if (inputString === '') {
    return '';
  }
  let sb = '';

  inputString += '*'; // TODO retirar essa gambiarra
  let letters = inputString.split(''); 
  let previousLetter = letters[0];
  let letterCount = 1;
  for (let i = 1; i < letters.length; i++) {
    if (letters[i] === previousLetter) {
      letterCount++;
    } else if (letterCount > 1){
      sb = sb.concat('' + letterCount + previousLetter);
      letterCount = 1;
    } else if (letterCount === 1) {
      sb = sb.concat(previousLetter);
      letterCount = 1;
    }
    previousLetter = letters[i];
  }

  return sb.toString();
};

export const decode = (inputString) => {
  if (inputString === '') {
    return '';
  }

  let sb = '';
  let letters = inputString.split('');

  while (letters.length > 0) {
    let letter = letters.shift();

    if (/\d/.test(letter)) {
      let number = '';
      number = number.concat(letter);
      while (/\d/.test(letters[0])) {
        number = number.concat(letters.shift());
      }
      letter = letters.shift();
      let n = parseInt(number);
      for (let i = 0; i < n; i++) {
        sb = sb.concat(letter);
      }
    } else {
      sb = sb.concat(letter);
    }
  }				

  return sb;
};
