#include "knapsack.h"

#define MAX(x, y) (((x) > (y)) ? (x) : (y))


unsigned int max_val(unsigned int maximum_weight, item_t* items, size_t item_count, size_t pos, unsigned int current_value);

unsigned int maximum_value(unsigned int maximum_weight, item_t* items, size_t item_count) {
    return max_val(maximum_weight, items, item_count, 0, 0);
}

unsigned int max_val(unsigned int maximum_weight, item_t* items, size_t item_count, size_t pos, unsigned int current_value) {

    if (maximum_weight == 0 || item_count == item_pos) {
        return current_value;
    }

    item_t current_item = items[pos++];

    if (current_item.weight <= maximum_weight) {
        unsigned int with_item = max_val(maximum_weight - current_item.weight, items, item_count, pos, current_value + current_item.value);
        unsigned int without_item = max_val(maximum_weight, items, item_count, pos, current_value);

        return MAX(with_item, without_item);
    } else {
        return max_val(maximum_weight, items, item_count, pos, current_value);
    }
}
