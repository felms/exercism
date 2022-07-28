export const flatten = (inputArray) => {
  return flat(inputArray);
};

const flat = (input) => {

  let arr = [];

  if (!Array.isArray(input)) {
    if (input || input === 0) {
      arr.push(input);
    }
    return arr;
  }
  
  if (input.length === 0) {
    return arr;
  }

  input.forEach(item => {
    let a0 = flat(item);
    arr = [...arr, ...a0];
  });

  return arr;
}
