#include <stdlib.h>
#include "resistor_color.h"

int color_code(resistor_band_t band) {

   int b = band;

   return b;
}

resistor_band_t* colors() {

   resistor_band_t * bands;
   bands = malloc(sizeof(resistor_band_t) * 10);
 
   for (resistor_band_t band = BLACK; band <= WHITE; band++) {
      bands[band] = band;
   }

   return bands;
}
