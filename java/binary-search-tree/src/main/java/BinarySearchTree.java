import java.util.List;

class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    void insert(T value) {
        Node<T> node = new Node<>(value);

        if (this.root == null) {
            this.root = node;
        } else {
            T currentNodeData = this.root.getData();
            if (value.compareTo(currentNodeData) > 0) {
                this.root.right = node;
            } else {
                this.root.left = node;
            }
        }
    }

    List<T> getAsSortedList() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    List<T> getAsLevelOrderList() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    Node<T> getRoot() {
        return this.root;
    }

    static class Node<T> {

        private Node<T> left;
        private Node<T> right;
        private T data;

        public Node(T data) {
            this.left = null;
            this.right = null;
            this.data = data;
        }

        Node<T> getLeft() {
            return this.left;
        }

        Node<T> getRight() {
            return this.right;
        }

        T getData() {
            return this.data;
        }

    }
}
