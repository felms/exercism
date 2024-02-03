#ifndef CIRCULAR_BUFFER_H
#define CIRCULAR_BUFFER_H

#include <stdint.h>

typedef int16_t buffer_value_t;

typedef struct {
    int16_t capacity;
    buffer_value_t *values;
    int16_t number_of_elements;
    int16_t oldest_elem_position;
    int16_t last_inserted_position;
} circular_buffer_t;

circular_buffer_t *new_circular_buffer(int16_t capacity);
int16_t write(circular_buffer_t *buffer, buffer_value_t value);
int16_t overwrite(circular_buffer_t *buffer, buffer_value_t value);
int16_t read(circular_buffer_t *buffer, buffer_value_t *value);
void clear_buffer(circular_buffer_t *buffer);
void delete_buffer(circular_buffer_t *buffer);

#endif
