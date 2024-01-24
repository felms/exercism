def factors(value):

    candidate = 2
    factors = []

    while value > 1:
        while value % candidate == 0:
            factors.append(candidate)
            value = value / candidate

        candidate += 1

    return factors

