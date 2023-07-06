#include "pascals_triangle.h"

#include <stdlib.h>

#define MIN_SIZE(rows) ((rows) > 0 ? (rows) : 1)

void free_triangle(uint8_t **triangle, size_t rows) {
    
    for (size_t i = 0; i < MIN_SIZE(rows); i++) {
        free(triangle[i]);
    }

    free(triangle);
}

uint8_t **create_triangle(size_t rows) {

    uint8_t **triangle = calloc(MIN_SIZE(rows), sizeof(uint8_t*));

    if (rows == 0) {
        triangle[0] = calloc(1, sizeof(uint8_t*));
        return triangle;
    }

    for (size_t row = 0; row < MIN_SIZE(rows); row++) {
        triangle[row] = create_row(row, rows);
    }
    
    return triangle;
}

uint8_t *create_row(size_t row, size_t num_of_rows) {

    uint8_t *created_row = calloc(MIN_SIZE(num_of_rows), sizeof(uint8_t*));

    for (size_t k = 0; k <= row; k++) {
        created_row[k] = compute_element(row, k);
    }

    return created_row;
}

uint8_t compute_element(size_t n, size_t k) {

    if (k == 0) {
        return 1;
    }

    return compute_element(n, k - 1) * (n + 1 - k) / k;
}
