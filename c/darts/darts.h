#ifndef DARTS_H
#define DARTS_H

#include <math.h>
#include <stdint.h>

typedef struct {
    float x;
    float y;
} coordinate_t; 


uint8_t score(coordinate_t landing_position);

float distance_between_points(float x1, float y1, float x2, float y2);

#endif
