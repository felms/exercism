export const classify = (number) => {
    if (number <= 0) {
        throw new Error('Classification is only possible for natural numbers.');
    }

    let sum = aliquotSum(number);

    return sum === number ? 'perfect'
            : sum > number ? 'abundant' : 'deficient';
};

const aliquotSum = (number) => {
    let sum = 0;

    for (let i = 1; i <= number / 2; i++) {
        if (number % i == 0) {
            sum += i;
        }
    }

    return sum;
};
