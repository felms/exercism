//
// This is only a SKELETON file for the 'Anagram' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

export const findAnagrams = (word, candidates) => {

  let w = word.toLowerCase().split("").sort().join("");

  return candidates.filter(candidate => candidate.toLowerCase() !== word.toLowerCase())
                   .filter(candidate => candidate.toLowerCase().split("").sort().join("") === w);
};
