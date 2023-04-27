def largest_product(series, size):
    
    if size > len(series):
        raise ValueError("span must be smaller than string length")
    
    if size < 0:
        raise ValueError("span must not be negative")
    
    if not series.isnumeric():
        raise ValueError("digits input must only contain digits")

    
    max_value = 0

    for i in range(len(series) - size + 1):
        num = series[i:i + size]
        max_value = max(max_value, str_prod(num))

    return max_value


def str_prod(number):
    prod = 1

    for num in number:
        prod = prod * int(num)

    return prod

