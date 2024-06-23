import java.lang.reflect.Array;
import java.util.NoSuchElementException;

class SimpleLinkedList<T> {
    private int length;
    private Node<T> head;

    SimpleLinkedList() {
        this.length = 0;
        this.head = null;
    }

    SimpleLinkedList(T[] values) {
        this.length = 0;

        for (T value : values) {
            this.push(value);
        }
    }

    void push(T value) {
        Node<T> node = new Node(value, this.head);
        this.head = node;
        this.length++;
    }

    T pop() {

        if (this.length == 0) {
            throw new NoSuchElementException();
        }

        T data = this.head.value;
        this.head = this.head.next;
        this.length--;
        return data;
    }

    void reverse() {
        Node<T> p = this.head;
        this.head = null;

        while(p != null) {
            this.push(p.value);
            p = p.next;
        }

    }

    T[] asArray(Class<T> clazz) {
        T[] array = (T[]) Array.newInstance(clazz, this.length);
        Node<T> p = this.head;

        for (int i = 0; i < this.length; i++) {
            array[i] = p.value;
            p = p.next;
        }

        return array;
    }

    int size() {
        return this.length;
    }

    private class Node<T> {

        T value;
        Node<T> next;

        Node (T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

    }
}


