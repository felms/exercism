class Allergies:

    allergens = { 
        "eggs" :1, 
        "peanuts" :2, 
        "shellfish" :4, 
        "strawberries" :8, 
        "tomatoes" :16, 
        "chocolate" :32, 
        "pollen" :64, 
        "cats" :128 
        }

    def __init__(self, score):
        self.score = score

    def allergic_to(self, item):
        return Allergies.allergens[item] & self.score != 0

    @property
    def lst(self):
        res = []

        for key in Allergies.allergens.keys():
            if self.allergic_to(key):
                res.append(key)

        return res
