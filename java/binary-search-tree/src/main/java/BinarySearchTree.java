import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;
    private List<T> treeData;

    public BinarySearchTree() {
        this.root = null;
        treeData = new ArrayList<>();
    }

    void insert(T value) {
        Node<T> node = new Node<>(value);

        if (this.root == null) {
            this.root = node;
        } else {
            Node<T> currentNode = this.getRoot();
            boolean inserted = false;

            while (!inserted) {
                if (value.compareTo(currentNode.getData()) > 0) {

                    if (currentNode.right == null) {
                        currentNode.right = node;
                        inserted = true;
                    } else {
                        currentNode = currentNode.right;
                    }

                } else {
                    if (currentNode.left == null) {
                        currentNode.left = node;
                        inserted = true;
                    } else {
                        currentNode = currentNode.left;
                    }
                }
            }
            
        }
    }

    List<T> getAsSortedList() {
        this.treeData = new ArrayList<>();
        inOrderTraversal(this.root);
        return new ArrayList<T>(this.treeData);
    }

    List<T> getAsLevelOrderList() {

        ArrayList<Node<T>> nodes = new ArrayList<>();
        nodes.add(this.root);

        levelOrderTraversal(this.root, nodes);

        return nodes.stream()
                .map(n -> n.getData())
                .collect(Collectors.toList());

    }

    Node<T> getRoot() {
        return this.root;
    }

    private void inOrderTraversal(Node<T> node) {

        if (node == null) {
            return;
        }

        inOrderTraversal(node.getLeft());
        this.treeData.add(node.getData());
        inOrderTraversal(node.getRight());
    }

    private void levelOrderTraversal(Node<T> node, ArrayList<Node<T>> nodes) {

        if (node == null) {
            return;
        }

        if (node.getLeft() != null) {
            nodes.add(node.getLeft());
        }

        if (node.getRight() != null) {
            nodes.add(node.getRight());

        }

        levelOrderTraversal(node.getLeft(), nodes);
        levelOrderTraversal(node.getRight(), nodes);
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
