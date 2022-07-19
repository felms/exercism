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

    foldl(callbackFunction, acc) {
        let arr = [...this._items];
        let res = acc;

        for (let item of arr) {
            res = callbackFunction(res, item);
        }

        return res;
    }

    foldr(callbackFunction, acc) {
        let arr = [...this._items];
        let res = acc;

        while (arr.length > 0) {
            let item = arr.pop();
            res = callbackFunction(res, item);
        }

        return res;
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
