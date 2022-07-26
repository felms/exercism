export class List {
  constructor(items = []) {
    this._items = items;
  }

  compare(otherList) {
    let thisArr = this.values().toString();
    let otherArr = otherList.values().toString();

    if (thisArr === otherArr) {
      return 'EQUAL';
    }

    if (thisArr.includes(otherArr)) {
      return 'SUPERLIST';
    }

    if (otherArr.includes(thisArr)) {
      return 'SUBLIST';
    }

    return 'UNEQUAL';
  }

  size() {
    return this._items.length;
  }

  values() {
    let arr = [...this._items];
    return arr;
  }
}
