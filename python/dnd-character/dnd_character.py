import random


def modifier(input):
    return (input - 10) // 2


class Character:

    def __init__(self):
        self.strength = self.ability()
        self.dexterity = self.ability()
        self.constitution = self.ability()
        self.intelligence = self.ability()
        self.wisdom = self.ability()
        self.charisma = self.ability()

        self.hitpoints = 10 + modifier(self.constitution)

    def ability(self):
        scores = [random.randint(1, 6) for _ in range(4)]
        return sum(sorted(scores, reverse=True)[0:3])
