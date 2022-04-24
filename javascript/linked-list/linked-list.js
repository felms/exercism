//
// This is only a SKELETON file for the 'Linked List' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

export class LinkedList {

  constructor() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  // Insert value at back
  push(value) {
    let n = new Node(value);
    if(this.size === 0) {
      this.head = n;
      this.tail = n;
    } else {
      n.previous = this.tail;
      this.tail.next = n;
      this.tail = n;
    }

    this.size++;
  }

  // Remove value at back
  pop() {
    let data = this.tail.data;
    
    if (this.size > 1) {
      this.tail = this.tail.previous;
      this.tail.next = null;
    } else {
      this.tail = null;
      this.head = null;
    }

    this.size--;
    
    return data;
  }

  // Remove value at front
  shift() {
    let data = this.head.data;
    this.head.previous = null;
    this.head = this.head.next;
    this.size--;

    return data;
  }

  // Insert value at front
  unshift(value) {
    let n = new Node(value);
    if (this.size === 0) {
      this.head = n;
      this.tail = n;
    } else {
      n.next = this.head;
      this.head.previous = n;
      this.head = n;
    }

    this.size++;
  }

  delete(value) {
    let n = this.head;
    let previousNode = null;

    while (n != null && n.data != value) {
      previousNode = n;
      n = n.next;
    }
    
    // if the element is not found return null
    if (n === null) {
      return;
    }

    // if removing the first node
    if (n.previous === null) {
      this.head = n.next;
    }

    // if removing the last node
    if (n.next === null) {
      this.tail = n.previous;
    }


    let nextNode = n.next;
    if (previousNode != null) {
      previousNode.next = nextNode;
    }

    if (nextNode != null) {
      nextNode.previous = previousNode;
    }

    n.previous = null;
    n.next = null;
    this.size--;
  }

  count() {
    return this.size;
  }
}


class Node {

  constructor(data) {
    this.data = data;
    this.previous = null;
    this.next = null;
  }
}