#include "isogram.h"

#include <ctype.h>
#include <stdio.h>
#include <string.h>

bool is_isogram(const char phrase[]) {

   if (phrase == NULL) {
      return false;
   }

   size_t length = strlen(phrase);
   printf("length(%zu)\n", length);

   char count[26];

   if (length < 2) {
      return true;
   }

   for (int i = 0; i < 26; i++) {
      count[i] = 0;
   }

   for (size_t i = 0; i < length; i++) {

      if (!isalpha(phrase[i])) {
         continue;
      }

      int pos = tolower(phrase[i]) - 'a';
      count[pos] += 1;

      if (count[pos] > 1) {
         return false;
      }
   }


   return true;
}
