def classify(number):
    """ A perfect number equals the sum of its positive divisors.

    :param number: int a positive integer
    :return: str the classification of the input integer
    """

    if number < 1:
        raise ValueError("Classification is only possible for positive integers.")
    
    al_sum = aliquot_sum(number)
    return "perfect" if number == al_sum else "abundant" if number < al_sum else "deficient"

def aliquot_sum(number):
    sum = 0

    for i in range(1, number):
        if number % i == 0:
            sum += i

    return sum
