#include "saddle_points.h"

#include <stdbool.h>

bool is_bigger_in_row(uint8_t number, uint8_t row, 
        uint8_t rows, uint8_t columns, uint8_t matrix[rows][columns]);

bool is_smaller_in_column(uint8_t number, uint8_t column, 
        uint8_t rows, uint8_t columns, uint8_t matrix[rows][columns]);

saddle_points_t* saddle_points(uint8_t rows, uint8_t columns, uint8_t matrix[rows][columns]) {

    uint32_t max_possible_points = rows * columns;
    saddle_point_t *points = malloc(max_possible_points * (sizeof(saddle_point_t)));
    
    uint8_t count = 0;

    for (uint8_t i = 0; i < rows; i++) {
        for (uint8_t j = 0; j < columns; j++) {
            uint8_t number = matrix[i][j];

            bool is_saddle_point = is_bigger_in_row(number, i, rows, columns, matrix)
                && is_smaller_in_column(number, j, rows, columns, matrix);

            if (is_saddle_point) {
                saddle_point_t *point = malloc(sizeof(saddle_point_t));
                point->row = i + 1;
                point->column = j + 1;
                points[count++] = *point;
            }
        }
    }


    saddle_points_t *res = malloc(sizeof(saddle_points_t));

    res->count = count;
    res->points = points;

    return res;
}

bool is_bigger_in_row(uint8_t number, uint8_t row, 
        uint8_t rows, uint8_t columns, uint8_t matrix[rows][columns]) {

    for (uint8_t col = 0; col < columns; col++) {
        if (matrix[row][col] > number) {
            return false;
        }
    }

    return true;
}

bool is_smaller_in_column(uint8_t number, uint8_t column, 
        uint8_t rows, uint8_t columns, uint8_t matrix[rows][columns]) {

    for (uint8_t row = 0; row < rows; row++) {
        if (matrix[row][column] < number) {
            return false;
        }
    }

    return true;
}

void free_saddle_points(saddle_points_t *saddle_points) {
    
    for (size_t i = 0; i < saddle_points->count; i++) {
        free(&(saddle_points->points[i]));
    }

    free(saddle_points);
}
