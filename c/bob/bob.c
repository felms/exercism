#include "bob.h"

#include <ctype.h>
#include <string.h>

char *hey_bob(char *greeting) {

    if (is_question(greeting) && is_yell(greeting)) {
        return "Calm down, I know what I'm doing!";
    }

    if (is_question(greeting)) {
        return "Sure.";
    }

    if (is_yell(greeting)) {
        return "Whoa, chill out!";
    }

    if (is_silence(greeting)) {
        return "Fine. Be that way!";
    }

    return "Whatever.";
}

bool is_question(char *phrase) {
    size_t len = strlen(phrase);

    for (int i = len - 1; i >= 0; i--) {
        char current_char = phrase[i];

        if (current_char == '?') {
            return true;
        }

        if (isspace(current_char)) {
            continue;
        }

        return false;
    }

    return false;
}

bool is_yell(char *phrase) {

    int len = strlen(phrase);
    bool has_letters = false;
    bool all_upper = true;

    for (int i = 0; i < len; i++) {
        char current_char = phrase[i];
        if (isalpha(current_char)) {
            has_letters = true;
        }

        if (isalpha(current_char) && !isupper(current_char)) {
            all_upper = false;
        }
    }

    return has_letters && all_upper;
}

bool is_silence(char *phrase) {
    
    int len = strlen(phrase);

    if (len == 0) {
        return true;
    }

    for (int i = 0; i < len; i++) {
        
        char current_char = phrase[i];
        if (!isspace(current_char)) {
            return false;
        }
    }

    return true;
}
