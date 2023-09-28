#include "matching_brackets.h"


#include <string.h>
#include <stdlib.h>

bool is_paired(const char *input) {
   
   int len = strlen(input);
   char* stack = malloc(sizeof(char) * len);

   int pos = 0;

   for (int i = 0; i < len; i++) {
      char current_char = input[i];

      if (current_char == '(' || current_char == '{' || current_char == '[') {
         stack[pos] = current_char;
         pos++;
      } else if (current_char == ')' || current_char == '}' || current_char == ']') {

         pos--;

         if ((current_char == ')' && stack[pos] != '(') 
               || (current_char == '}' && stack[pos] != '{') 
               || (current_char == ']' && stack[pos] != '[')) {
            free(stack);
            return false;
         }

      }       

   }
   
   free(stack);
   return pos == 0;
}
