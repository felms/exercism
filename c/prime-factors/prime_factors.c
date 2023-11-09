#include "prime_factors.h"

size_t find_factors(uint64_t n, uint64_t factors[static MAXFACTORS]) {


    uint64_t candidate = find_next_prime(1);
    size_t number_of_factors = 0;

    while (n > 1) {

        if (n % candidate == 0) {

            n = n / candidate;
            factors[number_of_factors] = candidate;
            number_of_factors++;

        } else {
            candidate = find_next_prime(candidate);
        }

    }


    return number_of_factors;
}

uint64_t find_next_prime(uint64_t number) {

    do {
        number++;
    } while (!is_prime(number));

    return number;

}

bool is_prime(uint64_t number) {
    
    if (number == 2 || number == 3) {
        return true;
    }

    if (number < 2 || number % 2 == 0) {
        return false;
    }

    for (size_t i = 3; i * i <= number; i += 2) {
 
        if (number % i == 0) {
            return false;
        }
    }

    return true;
}
