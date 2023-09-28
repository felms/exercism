"""
Parses and evaluates simple math word problems
returning the answer as an integer.
"""

def answer(question):

    """ Evaluates the expression """

    if not question.startswith("What is"):
        raise ValueError("unknown operation")

    question = question.replace("What is ", "").replace("?", "").replace("by ", "")


    expression = question.split()

    if not expression[0].lstrip("-").isnumeric():
        raise ValueError("syntax error")

    res = int(expression.pop(0))

    while expression:

        oper = expression.pop(0)

        if oper.lstrip("-").isnumeric():
            raise ValueError("syntax error")

        if oper not in ["plus", "minus", "multiplied", "divided"]:
            raise ValueError("unknown operation")

        if len(expression) % 2 == 0:
            raise ValueError("syntax error")

        second = int(expression.pop(0))

        if oper == "plus":
            res = res + second

        elif oper == "minus":
            res = res - second

        elif oper == "multiplied":
            res = res * second

        elif oper == "divided":
            res = res // second

    return res
