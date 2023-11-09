#ifndef PRIME_FACTORS_H
#define PRIME_FACTORS_H

#include <stdint.h>
#include <stddef.h>
#include <stdbool.h>
#include <stdio.h>

#define MAXFACTORS 10

size_t find_factors(uint64_t n, uint64_t factors[static MAXFACTORS]);
uint64_t find_next_prime(uint64_t number);
bool is_prime(uint64_t number);

#endif
