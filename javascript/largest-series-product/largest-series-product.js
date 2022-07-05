export const largestProduct = (string, numberOfDigits) => {

    if (string.length === 0 && numberOfDigits === 0) {
        return 1;
    }

    if (string.length === 0 || numberOfDigits > string.length) {
        throw new Error('Span must be smaller than string length');
    }

    if (numberOfDigits < 0) {
        throw new Error('Span must be greater than zero'); 
    }

    if ((/[^\d]/.test(string))) {
        throw new Error('Digits input must only contain digits');
    }

    let digitsArray = string.split('').map(digit => parseInt(digit));

    let largestProduct = 0; 
    for (let i = 0; i <= digitsArray.length - numberOfDigits; i++) {
        let subArray = digitsArray.slice(i, i + numberOfDigits);
        let product = subArray.reduce((acc, curr) => acc * curr, 1);
        largestProduct = Math.max(largestProduct, product);
    }

    return largestProduct;
};
