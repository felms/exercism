import re


def abbreviate(words):
    words_list = re.sub('(_|-)', ' ', words.upper()).split()

    return "".join(map(lambda word: word[0], words_list))
