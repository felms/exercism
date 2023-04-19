# Score categories.
# Change the values as you see fit.
YACHT = 0
ONES = 1
TWOS = 2
THREES = 3
FOURS = 4
FIVES = 5
SIXES = 6
FULL_HOUSE = 7
FOUR_OF_A_KIND = 8
LITTLE_STRAIGHT = 9
BIG_STRAIGHT = 10
CHOICE = 11


def score(dice, category):

    dice.sort()

    if category == YACHT:
        return score_yacht(dice)

    if category == CHOICE:
        return sum(dice)
    
    if category == BIG_STRAIGHT:
        return 30 if dice == [2, 3, 4, 5, 6] else 0

    if category == LITTLE_STRAIGHT:
        return 30 if dice == [1, 2, 3, 4, 5] else 0

    if category == FOUR_OF_A_KIND:
        return score_four_of_a_kind(dice)
    
    if category == FULL_HOUSE:
        return score_full_house(dice)
    
    return score_categories(dice, category)

def score_yacht(dice):
    return 50 if len(set(dice)) == 1 else 0

def score_categories(dice, category):
    return category * dice.count(category)

def score_four_of_a_kind(dice):
    elem_0 = dice[0]
    elem_1 = dice[1]
    if dice.count(elem_0) >= 4:
        return elem_0 * 4
    
    if dice.count(elem_1) >= 4:
        return elem_1 * 4

    return 0

def score_full_house(dice):
    elem = dice[0]

    if len(set(dice)) == 2 and (dice.count(elem) == 2 or dice.count(elem) == 3):
        return sum(dice)

    return 0
