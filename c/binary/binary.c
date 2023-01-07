#include "binary.h"

int convert(const char *input) {

   int digits = strlen(input);

   int res = 0;

   for (int i = 0; i < digits; i++) {

      int digit = input[i] - '0';

      if (digit > 1) {
         return INVALID;
      }

      res += digit << (digits - 1 - i);

   }

   return res;
}
