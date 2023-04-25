import string


def is_pangram(sentence):

    if not sentence:
        return False

    for letter in string.ascii_lowercase:
        if letter not in sentence.lower():
            return False

    return True
