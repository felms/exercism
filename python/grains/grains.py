def square(number):
    if number < 1 or number > 64:
        raise ValueError("square must be between 1 and 64")

    return 2 ** (number - 1)


def total():
    q = 2
    n = 64
    
    return (q ** n - 1)
