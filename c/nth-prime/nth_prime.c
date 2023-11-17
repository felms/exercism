#include "nth_prime.h"

uint32_t nth(uint32_t n) {

    uint32_t prime = 0;
    uint32_t count = 0;

    while (count < n) {
        prime++;
        if (is_prime(prime)) {
            count++;
        }
    }

    return prime;
}


bool is_prime(uint32_t n) {

    if (n == 2 || n == 3) {
        return true;
    }

    if (n < 2 || n % 2 == 0) {
        return false;
    }

    for (uint32_t i = 3; i * i <= n; i += 2) {
        if (n % i == 0) {
            return false;
        }
    }

    return true;
}
