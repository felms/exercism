#include "high_scores.h"

#include <stdlib.h>
#include <string.h>

int compare( const void *arg1, const void *arg2 );

/// Return the latest score.
int32_t latest(const int32_t *scores, size_t scores_len) {

    return scores[scores_len - 1];
}

/// Return the highest score.
int32_t personal_best(const int32_t *scores, size_t scores_len) {

    int32_t highest = -1;

    for (size_t i = 0; i < scores_len; i++) {
        if (scores[i] > highest) {
            highest = scores[i];
        }
    }

    return highest;
}

/// Write the highest scores to `output` (in non-ascending order).
/// Return the number of scores written.
size_t personal_top_three(const int32_t *scores, size_t scores_len,
                          int32_t *output) {

    int32_t sorted_scores[scores_len];
    memcpy(sorted_scores, scores, sizeof(sorted_scores));
    qsort(sorted_scores, scores_len, sizeof(int), compare);
    size_t i = 0;

    for (; i < 3 && i < scores_len; i++) {
        output[i] = sorted_scores[i];
    }

    return i;
}


int compare( const void *arg1, const void *arg2 ) {
    return ( *(int*)arg2 - *(int*)arg1 );
}