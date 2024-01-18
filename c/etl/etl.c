#include "etl.h"

#include <ctype.h>
#include <string.h>
#include <stdlib.h>

static int compare_keys(const void* lhs, const void* rhs) {
    return ((const new_map*)lhs)->key - ((const new_map*)rhs)->key; 
}

int convert(const legacy_map *input, const size_t input_len, new_map **output) {

    int output_size = 0;

    for (size_t i = 0; i < input_len; i++) {
        output_size += strlen(input[i].keys);
    }

    *output = malloc(output_size * sizeof(new_map));
    size_t output_pos = 0;


    for (size_t i = 0; i < input_len; i++) {
        legacy_map current_map = input[i];

        size_t string_size = strlen(current_map.keys);

        for (size_t j = 0; j < string_size; j++) {
            char letter = tolower(current_map.keys[j]);

            (*output)[output_pos].key = letter;
            (*output)[output_pos].value = current_map.value;

            output_pos++;
        }
    }

    qsort(*output, output_pos, sizeof(new_map), &compare_keys);

    return output_size;
}
