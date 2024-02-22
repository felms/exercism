def score(word):

    return sum([score_letter(letter) for letter in word.upper()])

def score_letter(letter):

    letters_score = {
        'AEIOULNRST' : 1,
        'DG' : 2,
        'BCMP' : 3,
        'FHVWY' : 4,
        'K' : 5,
        'JX' : 8,
        'QZ' : 10
    }

    for (letters, value) in letters_score.items():
        if letter in letters:
            return value
