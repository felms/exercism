#include "clock.h"

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

clock_t clock_create(int hour, int minute) {

    while (minute < 0) {
        minute += HOUR_IN_MINUTES;
        hour--;
    }
    
    if (minute >= HOUR_IN_MINUTES) {
        hour += (minute / HOUR_IN_MINUTES);
        minute = minute % HOUR_IN_MINUTES;
    } 

    while (hour < 0) {
        hour += DAY_IN_HOURS;
    }

    hour = hour < DAY_IN_HOURS ? hour : hour % DAY_IN_HOURS;

    char text[MAX_STR_LEN];
    snprintf(text, MAX_STR_LEN, "%02d:%02d", hour, minute);

    clock_t clock;
    strncpy(clock.text, text, MAX_STR_LEN);

    return clock;
}

clock_t clock_add(clock_t clock, int minute_add) {

    int hour;
    int minute;

    sscanf(clock.text, "%d:%d", &hour, &minute);

    return clock_create(hour, minute + minute_add);
}

clock_t clock_subtract(clock_t clock, int minute_subtract) {
    
    return clock_add(clock, -minute_subtract);
}

bool clock_is_equal(clock_t a, clock_t b) {
    return !strcmp(a.text, b.text);
}