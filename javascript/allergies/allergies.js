const allergens = {
        'eggs' :1,
        'peanuts' :2,
        'shellfish' :4,
        'strawberries' :8,
        'tomatoes' :16,
        'chocolate' :32,
        'pollen' :64,
        'cats' :128
    };

export class Allergies {

    constructor(score) {
        this.score = score;
    }

    list() {
        return Object.keys(allergens)
            .filter(allergen => this.allergicTo(allergen));
    }

    allergicTo(allergen) {
        return (this.score & allergens[allergen]) != 0;
    }
}
