export class List {
  constructor(items = []) {
      this._data = items;
  }

  get values() {
      return [...this._data];
  }

  append(otherList) {
      return new List([...this._data, ...otherList.values]);
  }

  concat(lists) {
      let r = this.values;
      for (let l of lists.values) {
          r.push(...l.values);
      }

      return new List(r);
  }

  filter(predicate) {
      let r = [];
      for (let item of this.values) {
          if (predicate(item)) {
              r.push(item);
          }
      }

      return new List(r);
  }

  map(transform) {
      let r = [];
      for (let item of this.values) {
          r.push(transform(item))
      }

      return new List(r);
  }

  length() {
      return this._data.length;
  }

  foldl(reducer, initialValue) {
      let acc = initialValue;
      for (let item of this.values) {
          acc = reducer(acc, item);
      }
      return acc;
  }

  foldr(reducer, initialValue) {
      let acc = initialValue;
      let items = this.values;
      while (items.length > 0) {
          acc = reducer(acc, items.pop());
      }
      return acc;
  }

  reverse() { 
      let r = [];
      let items = this.values;
      while (items.length > 0) {
          r.push(items.pop());
      }
      return new List(r);
  }
}
