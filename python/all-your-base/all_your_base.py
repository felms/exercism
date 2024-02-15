def rebase(input_base, digits, output_base):

    if input_base < 2:
        raise ValueError("input base must be >= 2")

    if output_base < 2:
        raise ValueError("output base must be >= 2")

    if not all(0 <= d < input_base for d in digits):
        raise ValueError("all digits must satisfy 0 <= d < input base")

    if not digits:
        return [0]

    number_in_base_10 = base_n_to_base_10(digits, input_base)

    return base_10_to_base_n(number_in_base_10, output_base)

def base_10_to_base_n(number, output_base):
    if number == 0:
        return [0]

    digits = []

    while number > 0:
        number, digit = divmod(number, output_base)
        digits.insert(0, digit)

    return digits

def base_n_to_base_10(digits, input_base):
    res = 0
    digits.reverse()
    
    for index, digit in enumerate(digits):
        res += digit * (input_base ** index)

    return res
