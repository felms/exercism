def primes(limit):
    if limit < 2:
        return []

    sieve = [True]*(limit + 1)
    sieve[0] = False
    sieve[1] = False

    res = []

    for i in range(2, limit + 1):
        if sieve[i]:
            res.append(i)
            for j in range(2 * i, limit + 1, i):
                sieve[j] = False

    return res
