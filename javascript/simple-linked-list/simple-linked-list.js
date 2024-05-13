export class Element {
    constructor(element) {
        this._value = element;
        this._next = null;
    }

    get value() {
        return this._value;
    }

    get next() {
        return this._next;
    }

    set next(element) {
        this._next = element;
    }
}

export class List {
    constructor(items = []) {
        this._head = null;
        this._length = 0;

        for (let item of items) {
            this.add(new Element(item));
        }
    }

    add(nextValue) {
        nextValue.next = this._head;
        this._head = nextValue;
        this._length++;
    }

    get length() {
        return this._length;
    }

    get head() {
        return this._head;
    }

    toArray() {
        let arr = [];
        let head = this._head;

        while (head !== null) {
            arr.push(head.value);
            head = head.next;
        }
        return arr;
    }

    reverse() {
        let r = new List();
        let head = this._head;

        while (head !== null) {
            r.add(new Element(head.value));
            head = head.next;
        }
        return r;
    }
}
