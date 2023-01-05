#include "sieve.h"

uint32_t sieve(uint32_t limit, uint32_t *primes, size_t max_primes) {

    bool is_prime[max_primes];
    is_prime[0] = false;
    is_prime[1] = false;

    for (uint32_t i = 2; i <= max_primes; i++) {
        is_prime[i] = true;
    }

    for (uint32_t i = 2; i < sqrt(limit); i++) {
        if(is_prime[i]) {
            for (uint32_t j = i * i; j <= limit; j += i) {
                is_prime[j] = false;
            }
        }
    }

    uint32_t number_of_primes = 0;
    for (uint32_t i = 0; i <= limit; i++) {
        if (is_prime[i]) {
            primes[number_of_primes++] = i;
        }
    }

    return number_of_primes;

}