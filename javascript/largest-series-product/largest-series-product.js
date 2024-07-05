export const largestProduct = (inputNumber, numberOfDigits) => {
    if (/\D/.test(inputNumber)) {
        throw new Error('Digits input must only contain digits');
    }

    if (numberOfDigits <= 0) {
        throw new Error('Span must be greater than zero');
    }

    if (inputNumber.length < numberOfDigits) {
        throw new Error('Span must be smaller than string length');

    }

    return [...Array(inputNumber.length - numberOfDigits + 1).keys()]
        .map(pos => product(inputNumber.slice(pos, pos + numberOfDigits)))
        .reduce((acc, current) => Math.max(acc, current));
};

const product = (inputNumber) => 
    [...inputNumber].map(Number).reduce((a, b) => a * b, 1);
