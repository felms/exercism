def translate(text):
    words = map(translate_word, text.split())

    return " ".join(words)

def translate_word(text):
    vowels = set({"a", "e", "i", "o", "u", "xr", "yt"})

    if text[0] in vowels or text[0:2] in vowels:
        return text + "ay"

    if len(text) == 2 and text[1] == "y":
        return text[1] + text[0] + "ay"

    if text[0:2] == "qu":
        return translate(text[2:] + text[0:2])

    return translate(text[1:] + text[0])
    