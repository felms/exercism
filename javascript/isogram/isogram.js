export const isIsogram = (word) => {
    let cleanedWord = word.toLowerCase().replaceAll(/[^a-z]/g, '');

    return new Set(cleanedWord).size === cleanedWord.length;
};
