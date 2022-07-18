export class CustomSet {
  constructor(input = []) {
      this.items = input;
  }

  empty() {
      return this.items.length === 0;
  }

  contains(item) {
      return this.items.indexOf(item) >= 0;
  }

  add() {
    throw new Error('Remove this statement and implement this function');
  }

  subset() {
    throw new Error('Remove this statement and implement this function');
  }

  disjoint() {
    throw new Error('Remove this statement and implement this function');
  }

  eql() {
    throw new Error('Remove this statement and implement this function');
  }

  union() {
    throw new Error('Remove this statement and implement this function');
  }

  intersection() {
    throw new Error('Remove this statement and implement this function');
  }

  difference() {
    throw new Error('Remove this statement and implement this function');
  }
}
