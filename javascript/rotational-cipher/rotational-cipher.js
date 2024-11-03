const LOWER_ALPHABET = 'abcdefghijklmnopqrstuvwxyz'; 
const UPPER_ALPHABET = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';

export const rotate = (input, key) => 
    [...input].map(letter => translateLetter(letter, key)).join('');

const translateLetter = (letter, key) => {

    if (!letter.match(/[a-zA-Z]/g)) {
        return letter;
    }

    const ALPHABET = letter.match(/[a-z]/g) ? LOWER_ALPHABET : UPPER_ALPHABET;

    return ALPHABET[(ALPHABET.indexOf(letter) + key) % 26];
};
