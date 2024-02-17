import re

class Luhn:
    def __init__(self, card_num):
        self.card_num = card_num

    def valid(self):
        cleaned_string = re.sub('\\s+', '', self.card_num)[::-1]

        if cleaned_string == '0' or cleaned_string == "":
            return False

        if re.search('\\D', cleaned_string) != None:
            return False

        sum = 0

        for index, number in enumerate(cleaned_string):
            if index % 2 != 0:
                num = int(number) * 2
                sum += num - 9 if num > 9 else num

            else:
                sum += int(number)

        return sum % 10 == 0

