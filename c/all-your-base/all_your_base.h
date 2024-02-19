#ifndef ALL_YOUR_BASE_H
#define ALL_YOUR_BASE_H

#include <math.h>
#include <stdint.h>
#include <stddef.h>

#define DIGITS_ARRAY_SIZE 64

size_t rebase(int8_t digits[DIGITS_ARRAY_SIZE], int8_t input_base, int8_t output_base, int8_t input_length);

#endif
