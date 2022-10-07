#include "hamming.h"

#include <string.h>

int compute(const char *lhs, const char *rhs) {

   int distance = 0;
   int size = strlen(lhs);
   int r_size = strlen(rhs);
   
   if (size != r_size) {
      return -1;
   }

   for (int i = 0; i < size; i++) {
      if (lhs[i] != rhs[i]) {
         distance++;
      }
   }

   return distance;
}
