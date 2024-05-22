import random

from string import ascii_uppercase as letters
from string import digits as digits


class Robot:
    def __init__(self):
        self.name = self.create_name()

    def create_name(self):
        random.seed()
        name_letters = random.choices(letters, k=2)
        name_digits = random.choices(digits, k=3)

        return ''.join(name_letters + name_digits)

    def reset(self):
        self.name = self.create_name()
