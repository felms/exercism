#include "square_root.h"

#include <stdbool.h>

int square_root(int number) 
{

   int sqrt = 0;
   bool found = false;

   while(!found)
   {
      sqrt++;
      found = sqrt * sqrt == number;
   }

   return sqrt;
}
