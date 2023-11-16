#include "pythagorean_triplet.h"


triplets_t* triplets_with_sum(uint16_t sum) {

   triplets_t *res = malloc(sizeof(triplets_t));
   res->count = 0;

   for (uint16_t a = 1; a < (sum / 3); a++) {
      for (uint16_t b = a + 1; b <= (sum - a) / 2; b++) {
         uint16_t c = sqrt(a * a + b * b);
         if (a + b + c == sum
               && a < b && b < c
               && a * a + b * b == c * c) {

            triplet_t new_triplet = {a, b, c};

            res->triplets[res->count++] = new_triplet;

         }
      }
   }

   return res;

}

void free_triplets(triplets_t *triplets) {

   free(triplets);
}
