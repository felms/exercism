def is_isogram(string):
    lower_str = string.replace("-", "").replace(" ", "").lower()
    return len(set(lower_str)) == len(lower_str)
