def response(hey_bob):

    hey_bob = hey_bob.strip()

    if hey_bob == "":
        return "Fine. Be that way!"

    if is_yelling(hey_bob) and is_question(hey_bob):
        return "Calm down, I know what I'm doing!"

    if is_yelling(hey_bob):
        return "Whoa, chill out!"

    if is_question(hey_bob):
        return "Sure."

    return "Whatever."


def is_question(phrase):
    return phrase.endswith("?")

def is_yelling(phrase):
    return phrase.isupper()