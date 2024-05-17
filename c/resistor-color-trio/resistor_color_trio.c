#include "resistor_color_trio.h"

#include <stdint.h>

#define GIGA 1000000000
#define MEGA 1000000
#define KILO 1000

resistor_value_t color_code(resistor_band_t* bands) {

    resistor_value_t result;

    uint64_t value = bands[0] * 10 + bands[1];

    uint64_t zeros = pow(10, bands[2]);
    value = value * zeros;

    if (value > GIGA){
        result.value = value / GIGA;
        result.unit = GIGAOHMS;
    } else if (value > MEGA) {
        result.value = value / MEGA;
        result.unit = MEGAOHMS;
    } else if (value > KILO) {
        result.value = value / KILO;
        result.unit = KILOOHMS;
    } else {
        result.value = value;
        result.unit = OHMS;
    }

    return result;

}
