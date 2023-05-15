#include "collatz_conjecture.h"

int steps(int start) {

   if (start < 1) {
      return -1;
   }

   int number_of_steps = 0;
   
   while (start > 1) {
      if (start % 2 == 0) {
         start /= 2;
      } else {
         start = 3 * start + 1;
      }

      number_of_steps++;
   }

   return number_of_steps;
}
