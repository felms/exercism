import re
import string


def count_words(sentence):

    regex = "^'+|'+$|\\s'|'\\s|[^'a-zA-Z0-9]"

    words = re.sub(regex, " ", sentence.lower()).split()

    word_freq = {}

    for word in words:
        word_freq[word] = words.count(word)

    return word_freq
