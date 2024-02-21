#include "eliuds_eggs.h"

unsigned int egg_count(unsigned int number) {

    unsigned int count = 0;

    while (number > 0) {
        count += (number & 1);
        number = number >> 1;
    }

    return count;
}
