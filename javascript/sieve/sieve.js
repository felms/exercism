export const primes = (limit) => {
    let sieve = Array(limit + 1).fill(true);

    sieve[0] = false;
    sieve[1] = false;

    for (let i = 2; i <= limit; i++) {
        if (sieve[i]) {
            for (let j = i + i; j <= limit; j += i) {
                sieve[j] = false;
            }
        }
    }

    return sieve.reduce((acc, prime, index) => prime ? [...acc, index] : acc, []);
};
