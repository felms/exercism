import java.util.NoSuchElementException;

public class SimpleLinkedList<T> {

    private int numberOfItems;
    private Node head;

    public SimpleLinkedList() {
        this.head = new Node();
        this.numberOfItems = 0;
    }

    public SimpleLinkedList(T[] items) {
        this.head = new Node();
        this.numberOfItems = 0;

        for (T item : items) {
            this.push(item);
        }
    }

    // Insere item na lista
    public void push(T item) {
        Node node = new Node(item, null);
        Node n = this.head;
        this.head = node;
        this.head.next = n;
        this.numberOfItems++;

    }

    // Remove item da lista
    public T pop() {
        if (this.numberOfItems < 1) {
            throw new NoSuchElementException();
        }

        T item = this.head.item;
        this.head = this.head.next;
        this.numberOfItems--;

        return item;
    }

    // Tamanho da lista
    public int size() {
        return this.numberOfItems;
    }

    // Retorna a lista como um array
    @SuppressWarnings("unchecked")
    public T[] asArray(Class<T> class1) {
        
        T[] arr = (T[]) new Object[this.numberOfItems];

        Node n = this.head;
        for (int i = 0; i < this.numberOfItems; i++) {
            arr[i] = n.item;
            n = n.next;
        }

        return arr;
    }

    @SuppressWarnings("unchecked")
    public T[] asArray() {
        T[] arr = (T[]) new Object[this.numberOfItems];

        Node n = this.head;
        for (int i = 0; i < this.numberOfItems; i++) {
            arr[i] = n.item;
            n = n.next;
        }

        return arr;
    }

    
    // Reverte a ordem dos elementos da lista
    public void reverse() {
        T[] items = this.asArray();
        int num = this.numberOfItems;
        this.head = new Node();
        this.numberOfItems = 0;

        for (int i = 0; i < num; i++) {
            this.push(items[i]);
        }

    }

    // Classe Node para armazenar os dados
    private class Node {
        
        T item;
        Node next;

        public Node() {
            this(null, null);
        }

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

    }
    
}

