#include "armstrong_numbers.h"
#include <math.h>

int get_digits(int);

bool is_armstrong_number(int candidate)
{
    if (candidate == 0)
    {
        return true;
    }

    int n = candidate;
    int sum = 0;
    int power = get_digits(candidate);
    while (n > 0)
    {
        int digit = n % 10;
        sum += pow(digit, power);
        n /= 10;
    }

    return sum == candidate;
}

int get_digits(int number)
{

    int n = number;
    int digits = 0;
    while (n > 0)
    {
        digits++;
        n /= 10;
    }

    return digits;
}