let lowerCaseAlphabet = 'abcdefghijklmnopqrstuvwxyz'.split('');
let upperCaseAlphabet = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'.split('');

export const rotate = (word, key) => {

    return word.split('').map(letter => rotateBy(letter, key)).join('');
};

const rotateBy = (letter, key) => {

    if (!(/[a-zA-Z]/.test(letter))) {
        return letter;
    }

    if (!isUpperCase(letter)) {
        let letterPos = lowerCaseAlphabet.indexOf(letter);
        let rot = (key + letterPos) % 26;
        return lowerCaseAlphabet[rot];
    } else {
        let letterPos = upperCaseAlphabet.indexOf(letter);
        let rot = (key + letterPos) % 26;
        return upperCaseAlphabet[rot];
    }

}

const isUpperCase = (letter) => {

    return letter === letter.toUpperCase();
}
