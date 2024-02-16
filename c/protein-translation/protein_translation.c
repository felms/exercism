#include "protein_translation.h"

#include <string.h>

protein_t translate(const char *codon);

proteins_t proteins(const char *const rna) {
    
    if (strcmp(rna, "") == 0) {
        return (proteins_t) {
            .valid = true,
            .count = 0,
        };
    }

    size_t count = 0;
    proteins_t res = (proteins_t) {
        .valid = true,
        .count = 0,
    };

    char codon[4];
    int len = strlen(rna);

    for (int off = 0; off < len; off += 3) {
        strncpy(codon, rna + off, 3);
        codon[3] = '\0';

        protein_t protein = translate(codon);

        if (protein == INVALID) {
            return (proteins_t) {
                .valid = false,
            };
        }

        if (protein == STOP) {
            return res;
        }

        res.proteins[count++] = protein;
        res.count = count;
    }

    return res;
}

protein_t translate(const char *codon) {
    
    if (strcmp(codon, "AUG") == 0) {
        return Methionine;
    }

    if (strcmp(codon, "UUU") == 0 || strcmp(codon, "UUC") == 0) {
        return Phenylalanine;
    }

    if (strcmp(codon, "UUA") == 0 || strcmp(codon, "UUG") == 0) {
        return Leucine;
    }

    if (strcmp(codon, "UCU") == 0 || strcmp(codon, "UCC") == 0
         || strcmp(codon, "UCA") == 0 || strcmp(codon, "UCG") == 0) {
        return Serine;
    }

    if (strcmp(codon, "UAU") == 0 || strcmp(codon, "UAC") == 0) {
        return Tyrosine;
    }

    if (strcmp(codon, "UGU") == 0 || strcmp(codon, "UGC") == 0) {
        return Cysteine;
    }

    if (strcmp(codon, "UGG") == 0) {
        return Tryptophan;
    }
    
    if (strcmp(codon, "UAA") == 0 || strcmp(codon, "UAG") == 0
         || strcmp(codon, "UGA") == 0) {
        return STOP;
    }

    return INVALID;

}
