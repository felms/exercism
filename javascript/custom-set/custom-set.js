export class CustomSet {
    constructor(input = []) {
        this.items = input;
    }

    empty() {
        return this.items.length === 0;
    }

    contains(item) {
        return this.items.includes(item);
    }

    add(item) {
        let arr = [...this.items];
        if (!this.contains(item)) {
            arr.push(item);
        }
        return new CustomSet(arr);
    }

    subset(otherSet) {
        if (this.empty()) {
            return true;
        }

        return this.items.every(item => otherSet.contains(item));
    }

    disjoint(otherSet) {
        return this.items.every(item => !otherSet.contains(item));
    }

    eql(otherSet) {
        return this.subset(otherSet) && otherSet.subset(this);
    }

    union(otherSet) {

        let thisArr = [...this.items];

        otherSet.values().forEach(item => {
            if (!thisArr.includes(item)) {
                thisArr.push(item);
            }
        });

        return new CustomSet(thisArr);
    }

    intersection(otherSet) {
        let interArr = [];

        for (let item of this.items) {
            if (otherSet.contains(item)) {
                interArr.push(item);
            }
        }

        return new CustomSet(interArr);
    }

    difference(otherSet) {
        let interArr = [];

        for (let item of this.items) {
            if (!otherSet.contains(item)) {
                interArr.push(item);
            }
        }

        return new CustomSet(interArr);
    }

    values() {
        let arr = [...this.items];
        return arr;
    }
}
