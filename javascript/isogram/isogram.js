//
// This is only a SKELETON file for the 'Isogram' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

export const isIsogram = (word) => {
  let w = word.replace(/[-\s+]/g, "").toLowerCase().split("");

  while(w.length > 0) {
    let letter = w.shift();
    if (w.indexOf(letter) >= 0) {
      return false;
    }
  }

  return true;

};
