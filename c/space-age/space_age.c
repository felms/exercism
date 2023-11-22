#include "space_age.h"

static const int EARTH_YEAR_IN_SECONDS = 31557600;

static const float ORBITAL_PERIODS[] = {
    0.2408467, 
    0.61519726, 
    1.0, 
    1.8808158, 
    11.862615, 
    29.447498, 
    84.016846, 
    164.79132
};

float age(planet_t planet, int64_t seconds) {

    if (planet < 0 || planet > 7) {
        return -1.0;
    }

    float age_on_planet = seconds / EARTH_YEAR_IN_SECONDS;

    return age_on_planet / ORBITAL_PERIODS[planet]; 

}

