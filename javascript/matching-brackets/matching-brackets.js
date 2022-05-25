export const isPaired = (expression) => {
  let brackets = [];

  for (let c of expression) {
    if (c === '[' || c === '{' || c === '(') {
      brackets.push(c);
    } else if (c === ']' 
          && brackets[brackets.length - 1] === '[') {
      brackets.pop();

    } else if (c === '}' 
          && brackets[brackets.length - 1] === '{') {
      brackets.pop();
    } else if (c === ')' 
          && brackets[brackets.length - 1] === '(') {
      brackets.pop();
    } else if (c === ']' || c === '}' || c === ')') {
      brackets.push(c);
    }

  } 
  

  return brackets.length === 0;
};
