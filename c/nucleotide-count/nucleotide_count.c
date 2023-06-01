#include "nucleotide_count.h"

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *count(const char *dna_strand) {
    int countA = 0;
    int countC = 0;
    int countG = 0;
    int countT = 0;

    for (size_t i = 0; i < strlen(dna_strand); i++) {
        
        switch(dna_strand[i]) {
            case 'A':
                countA++;
                break;

            case 'C':
                countC++;
                break;
            
            case 'G':
                countG++;
                break;

            case 'T':
                countT++;
                break;

            default:
                return calloc(1, 1);
        }
    }

    char *res = malloc(sizeof(char) * 30);
    snprintf(res, 30, "A:%d C:%d G:%d T:%d", countA, countC, countG, countT);

    return res;
}