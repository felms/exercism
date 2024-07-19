export class CustomSet {

    #items;
    constructor(items = []) {
        this.#items = items;
    }

    empty() {
        return this.#items.length === 0;
    }

    contains(item) {
        return this.#items.includes(item);
    }

    add(item) {
        let newItems = [...this.#items];
        if (!newItems.includes(item)) {
            newItems.push(item);
        }
        return new CustomSet(newItems);
    }

    subset(otherSet) {
        return this.empty() 
            || this.#items.every(item => otherSet.contains(item));
    }

    disjoint(otherSet) {
        return this.empty() && otherSet.empty()
            || !this.#items.some(item => otherSet.contains(item));
    }

    eql(otherSet) {
        return this.subset(otherSet) && otherSet.subset(this);
    }

    union(otherSet) {
        this.#items.forEach(item => otherSet = otherSet.add(item));
        return otherSet;
    }

    intersection(otherSet) {
        let newItems = this.#items.filter(item => otherSet.contains(item));
        return new CustomSet(newItems);
    }

    difference(otherSet) {
        let newItems = this.#items.filter(item => !otherSet.contains(item));
        return new CustomSet(newItems);
    }
}
