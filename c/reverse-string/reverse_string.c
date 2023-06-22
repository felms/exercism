#include "reverse_string.h"

#include <stdlib.h>
#include <string.h>

char *reverse(const char *value) {

   int len = strlen(value);
   char *rev = malloc(sizeof(char) * len);
   strcpy(rev, value);

   int left = 0;
   int right = len - 1;

   while (left < right) {
      char aux = rev[left];
      rev[left] = rev[right];
      rev[right] = aux;

      left++;
      right--;
   }

   return rev;
}
