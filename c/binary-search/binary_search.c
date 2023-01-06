#include "binary_search.h"


const int *binary_search(int value, const int *arr, size_t length) {

    if (length <= 0) {
        return NULL;
    }

    int low = 0;
    int high = length;

    while (low <= high) {
        int m = (low + high) / 2;

        if (value == arr[m]) {
            return &arr[m];
        }

        if (value > arr[m]) {
            low = m + 1;
        } else {
            high = m - 1;
        }
    }

    return NULL;
}