#include "armstrong_numbers.h"
#include <math.h>

bool is_armstrong_number(int candidate)
{
    int number = candidate;
    int sum = 0;
    int power = (int) log10(number) + 1;

    while (number > 0) {
        int digit = number % 10;
        sum += pow(digit, power);
        number /= 10;
    }

    return sum == candidate;
}