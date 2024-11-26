export const isArmstrongNumber = (number) => {
    let digits = Math.trunc(Math.log10(number)) + 1;

    let n = number;
    let sum = 0;

    while (n > 0) {
        let currentDigit = n % 10;
        sum += Math.pow(currentDigit, digits);
        n = Math.trunc(n / 10);
    }

    return sum === number;
};
