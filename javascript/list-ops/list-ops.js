export class List {
    constructor(items = []) {
        this._items = items;
    }

    append(otherList) {
        let arr = [...this._items];

        for (let item of otherList.values) {
            arr.push(item);
        }
        return new List(arr);
    }

    get values() {
        return this._items;
    }

    concat(otherList) {
        let arr = [...this._items];
        let newArr = [];

        for (let item of otherList.values) {
            arr.push(...item.values);
        }
        return new List(arr);
    }

    filter(predicate) {
        let arr = [];

        for (let item of this.values) {
            if (predicate(item)) {
                arr.push(item);
            }
        }
        return new List(arr);
    }

    map() {
        throw new Error('Remove this statement and implement this function');
    }

    length() {
        return this._items.length;
    }

    foldl() {
        throw new Error('Remove this statement and implement this function');
    }

    foldr() {
        throw new Error('Remove this statement and implement this function');
    }

    reverse() {
        throw new Error('Remove this statement and implement this function');
    }

}
