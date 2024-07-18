export const primeFactors = (number) => {

    let factors = [];
    let factor = 2;

    while(number > 1) {
        while(number % factor === 0) {
            number /= factor;
            factors.push(factor);
        }

        factor++;
    }

    return factors;
};
