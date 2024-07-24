export class BinarySearchTree {

    #data;
    #left;
    #right;

    constructor(data) {
        this.#data = data;
        this.#left = null;
        this.#right = null;
    }

    get data() {
        return this.#data;
    }
    get right() {
        return this.#right;
    }

    get left() {
        return this.#left;
    }

    insert(value) {
        if (value > this.#data) {
            if (this.#right === null) {
                this.#right = new BinarySearchTree(value);
            } else {
                this.#right.insert(value);
            }
        } else {
            if (this.#left === null) {
                this.#left = new BinarySearchTree(value);
            } else {
                this.#left.insert(value);
            }
        }
    }

    each(func) {
        if (this.#left !== null) {
            this.#left.each(func);
        }

        func(this.#data);

        if (this.#right !== null) {
            this.#right.each(func);
        }
    }
}
