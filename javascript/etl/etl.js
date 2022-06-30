export const transform = (oldScore) => {
  let newScore = {};

  for (let item in oldScore) {
    let letterScore = item;
    let letters = oldScore[item];

    letters.forEach(letter => newScore[letter.toLowerCase()] = parseInt(letterScore));

  }

  return newScore;
};
