let scores = {
    "AEIOULNRST": 1,
    "DG": 2,
    "BCMP": 3,
    "FHVWY": 4,
    "K": 5,
    "JX": 8,
    "QZ": 10
};

const scoreLetter = (letter) => 
    Object.entries(scores)
        .find(([key, _]) => key.includes(letter))[1];

export const score = (word) => 
    [...word.toUpperCase()].reduce((acc, letter) => scoreLetter(letter) + acc, 0);

