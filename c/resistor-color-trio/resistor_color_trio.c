#include "resistor_color_trio.h"

resistor_value_t color_code(resistor_band_t* bands) {

   resistor_value_t result;

   int value = bands[0] * 10 + bands[1];

   if (bands[2] == 0) {
      result.value = value;
      result.unit = OHMS;
   } else {
      int zeros = pow(10, bands[2]);
      value = value * zeros;

      if (value > 1000) {
         result.value = value / 1000;
         result.unit = KILOOHMS;
      } else {
         result.value = value;
         result.unit = OHMS;
      }

   }

   return result;
   
}
