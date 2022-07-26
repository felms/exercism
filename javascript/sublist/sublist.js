export class List {
  constructor(items = []) {
    this._items = items;
  }

  compare(otherList) {

    let len = this.size();
    let otherLen = otherList.size();

    if (len === otherLen) {

      if (len === 0) {
        return 'EQUAL';
      }

      for (let i = 0; i < len; i++) {
        if (this.values()[i] !== otherList.values()[i]) {
          return 'UNEQUAL';
        }
      }

      return 'EQUAL';

    }

    if (len === 0) {
      return 'SUBLIST';
    }

    if (otherLen === 0) {
      return 'SUPERLIST';
    }

    if (len > otherLen) {

      let diff = len - otherLen;
      let prev = diff;
      let post = 0;

      while (prev >= 0) {

        let arr = [...this.values()].slice(prev);
        arr = arr.slice(0, arr.length - post);

        if (JSON.stringify(arr) === JSON.stringify(otherList.values())) {
          return 'SUPERLIST';
        }
        prev--;
        post++;
      }

    } else if (len < otherLen) {

      let diff = otherLen - len;
      let prev = diff;
      let post = 0;

      while (prev >= 0) {

        let arr = [...otherList.values()].slice(prev);
        arr = arr.slice(0, arr.length - post);

        if (JSON.stringify(arr) === JSON.stringify(this.values())) {
          return 'SUBLIST';
        }
        prev--;
        post++;
      }
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
