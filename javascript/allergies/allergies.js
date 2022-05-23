//
// This is only a SKELETON file for the 'Allergies' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

export class Allergies {
  constructor(score) {
    this.allergens = [];
    let binaryScore = Number.parseInt(score.toString(2));
    if (binaryScore % 2 != 0) {
      this.allergens.push("eggs");
    }
    binaryScore = Math.floor(binaryScore / 10);

    if (binaryScore % 2 != 0) {
      this.allergens.push("peanuts");
    }
    binaryScore = Math.floor(binaryScore / 10);

    if (binaryScore % 2 != 0) {
        this.allergens.push("shellfish");
    }
    binaryScore = Math.floor(binaryScore / 10);

    if (binaryScore % 2 != 0) {
        this.allergens.push("strawberries");
    }
    binaryScore = Math.floor(binaryScore / 10);

    if (binaryScore % 2 != 0) {
        this.allergens.push("tomatoes");
    }
    binaryScore = Math.floor(binaryScore / 10);

    if (binaryScore % 2 != 0) {
        this.allergens.push("chocolate");
    }
    binaryScore = Math.floor(binaryScore / 10);

    if (binaryScore % 2 != 0) {
        this.allergens.push("pollen");
    }
    binaryScore = Math.floor(binaryScore / 10);

    if (binaryScore % 2 != 0) {
        this.allergens.push("cats");
    }
    binaryScore = Math.floor(binaryScore / 10);
  }

  list() {
    return this.allergens;
  }

  allergicTo(allergen) {
    return this.allergens.includes(allergen);
  }
}
