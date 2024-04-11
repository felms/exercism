#include "scrabble_score.h"

#include <ctype.h>
#include <string.h>

unsigned int score(const char *word) {


    unsigned int letter_values[] = 
                {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
    //          {a  b  c  d  e  f  g  h  i  j  k  l  m  n  o  p  q   r  s  t  u  v  w  x  y  z } 
    
    unsigned int sum = 0;

    for (size_t i = 0; i < strlen(word); i++) {
        int pos = tolower(word[i]) - 'a';
        sum += letter_values[pos];
    }

    return sum;

}
