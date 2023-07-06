#ifndef PASCALS_TRIANGLE_H
#define PASCALS_TRIANGLE_H

#include <stddef.h>
#include <stdint.h>

void free_triangle(uint8_t **triangle, size_t rows);
uint8_t **create_triangle(size_t rows);
uint8_t *create_row(size_t row, size_t num_of_rows);
uint8_t compute_element(size_t row, size_t num_of_rows);

#endif
