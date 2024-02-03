#include "circular_buffer.h"

#include <stdlib.h>
#include <errno.h>

circular_buffer_t *new_circular_buffer(int16_t capacity) {

    circular_buffer_t *buffer = malloc(sizeof(circular_buffer_t));

    buffer->capacity = capacity;
    buffer->values = malloc(capacity * sizeof(buffer_value_t));
    buffer->number_of_elements = 0;
    buffer->oldest_elem_position = 0;
    buffer->last_inserted_position = 0;

    return buffer;
}

int16_t write(circular_buffer_t *buffer, buffer_value_t value) {

    if (buffer->number_of_elements == buffer->capacity) {
        errno = ENOBUFS;
        return EXIT_FAILURE;
    }

    if (buffer->number_of_elements == 0) {
        buffer->values[0] = value;
    } else {
        int16_t position = (buffer->last_inserted_position + 1) % buffer->capacity;
        buffer->values[position] = value;
        buffer->last_inserted_position = position;
    }

    buffer->number_of_elements++;

    return EXIT_SUCCESS;
}

int16_t overwrite(circular_buffer_t *buffer, buffer_value_t value) {

    if (buffer->number_of_elements < buffer->capacity) {
        return write(buffer, value);
    }

    buffer->last_inserted_position = buffer->oldest_elem_position;

    buffer->values[buffer->oldest_elem_position] = value;
    buffer->oldest_elem_position = (buffer->oldest_elem_position + 1) % buffer->capacity;

    return EXIT_SUCCESS;

}

int16_t read(circular_buffer_t *buffer, buffer_value_t *value) {

    if (buffer->number_of_elements == 0) {
        errno = ENODATA;
        return EXIT_FAILURE;
    }

    *value = buffer->values[buffer->oldest_elem_position];

    if (buffer->number_of_elements == 1) {
        clear_buffer(buffer);
    } else {
        buffer->number_of_elements--;
        buffer->oldest_elem_position = (buffer->oldest_elem_position + 1) % buffer->capacity;
    }

    return EXIT_SUCCESS;
}

void clear_buffer(circular_buffer_t *buffer) {
    
    buffer->number_of_elements = 0;
    buffer->oldest_elem_position = 0;
    buffer->last_inserted_position = 0;
}

void delete_buffer(circular_buffer_t *buffer) {

    free(buffer->values);
    free(buffer);
}

