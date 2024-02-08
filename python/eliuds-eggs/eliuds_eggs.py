def egg_count(display_value):

    number = display_value

    count = 0

    while number > 0:
        count += (number & 1)
        number = number >> 1

    return count
