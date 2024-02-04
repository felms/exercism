def convert(number):

    lookup = [(3, "Pling"), (5, "Plang"), (7, "Plong")]

    res = ""

    for (factor, output) in lookup:
        if number % factor == 0:
            res += output

    return res if res else str(number)
