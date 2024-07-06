export const steps = (number) => {
    if (number < 1) {
        throw new Error('Only positive numbers are allowed');
    }

    if (number == 1) {
        return 0;
    }

    number = number % 2 == 0 ? number / 2 : 3 * number + 1

    return 1 + steps(number);
};
