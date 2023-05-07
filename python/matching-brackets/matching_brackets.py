def is_paired(input_string):
    stack = []

    for letter in input_string:
        if letter in ["[", "{", "("]:
            stack.append(letter) 
        elif letter in ["]", "}", ")"]:
            if len(stack) == 0:
                return False
            
            if (letter == "]" and stack[-1] == "[") \
                or (letter == "}" and stack[-1] == "{") \
                or (letter == ")" and stack[-1] == "("):
                stack.pop()
            else:
                return False
        
    return len(stack) == 0

