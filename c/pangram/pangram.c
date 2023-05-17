#include "pangram.h"

#include <ctype.h>
#include <string.h>

bool is_pangram(const char *sentence) {

    // In case od NULL and empty
    if (!sentence) {
        return false;
    }

    // to lowercase
    char lower_sentence[strlen(sentence)];
    for (int i = 0; sentence[i] != '\0'; i++) {
        lower_sentence[i] = tolower(sentence[i]);
    }

    char *alphabet = "abcdefghijklmnopqrstuvwxyz";

    for (; *alphabet; alphabet++) {
        if (strchr(lower_sentence, *alphabet) == NULL) {
            return false;
        }
    }

    return true;
}