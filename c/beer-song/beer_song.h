#ifndef BEER_SONG_H
#define BEER_SONG_H

#define MAX_LINE_LENGTH (1024)

#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void recite(uint8_t start_bottles, uint8_t take_down, char **song);
void verse(uint16_t verse_number, uint16_t pointer, char **song);

#endif
