export class List {

    #items;
    #size;
    constructor(items = []) {
        this.#items = [...items];
        this.#size = items.length;
    }

    compare(otherList) {
        if (List.#equal(this, otherList)) {
            return 'EQUAL';
        }

        if (List.#sublist(this, otherList)) {
            return 'SUBLIST';
        }

        if (List.#sublist(otherList, this)) {
            return 'SUPERLIST';
        }

        return 'UNEQUAL';
    }

    get length() {
        return this.#size;
    }

    static #equal(listA, listB) {

        if (listA.length !== listB.length) {
            return false;
        }

        if (listA.length == 0 && listB.length == 0) {
            return true;
        }

        let [headA, ...tailA] = listA;
        let [headB, ...tailB] = listB;

        return headA === headB && List.#equal(tailA, tailB);
    }

    static #sublist(listA, listB) {

        if (listA.length === 0) {
            return true;
        }

        if (listB.length < listA.length) {
            return false;
        }

        let s = listA.length;
        let arr = [...listB];
        return [...Array(listB.length - s + 1).keys()]
                .some(i => List.#equal(listA, arr.slice(i, s + i)));
                
    }

    [Symbol.iterator]() {
        var index = -1;
        var data = this.#items;

        return {
            next: () => ({ value: data[++index], done: !(index in data) })
        };
    }

}
