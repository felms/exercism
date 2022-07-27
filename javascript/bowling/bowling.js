export class Bowling {

  constructor () {
    this.rollList = [];
  }

  roll(pins) {
    if (pins < 0) {
      throw new Error('Negative roll is invalid');
    }

    if (pins > 10) {
      throw new Error('Pin count exceeds pins on the lane');
    }

    if (this.rollList.length === 20) {
      let throw0 = this.rollList[this.rollList.length - 1];
      if (throw0 < 10 && pins < 10 && throw0 + pins > 10) {
        throw new Error('Pin count exceeds pins on the lane');

      }

      let throw1 = this.rollList[this.rollList.length - 2];
      if (throw0 < 10 && throw1 === 10 && pins === 10) {
        throw new Error('Pin count exceeds pins on the lane');
      }

      if (throw0 < 10 && throw1 < 10 && throw0 + throw1 < 10) {
        throw new Error('Cannot roll after game is over');
      }

    }

    if (this.rollList.length === 21) {
      throw new Error('Cannot roll after game is over');
    }

    if (this.rollList.length > 0 && this.rollList.length % 2 !== 0) {
      let throw0 = this.rollList[this.rollList.length - 1];
      if (throw0 < 10 && pins < 10 && pins + throw0 > 10) {
        throw new Error('Pin count exceeds pins on the lane');
      }

    }

    this.rollList.push(pins);
  }

  score() {

    if (this.rollList.length < 12) {
      throw new Error('Score cannot be taken until the end of the game');
    }

    let totalScore = 0;

    while(this.rollList.length > 0) {
      let throw0 = this.rollList.shift();


      if (throw0 < 10) {
        let throw1 = this.rollList.shift();
        let currentScore = throw0 + throw1;


        // Open frame
        if (currentScore < 10) {
          totalScore += currentScore;
        }

        // Spare
        if (currentScore == 10) {

          if (this.rollList.length === 0) {
            throw new Error('Score cannot be taken until the end of the game');
          }

          let throw2 = this.rollList.length === 1
                        ? this.rollList.shift() : this.rollList[0];

          totalScore += currentScore + throw2;
        }
      } else { // Strike
        if (this.rollList.length === 2) {
          totalScore += throw0;

          let throwBonus0 = this.rollList.shift();
          let throwBonus1 = this.rollList.shift();

          totalScore += throwBonus0 + throwBonus1;
        } else if (this.rollList.length > 2){
          totalScore += throw0
            + this.rollList[0] + this.rollList[1];
        } else if (this.rollList.length < 2) {
          throw new Error('Score cannot be taken until the end of the game');
        }
      }
    }

    return totalScore;
  }
}
