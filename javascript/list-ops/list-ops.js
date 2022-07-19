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

    map(callbackFunction) {
        let arr = [];

        for (let item of this.values) {
            let mappedItem = callbackFunction(item);
            arr.push(mappedItem);
        }
        return new List(arr);

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
        let arr = [...this._items];
        let newArr = [];

        while(arr.length > 0) {
            newArr.push(arr.pop());
        }

        return new List(newArr);
    }

}
