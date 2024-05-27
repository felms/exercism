import re

PLAIN = "abcdefghijklmnopqrstuvwxyz"
CIPHER = PLAIN[::-1]


def encode(plain_text):
    encoded = "".join(
        CIPHER[PLAIN.index(x)] if x in PLAIN else x
        for x in re.sub(r'\W', "", plain_text).lower())

    return " ".join(encoded[x: x + 5] for x in range(0, len(encoded), 5))


def decode(ciphered_text):
    return "".join(
        PLAIN[CIPHER.index(x)] if x in CIPHER else x
        for x in re.sub(r'\s+', '', ciphered_text))
