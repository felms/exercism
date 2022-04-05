/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/

public class DoublyLinkedList<T> {

    Node head;
    Node tail;
    int size;

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Insert value at back
    public void push(T data) {
        Node n = new Node(data, null, null);
        
        if (size == 0) {
            this.head = n;
            this.tail = n;
        } else {
            n.previous = this.tail;
            this.tail.next = n;
            this.tail = n;
        }
        
        size++;
    }

    // Remove value at back
    public T pop() {

        if (size > 0) {
            T data = (T) this.tail.data;           
            this.tail = this.tail.previous;           

            size--;

            return data;
        }
        
        return null;
    }

    // Remove value at front
    public T shift() {
        if (size > 0) {
            T data = (T) this.head.data;
            this.head.previous = null;
            this.head = this.head.next;
            size--;

            return data;
        }

        return null;
    }

    // Insert value at front)
    public void unshift(T data) {
        Node n = new Node(data, null, null);
        
        if (size == 0) {
            this.head = n;
            this.tail = n;
        } else {
            n.next = this.head;
            this.head.previous = n;
            this.head = n;
        }

        size++;
    }

}

class Node<T> {

    T data;
    Node previous;
    Node next;

    Node(T data, Node previous, Node next) {
        this.data = data;
        this.previous = previous;
        this.next = next;
    }

}