export const prime = (nthPrime) => {
    if (nthPrime === 0) {
        throw new Error('there is no zeroth prime');
    }

    let count = 1;
    let currentPrime = 2;

    while (count < nthPrime) {
        currentPrime++;
        if (isPrime(currentPrime)) {
            count++;
        }
    }

    return currentPrime;
};

const isPrime = (number) => {

    if (number < 2) {
        return false;
    }

    if (number === 2 || number === 3) {
        return true;
    }

    if (number % 2 === 0) {
        return false;
    }

    for (let i = 3; i * i <= number; i += 2) {
        if (number % i === 0) {
            return false;
        }
    }

    return true;
};
