def square_root(number):
    found = False
    root = 0

    while not found:
        root += 1
        if root ** 2 == number:
            found = True

    return root
