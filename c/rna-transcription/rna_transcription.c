#include "rna_transcription.h"

#include <stdlib.h>
#include <string.h>

char *to_rna(const char *dna) {

    char *result = (char*)malloc(sizeof(char) * strlen(dna) + 1);

    for (size_t i = 0; i < strlen(dna); i++) {
        switch (dna[i]) {
            case 'G':
                result[i] = 'C';
                break;
            case 'C':
                result[i] = 'G';
                break;
            case 'T':
                result[i] = 'A';
                break;
            case 'A':
                result[i] = 'U';
                break;
            default:
                break;
        }
    }

    result[strlen(dna)] = '\0';

    return result;
}