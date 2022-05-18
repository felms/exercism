//
// This is only a SKELETON file for the 'Anagram' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

export const findAnagrams = (word, candidates) => {
  let anagrams = [];

  candidates.forEach((str) => {
    let w = word.toLowerCase();
    let str0 = str.toLowerCase();

    if (str0.length === w.length && str0 !== w) {
      w = w.split("").sort();
      str0 = str0.split("").sort();

      if (w.every(letter => str0.indexOf(letter) === w.indexOf(letter))) {
        anagrams.push(str);
      }

    }
  });

  return anagrams;
};
