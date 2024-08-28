from string import ascii_uppercase as strings


def rows(letter):
    size = (strings.find(letter) - strings.find("A")) * 2
    res = []
    delta = size // 2
    print(delta)

    for i in range(delta + 1):
        current_letter = strings[i]
        empty_string = [" "] * (size + 1)
        empty_string[delta - i] = current_letter
        empty_string[delta + i] = current_letter
        res.append("".join(empty_string))

    rest = res[:delta]
    rest.reverse()
    res.extend(rest)

    return res
