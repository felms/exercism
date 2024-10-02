import math
import re


def cipher_text(plain_text):

    # cleaning the input
    text = plain_text.lower()
    text = re.sub(r'[\W]', '', text)

    if not text:
        return text

    # size of each word
    cols = math.ceil(math.sqrt(len(text)))

    # separating into chunks and padding
    regex = ".{1," + str(cols) + "}"
    chunks = list(map(lambda w: w.ljust(cols), re.findall(regex, text)))

    # 'zipping' the chunks together and creating the return string
    return " ".join(["".join(w) for w in zip(*chunks)])
