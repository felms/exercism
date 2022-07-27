export const abilityModifier = (input) => {

  if (input < 3) {
    throw new Error('Ability scores must be at least 3');
  }

  if (input > 18) {
    throw new Error('Ability scores can be at most 18');
  }
  
  let m = input - 10;
  return Math.floor(m / 2.0);
};

export class Character {

  constructor() {
    this._strength = Character.rollAbility();
    this._dexterity = Character.rollAbility();
    this._constitution =  Character.rollAbility();
    this._intelligence =  Character.rollAbility();
    this._wisdom = Character.rollAbility();
    this._charisma = Character.rollAbility();
    this._hitPoints = 10 + abilityModifier(this._constitution);
  }

  static rollAbility() {
    let d1 = this.randomIntFromInterval(1, 6);
    let d2 = this.randomIntFromInterval(1, 6);
    let d3 = this.randomIntFromInterval(1, 6);
    let d4 = this.randomIntFromInterval(1, 6);

    let arr = [d1, d2, d3, d4];
    arr.sort((a, b) => a - b);
    let sum = 0;

    for (let i = 3; i > 0; i--) {
      sum += arr[i];
    }

    return sum;
  }

  get strength() {
    return this._strength;
  }

  get dexterity() {
    return this._dexterity;
  }

  get constitution() {
    return this._constitution;
  }

  get intelligence() {
    return this._intelligence;
  }

  get wisdom() {
    return this._wisdom;
  }

  get charisma() {
    return this._charisma;
  }

  get hitpoints() {
    return this._hitPoints;
  }

  static randomIntFromInterval(min, max) { // min and max included
    return Math.floor(Math.random() * (max - min + 1) + min)
  }
}
