#ifndef PYTHAGOREAN_TRIPLET_H
#define PYTHAGOREAN_TRIPLET_H

#define MAX_TRIPLETS 1000

#include <math.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>

typedef struct {

    uint16_t a;
    uint16_t b;
    uint16_t c;

} triplet_t;

typedef struct {

    uint16_t count;
    triplet_t triplets[MAX_TRIPLETS];

} triplets_t;

triplets_t* triplets_with_sum(uint16_t sum);
void free_triplets(triplets_t *triplets);

#endif
