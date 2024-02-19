#include "all_your_base.h"

size_t rebase(int8_t digits[DIGITS_ARRAY_SIZE], int8_t input_base, int8_t output_base, int8_t input_length) {

    if (input_base < 2 || output_base < 2 || input_length == 0) {
        return 0;
    }

    // ---- Convert from 'input_base' to decimal

    int32_t base10 = 0;

    for (int8_t i = input_length - 1; i >= 0; i--) {
        if (digits[i] < 0 || digits[i] >= input_base) {
            return 0;
        }
        base10 += digits[i] * pow(input_base, input_length - i - 1);
    }

    if (base10 == 0) {
        return 1;
    }
    
    // ---- Convert from decimal to 'output_base'

    size_t output_length = 0;
    
    while (base10 > 0) {
        digits[output_length++] = base10 % output_base;
        base10 /= output_base;
    }

    // The array gets the digits reversed
    // here we put them on the right order.

    int8_t low = 0;
    int8_t high = output_length - 1;

    while (low < high) {
        int8_t aux = digits[low];
        digits[low] = digits[high];
        digits[high] = aux;
        low++;
        high--;
    }

    return output_length;
}
