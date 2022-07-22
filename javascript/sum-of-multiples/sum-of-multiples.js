export const sum = (numbers, upTo) => {

  let multiples = new Set();

  numbers.forEach(number => {
    for (let i = 1; i < upTo; i++) {
      if (i % number === 0) {
        multiples.add(i);
      }
    }
  });

  return [...multiples].reduce((acc, a) => a + acc, 0);
};
