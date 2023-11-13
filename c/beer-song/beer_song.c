#include "beer_song.h"

void recite(uint8_t start_bottles, uint8_t take_down, char **song) {


    uint16_t pointer = 0;
    uint8_t limit = start_bottles - (take_down - 1);

    for (int8_t i = start_bottles; i >= limit; i--) {
        verse(i, pointer, song);
        pointer += (i > 0) ? 3 : 2;

    }

}

void verse(uint16_t verse_number, uint16_t pointer, char **song) {

    char generic_verse[][MAX_LINE_LENGTH] = 
    {"%d bottles of beer on the wall, %d bottles of beer.",
        "Take one down and pass it around, %d %s of beer on the wall."};

    char penultimate_verse[][MAX_LINE_LENGTH] = 
    {"1 bottle of beer on the wall, 1 bottle of beer.",
        "Take it down and pass it around, no more bottles of beer on the wall."};

    char final_verse[][MAX_LINE_LENGTH] = 
    {"No more bottles of beer on the wall, no more bottles of beer.",
        "Go to the store and buy some more, 99 bottles of beer on the wall."};

    if (verse_number == 0) {
        strcpy(song[pointer++], final_verse[0]);
        strcpy(song[pointer++], final_verse[1]);
    } else if (verse_number == 1) {
        strcpy(song[pointer++], penultimate_verse[0]);
        strcpy(song[pointer++], penultimate_verse[1]);
        strcpy(song[pointer++], "");
    } else {

        char generic_0[MAX_LINE_LENGTH];
        sprintf(generic_0, generic_verse[0], verse_number, verse_number);

        char generic_1[MAX_LINE_LENGTH];
        sprintf(generic_1, generic_verse[1], 
                (verse_number - 1), (verse_number > 2 ? "bottles" : "bottle"));

        strcpy(song[pointer++], generic_0);
        strcpy(song[pointer++], generic_1);
        strcpy(song[pointer++], "");
    }

}
