class DoublyLinkedList<T> {
    private Element<T> head;

    void push(T value) {

        if(this.head == null) {
            this.head = new Element<>(value, null, null);
            return;
        } 

        Element<T> newNode = new Element<>(value, null, null);
        Element<T> pointer = this.head;

        while(pointer.next != null) {
            pointer = pointer.next;
        }

        newNode.prev = pointer;
        pointer.next = newNode;

    }

    T pop() {

        if (this.head.next == null) {
            T data = this.head.value;
            this.head = null;
            return data;
        } 

        Element<T> current = this.head;
        Element<T> lastNode = this.head.next;

        while(lastNode.next != null) {
            current = lastNode;
            lastNode = lastNode.next;
        }

        current.next = null;
        return lastNode.value;
    }

    void unshift(T value) {

        Element<T> newNode = new Element<>(value, null, null);

        if (this.head != null) {
            this.head.prev = newNode;
            newNode.next = this.head;
        }

        this.head = newNode;
    }

    T shift() {

        T data = this.head.value;
        this.head = this.head.next;

        return data;
    }

    private static final class Element<T> {
        private final T value;
        private Element<T> prev;
        private Element<T> next;

        Element(T value, Element<T> prev, Element<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
