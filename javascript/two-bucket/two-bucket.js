export class TwoBucket {

  constructor(bucketOne, bucketTwo, goal, starterBuck) {

    // if the desired quantity is not a multiple
    // of the greatest common divisor of bucketOne and bucketTwo
    // this instance of the problem doesn't have a solution
    let g = gcd(bucketOne, bucketTwo);

    if (goal % g !== 0) {
      throw new Error('Is impossible');
    }

    // if the goal is larger than both buckets
    // this instance of the problem doesn't have a solution
    if (goal > bucketOne && goal > bucketTwo) {
      throw new Error('Is impossible');
    }


    this.bucketOne = new Bucket('one', bucketOne);
    this.bucketTwo = new Bucket('two', bucketTwo);
    this.goal = goal;
    this.starterBuck = starterBuck;
  }

  solve() {

    let currentBucket = this.starterBuck === 'one' ? this.bucketOne : this.bucketTwo;
    let otherBucket = this.starterBuck === 'one' ? this.bucketTwo : this.bucketOne;
    let numberOfActions = 0;

    while (currentBucket.filled !== this.goal
      && otherBucket.filled !== this.goal) {

      if (currentBucket.filled === 0) {
        currentBucket.filled = currentBucket.capacity;

      } else if (otherBucket.capacity === this.goal) {

        otherBucket.filled = this.goal;

      } else if (!otherBucket.isFull) {
        let quantity = currentBucket.filled;

        if (otherBucket.currentCapacity >= quantity) {
          otherBucket.filled = otherBucket.filled + quantity;
          quantity = 0;
        } else {
          quantity = quantity - otherBucket.currentCapacity;
          otherBucket.filled = otherBucket.capacity;
        }

        currentBucket.filled = quantity;

      } else if (otherBucket.isFull) {
        otherBucket.filled = 0;
      }

      numberOfActions++;
    }

    if (otherBucket.filled === this.goal) {
      let aux = currentBucket;
      currentBucket = otherBucket;
      otherBucket = aux;
    }

    return { 
      moves: numberOfActions, 
      goalBucket: currentBucket.name, 
      otherBucket: otherBucket.filled 
    };

  }


}

const gcd = (a, b) => {

  if (b === 0) {
    return a;
  }

  return gcd (b, a % b);
};

class Bucket {

  #name;
  #capacity;
  #filled;

  constructor(name, capacity) {
    this.#name = name;
    this.#capacity = capacity;
    this.#filled = 0;
  }

  get name() {
    return this.#name;
  }

  get capacity() {
    return this.#capacity;
  }

  get filled() {
    return this.#filled;
  }

  get isFull() {
    return this.#capacity === this.#filled;
  }

  get currentCapacity() {
    return this.#capacity - this.#filled;
  }

  set filled(litters) {
    this.#filled = litters;
  }

}
