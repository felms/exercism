#include "grains.h"

uint64_t square(uint8_t index) {

   if (index < 1 || index > 64) {
      return 0;
   }

   return 1L << (index - 1L);
}

uint64_t total() {

    uint64_t total = 0ull;

    for (int i = 0; i < 65; i++) {
       total += square(i);
    }
    
    return total;
}
