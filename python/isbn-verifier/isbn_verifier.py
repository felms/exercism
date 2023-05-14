import string

def is_valid(isbn):

    isbn = isbn.replace("-", "")

    if len(isbn) != 10:
        return False

    numbers = list(isbn)

    if numbers[-1] == "X":
        numbers[-1] = "10"

    res = 0

    for index, number in enumerate(reversed(numbers), 1):
        if number in string.ascii_letters:
            return False
        res += int(number) * index

    return res % 11 == 0
