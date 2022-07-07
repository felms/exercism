let alphabet = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'.split('');

export const rows = (letter) => {

    let list = [];
    let index = 0;
    let size = alphabet.indexOf(letter) * 2 + 1;

    let currentChar = 'A';
    while (list.length < size) {
        list.push(getLine(currentChar, size));

        if (list.length > Math.trunc(size / 2)) {
            index--;
        } else {
            index++;
        }      
        currentChar = alphabet[index];
    }

    return list;

};

const getLine = (currentChar, stringSize) => {

    let resultString = '';
    let middle = Math.trunc(stringSize / 2);
    let diff = alphabet.indexOf(currentChar);

    for (let i = 0; i < stringSize; i++) {
        if (i === middle - diff || i === middle + diff) {
            resultString += currentChar;
        } else {
            resultString += ' ';
        }
    }

    return resultString;
};
