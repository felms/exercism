export class CustomSet {
    constructor(input = []) {
        this.items = input;
    }

    empty() {
        return this.items.length === 0;
    }

    contains(item) {
        return this.items.indexOf(item) >= 0;
    }

    add(item) {
        if (!this.contains(item)) {
            this.items.push(item);
        }
    }

    subset(otherSet) {
        if (this.empty()) {
            return true;
        }

        for (let item of this.items) {
            if (!otherSet.contains(item)) {
                return false;
            }
        }

        return true;
    }

    disjoint(otherSet) {
        return this.intersection(otherSet).empty(); 
    }

    eql(otherSet) {
        return this.subset(otherSet) && otherSet.subset(this);
    }

    union(otherSet) {

        for (let item of this.items) {
            if (!otherSet.contains(item)) {
                otherSet.add(item);
            }
        }

        return otherset;

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
}
