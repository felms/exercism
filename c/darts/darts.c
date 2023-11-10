#include "darts.h"


uint8_t score(coordinate_t landing_position) {

    float distance = distance_between_points(0, 0, landing_position.x, landing_position.y);
    return distance <= 1 ? 10
        : distance <= 5 ? 5
        : distance <= 10 ? 1
        : 0;
}

float distance_between_points(float x1, float y1, float x2, float y2) {

    return sqrt(pow((x2 - x1), 2) + pow((y2 - y1), 2));
}
