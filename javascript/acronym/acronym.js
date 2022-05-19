export const parse = (phrase) => {

  return phrase.replace(/-|_/g, " ")
                .split(/\s+/g)
                .filter(item => item)
                .map(word => word[0].toUpperCase())
                .join("");
  
};
