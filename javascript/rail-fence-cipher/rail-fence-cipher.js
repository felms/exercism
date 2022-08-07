export const encode = (plainText, numberOfLists) => {

  let railFence = [];
  for (let i = 0; i < numberOfLists; i++) {
    railFence.push([]);
  }


  let letters = plainText.split('');
  let step = 1;
  let pos = 0;

  for (let i = 0; i < letters.length; i++){

    railFence[pos].push(letters[i]);
    pos += step;

    if(pos === numberOfLists - 1 || pos === 0) {
      step *= -1;
    }

  }

  let sb = '';
  for (let i = 0; i < numberOfLists; i++){
    sb = sb.concat(railFence[i].join(''));
  }

  return sb;
};

export const decode = (inputString, numberOfLists) => {

  let input = inputString;

  let railFence = [];
  for (let i = 0; i < numberOfLists; i++) {

    let rail = [];

    for (let j = 0; j < inputString.length; j++){
      rail.push('_');
    }
    railFence.push(rail);

  }


  let step = 1;
  let pos = 0;
  let row = 0;
  let column = 0;

  while (pos < input.length) {

    railFence[row][column] = '*';
    column++;
    pos++;

    if (row === numberOfLists - 1) {
      step = -1;
    } else if (row == 0) {
      step = 1;
    }

    row += step;
  }

  for (let i = 0; i < numberOfLists; i++) {

    let rail = railFence[i];
    for (let j = 0; j < rail.length; j++) {
      if (rail[j] === '*') {
        let letter = input.substring(0, 1);
        input = input.substring(1);
        rail[j] = letter;
      }
    }
  }


  step = 1;
  pos = 0;
  row = 0;
  column = 0;
  let sb = '';

  while (pos < inputString.length) {

    let s = railFence[row][column];
    sb = sb.concat(s);
    column++;
    pos++;

    if (row === numberOfLists - 1) {
      step = -1;
    } else if (row === 0) {
      step = 1;
    }

    row += step;
  }

  return sb;
};
