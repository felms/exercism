#include "all_your_base.h"

#include <algorithm>
#include <cmath>
#include <stdexcept>

namespace all_your_base {

vector<unsigned int> convert(unsigned int input_base, 
                             vector<unsigned int> in_digits, unsigned int output_base) {

    if (input_base < 2 || output_base < 2) {
        throw std::invalid_argument("input_base and output_base must be greater than 2");
    }

    // ---- Convert from 'input_base' to decimal

    unsigned int base10 = 0;
    int input_size = in_digits.size();

    for (int i = input_size - 1; i >= 0; i--) {
        if (in_digits[i] >= input_base) {
            throw std::invalid_argument("All digits must be between 0 an 'input_base - 1'");
        }
        base10 += in_digits[i] * pow(input_base, input_size - i - 1);
    }


    // ---- Convert from decimal to 'output_base'
    vector<unsigned int> output;

    while (base10 > 0) {
        output.push_back(base10 % output_base);
        base10 /= output_base;
    }

    reverse(output.begin(), output.end());
    return output;
}

}  // namespace all_your_base
