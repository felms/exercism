"""
--- Nth Prime ---

Given a number n, determine what the nth prime is.

By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, 
we can see that the 6th prime is 13.

"""


import math

def prime(number) -> int:
    """ Returns the nth prime number """

    if number == 0:
        raise ValueError('there is no zeroth prime')

    count = 0
    i = 0
    prime_number = 0
    while count < number:
        if is_prime(i):
            prime_number = i
            count += 1
        i += 1

    return prime_number

def is_prime(number) -> bool:
    """ Tests if a number is prime """

    if number < 2:
        return False

    if number == 2:
        return True

    if number % 2 == 0:
        return False

    for i in range(3, int(math.sqrt(number)) + 1, 2):
        if (number % i) == 0:
            return False

    return True
