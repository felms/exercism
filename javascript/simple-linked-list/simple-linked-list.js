export class Element {
    constructor(value) {
        this._value = value;
        this._next = null;
    }

    get value() {
        return this._value;
    }

    get next() {
        return this._next;
    }
}

export class List {
    constructor(args) {
        this._head = null;
        this._length = 0;

        if (args) {
            args.forEach(item => this.add(new Element(item))); 
        }
    }

    add(newElement) {
        if (this._length === 0) {
            this._head = newElement;
        } else {
            newElement._next = this._head;
            this._head = newElement;
        }
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

        let currentElement = this._head;
        while (currentElement !== null) {
            arr.push(currentElement.value);
            currentElement = currentElement.next;
        }

        return arr;
    }

    reverse() {
        return new List(this.toArray());
    }
}
