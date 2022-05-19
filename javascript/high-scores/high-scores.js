//
// This is only a SKELETON file for the 'High Scores' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

export class HighScores {
  constructor(input) {
    this.scoreList = [...input];
  }

  get scores() {
    return this.scoreList;
  }

  get latest() {
    return this.scoreList[this.scoreList.length - 1];
  }

  get personalBest() {
    return Math.max(...this.scoreList);
  }

  get personalTopThree() {
    let sortedArray = [...this.scoreList].sort((a, b) => b - a);
    return sortedArray.slice(0, 3);
  }
}
