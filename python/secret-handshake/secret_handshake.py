""" 
    --- Secret Handshake ---

    You are starting a secret coding club with some friends and friends-of-friends. 
    Not everyone knows each other, so you and your friends have decided to create a 
    secret handshake that you can use to recognize that someone is a member. 
    You don't want anyone who isn't in the know to be able to crack the code.

    You've designed the code so that one person says a number between 1 and 31, 
    and the other person turns it into a series of actions.
"""


def commands(binary_str):
    """Transforms one binary number into a series of actions"""

    command = int(binary_str, 2)

    code = {
        1: "wink",
        2: "double blink",
        4: "close your eyes",
        8: "jump"
    }

    handshake = [action for number, action in code.items() if command & number]

    if command & 16:
        handshake.reverse()

    return handshake
