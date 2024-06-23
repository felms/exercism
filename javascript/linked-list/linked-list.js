export class LinkedList {

    constructor() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    push(data) {

        let node = new Node(data);
        node.previous = this.tail;

        if (this.size === 0) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
        this.size++;
    }

    pop() {

        let data = this.tail.value;
        this.size--;

        if (this.size === 0) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.previous;
            this.tail.next = null;
        }

        return data;
    }

    shift() {
        let data = this.head.value;
        this.size--;

        if (this.size === 0) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }

        return data;
    }

    unshift(data) {

        let node = new Node(data);
        node.next = this.head;

        if (this.size === 0) {
            this.head = node;
            this.tail = node;
        } else {
            this.head.prev = node;
            this.head = node;
        }

        this.size++;
    }

    delete(item) {
        let nodeToDelete = null;
        let currentNode = this.head;

        while (currentNode !== null) {
            if (currentNode.value === item) {
                if (currentNode.previous !== null) {
                    currentNode.previous.next = currentNode.next;
                } else {
                    this.head = currentNode.next;
                }

                if (currentNode.next !== null) {
                    currentNode.next.previous = currentNode.previous;
                } else {
                    this.tail = currentNode.previous;
                }

                this.size--;
                break;
            }

            currentNode = currentNode.next;
        }
    }

    count() {
        return this.size;
    }
}

class Node {

    constructor (value) {
        this.value = value;
        this.previous = null;
        this.next = null;
    }
}
