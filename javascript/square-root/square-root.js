export const squareRoot = (number) => {
  let root = 0;
  let found = false;

  while (!found) {
    root++;
    found = root * root === number;
  }

  return root;

};
