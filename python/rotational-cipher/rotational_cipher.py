LOWER_ALPHABET = "abcdefghijklmnopqrstuvwxyz" 
UPPER_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

def encode_letter(letter, key):

    if not letter.isalpha():
        return letter

    alphabet = LOWER_ALPHABET if letter.islower() else UPPER_ALPHABET

    position = (alphabet.find(letter) + key) % 26

    return alphabet[position]

def rotate(text, key):

    res = ""
    
    for letter in text:
        res += encode_letter(letter, key)

    return res
