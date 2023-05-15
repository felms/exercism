#include "raindrops.h"

#include <stdio.h>
#include <string.h>

char* convert(char result[], int drops) {
    
    if (drops % 3 == 0) {
        result = strcat(result, "Pling");
    }

    if (drops % 5 == 0) {
        result = strcat(result, "Plang");
    }

    if (drops % 7 == 0) {
        result = strcat(result, "Plong");
    }

    if (strlen(result) == 0) {
        snprintf(result, 16, "%d", drops);
    }

    return result;
}