import math

def is_armstrong_number(number):
    return number == 0 or sum_of_digits(number) == number

def sum_of_digits(number):
    number_of_digits = int(math.log10(number) + 1)
    sum = 0

    while (number > 0):
        digit = number % 10
        sum += digit ** number_of_digits
        number //= 10

    return sum

