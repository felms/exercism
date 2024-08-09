import re


class PhoneNumber:
    def __init__(self, number):

        if re.search("[a-z]", number):
            raise ValueError("letters not permitted")

        if re.search("[:punct:]", number):
            raise ValueError("punctuations not permitted")

        n = re.sub("\\D", "", number)

        if len(n) < 10:
            raise ValueError("must not be fewer than 10 digits")

        if len(n) > 11:
            raise ValueError("must not be greater than 11 digits")

        if re.search("[^1]\\d{10}", number):
            raise ValueError("11 digits must start with 1")

        self.number = n if len(n) == 10 else n[1:]
        self.area_code = self.number[0:3]

        if self.area_code[0] in "01":
            ac = "zero" if self.area_code[0] == "0" else "one"
            raise ValueError(f'area code cannot start with {ac}')

        if self.number[3] in "01":
            ac = "zero" if self.number[3] == "0" else "one"
            raise ValueError(f'exchange code cannot start with {ac}')

    def pretty(self):
        return f'({self.number[0:3]})-{self.number[3:6]}-{self.number[6:]}'
