export const valid = (candidate) => {
  let input = candidate.trim();

  if (input.match(/.*[^\d\s].*/) || input.length < 2) {
      return false;
  }

  input = input.replace(/\s+/g, "");
  let numbers = input.split("").map(a => parseInt(a));

  for (let i = numbers.length - 2; i >= 0 ; i -= 2) {
      let digit = numbers[i] * 2;
      numbers[i] = digit > 9 ? digit - 9 : digit;
  }

  return numbers.reduce((a, b) => a + b, 0) % 10 === 0;
};
