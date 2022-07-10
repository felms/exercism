export class BinarySearchTree {

    constructor(data) {
        this._data = data;
        this._left = null;
        this._right = null;
    }

    get data() {
        return this._data;
    }
    get right() {
        return this._right;
    }

    get left() {
        return this._left;
    }

    insert(number) {

        if (number > this._data) {
            if (this._right) {
                this._right.insert(number);
            } else {
                this._right = new BinarySearchTree(number);
            }
        } else {
            if (this._left) {
                this._left.insert(number);
            } else {
                this._left = new BinarySearchTree(number);
            }
        }

    }

    each(callback) {
        if (this._left) {
            this._left.each(callback);
        }

        callback(this._data);

        if (this._right) {
            this._right.each(callback);
        }
    }
}
