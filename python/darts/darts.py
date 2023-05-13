import math

def score(x, y):
    distance = distance_between_points(0, 0, x, y)

    if distance <= 1:
        return 10

    if distance <= 5:
        return 5

    if distance <= 10:
        return 1

    return 0

def distance_between_points(x_1, y_1, x_2, y_2):
    return math.sqrt(((x_2 - x_1) ** 2) + ((y_2 - y_1) ** 2))
