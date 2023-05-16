#include "secret_handshake.h"

#include <stdlib.h>

const char **commands(size_t number) {

    const char **actions = malloc(sizeof(char*) * 4);
    actions[0] = NULL;
    int num_of_actions = 0;

    if (number & 1) {
        actions[num_of_actions++] = "wink";
    }

    if (number & 2) {
        actions[num_of_actions++] = "double blink";
    }

    if (number & 4) {
        actions[num_of_actions++] = "close your eyes";
    }

    if (number & 8) {
        actions[num_of_actions++] = "jump";
    }

    if (number & 16) {
        const char **reversed = malloc(sizeof(char*) * 4);
        int rev = 0;
        for (int i = num_of_actions - 1; i >= 0; i--){
            reversed[rev++] = actions[i];
        }

        return reversed;
    }

    return actions;
}
